package edu.liberty.bemccandless.csis505.hw2.exercise1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author bemccandless
 */
public class SpamScoreCalculatorFrame extends JFrame {

    private final JTextArea messageArea;
    private final JButton clearBtn;
    private final JButton verifyBtn;
    
    public SpamScoreCalculatorFrame() {
        super("Spam Score Calculator");
        setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.add(new JLabel("Type or paste email text below:"));
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textPanel.add(headerPanel);
        textPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        messageArea = new JTextArea(20, 50);
        messageArea.setLineWrap(true);
        JScrollPane textScrollPane = new JScrollPane(messageArea);
        textPanel.add(textScrollPane);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        buttonPanel.add(Box.createHorizontalGlue());
        clearBtn = new JButton("Clear");
        verifyBtn = new JButton("Verify");
        buttonPanel.add(clearBtn);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(verifyBtn);
        
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
    }
}
