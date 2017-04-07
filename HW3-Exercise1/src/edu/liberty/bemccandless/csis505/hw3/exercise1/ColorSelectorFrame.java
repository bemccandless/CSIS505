package edu.liberty.bemccandless.csis505.hw3.exercise1;

import edu.liberty.bemccandless.csis505.hw3.exercise1.colors.ColorMap;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author bemccandless
 */
public class ColorSelectorFrame extends JFrame {
    
    private final JPanel background;
    private final JList colorList;
    private final JScrollPane scrollPane;
    
    public ColorSelectorFrame() {
        super("Color Selector");
        
        background = new JPanel();
        background.setLayout(new BorderLayout());
        
        colorList = new JList(
                ColorMap.getColors().keySet().stream()
                        .sorted()
                        .toArray()
        );
        colorList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        colorList.setLayoutOrientation(JList.VERTICAL);
        colorList.setVisibleRowCount(-1);
        colorList.setSelectedIndex(0);

        colorList.addListSelectionListener((ListSelectionEvent e) -> {
            background.setBackground(ColorMap.getColors().get(colorList.getSelectedValue().toString()));
        });
        
        scrollPane = new JScrollPane(colorList);
        JPanel colorListPanel = new JPanel();
        colorListPanel.add(scrollPane);
        
        background.setBackground(ColorMap.getColors().get(colorList.getSelectedValue().toString()));
        background.add(scrollPane, BorderLayout.WEST);
        
        add(background);
    }

}
