package edu.liberty.bemccandless.csis505.hw2.exercise1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class handles placing the components on a frame for the user interface
 * 
 * @author bemccandless
 */
public class SpamScoreCalculatorFrame extends JFrame {
    
    private final JTextArea messageArea;
    private final JButton clearBtn;
    private final JButton verifyBtn;
    private static final String SPAMCOUNT_MESSAGE = "The spam score for this message is %s.";
    private int spamCount;
    
    /**
     * setup the frame for the user interface
     */
    public SpamScoreCalculatorFrame() {
        super("Spam Score Calculator");
        setLayout(new BorderLayout());
        
        messageArea = new JTextArea(20, 50);
        messageArea.setLineWrap(true);
        
        clearBtn = new JButton("Clear");
        clearBtn.addActionListener((ActionEvent e) -> {
            messageArea.setText("");
            messageArea.grabFocus();
        });
        
        SpamCalculator spamCalculator = new SpamCalculator();
        verifyBtn = new JButton("Verify");
        verifyBtn.addActionListener((ActionEvent e) -> {
            spamCount = spamCalculator.calculateSpamCount(messageArea.getText());
            JOptionPane.showMessageDialog(getContentPane(), String.format(SPAMCOUNT_MESSAGE, spamCount));
            messageArea.grabFocus();
            messageArea.selectAll();
        });
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.add(new JLabel("Type or paste email text below:"));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPanel.add(headerPanel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        JScrollPane textScrollPane = new JScrollPane(messageArea);
        textPanel.add(textScrollPane);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(clearBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(verifyBtn);
        
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
}
