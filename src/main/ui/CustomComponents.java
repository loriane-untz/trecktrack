package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


// represents a class containing different UI components
public class CustomComponents {

    private static final Color brown = new Color(121, 96, 85);

    public CustomComponents() {
    }

    // buttons

    // EFFECTS: styles all buttons
    public void styleButton(JButton button) {
        button.setBackground(brown);
        button.setForeground(brown);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
    }

    // EFFECTS: returns a menu button
    public JButton makeMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        return button;
    }

    // EFFECTS: returns a return button
    public JButton makeReturnButton() {
        JButton button = new JButton("←");
        button.setFont(new Font("Monospaced", Font.PLAIN, 50));
        button.setVerticalAlignment(SwingConstants.BOTTOM);
        styleButton(button);
        button.setBounds(45, 580, 65, 50);
        return button;
    }

    // EFFECTS: returns a add-hike button
    public JButton makeAddHikButton() {
        JButton button = new JButton("Add Hike");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        button.setBounds(535, 580, 120, 50);
        return button;
    }

    // EFFECTS: returns a add-info button
    public JButton makeEditInfoButton() {
        JButton button = new JButton("Edit Info");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        button.setBounds(350, 580, 140, 50);
        return button;
    }

    // EFFECTS: returns a delete hike button
    public JButton makeDeletedButton() {
        JButton button = new JButton("Delete Hike");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        button.setBounds(505, 580, 150, 50);
        return button;
    }

    public JButton makeCompleteButton() {
        JButton button = new JButton("Check off from to-do list");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        button.setBounds(100, 100, 200, 50);
        return button;
    }

    // list

    // EFFECTS: stylises a list of hikes
    public void settupHikeList(DefaultListModel<String> listModel, JList<String> hikeList, JPanel panelToAddTo) {
        hikeList.setForeground(Color.WHITE);
        hikeList.setOpaque(false);

        renderCell(hikeList);

        JScrollPane scrollPane = new JScrollPane(hikeList);
        scrollPane.setBounds(100, 180, 500, 350);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        panelToAddTo.add(scrollPane);
    }

    // EFFECTS: stylises the cells in the list of hikes
    public void renderCell(JList<String> hikeList) {
        hikeList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                JLabel label = new JLabel(value.toString());
                label.setFont(new Font("Monospaced", Font.BOLD, 20));
                label.setForeground(brown);
                label.setOpaque(true);
                label.setBackground(isSelected ? new Color(236, 237, 235) : Color.WHITE);
                label.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

                JPanel panel = new JPanel(new BorderLayout());
                panel.setOpaque(false);
                panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
                panel.add(label, BorderLayout.CENTER);

                return panel;
            }
        });
    }

    
}
