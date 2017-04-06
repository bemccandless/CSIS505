package edu.liberty.bemccandless.csis505.hw2.exercise2;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * This class handles placing the components on a frame for the user interface
 * 
 * @author bemccandless
 */
public class DateFormatterFrame extends JFrame {

    private final JButton convertBtn;
    private final JTextField dateField;
    private final JLabel dateLabel;
    
    /**
     * setup the frame for the user interface
     */
    public DateFormatterFrame() {
        super("Date Format Converter");
        setLayout(new BorderLayout());
        
        dateLabel = new JLabel("Enter date in the format mm/dd/yyyy:");
        dateLabel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        
        dateField = new JTextField(15);
        dateField.setMargin(new Insets(5, 5, 5, 5));
        
        DateConverter dateConverter = new DateConverter();
        convertBtn = new JButton("Convert");
        convertBtn.addActionListener((ActionEvent e) -> {
            try {
                JOptionPane.showMessageDialog(getContentPane(), String.format("The converted date is %s.", dateConverter.convertDate(dateField.getText())));
            } catch (InvalidDateException ex) {
                JOptionPane.showMessageDialog(getContentPane(), "An invalid date was specified. Please try again.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
            }
            dateField.grabFocus();
            dateField.selectAll();
        });
        
        JPanel dateFormatterPanel = new JPanel();
        dateFormatterPanel.setLayout(new GridBagLayout());
        dateFormatterPanel.add(dateLabel);
        dateFormatterPanel.add(dateField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 25, 15));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(convertBtn);
        
        add(dateFormatterPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
        
}
