package ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class CustomButtons extends JButton {

    private static final Color menuButtonColor = new Color(121, 96, 85);

    public CustomButtons() {

    }

    // EFFECTS: returns a button
    public JButton makeMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        button.setBackground(menuButtonColor);
        button.setForeground(menuButtonColor);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        return button;
    }

    // EFFECTS: returns a return button
    public JButton makeReturnButton() {
        JButton button = new JButton("←");
        button.setFont(new Font("Monospaced", Font.PLAIN, 50));
        button.setVerticalAlignment(SwingConstants.BOTTOM);
        button.setBackground(menuButtonColor);
        button.setForeground(menuButtonColor);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setBounds(45, 580, 65, 50);
        return button;
    }

    // EFFECTS:  returns a add hike button
    public JButton makeAddHikButton() {
        JButton button = new JButton("Add Hike");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        button.setBackground(menuButtonColor);
        button.setForeground(menuButtonColor);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setBounds(535, 580, 120, 50);
        return button;
    }

}
