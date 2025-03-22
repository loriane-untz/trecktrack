package ui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Buttons extends JButton {

    private static final Color menuButtonColor = new Color(121, 96, 85);

    public Buttons() {

    }

    public void styleButton(JButton button) {
        button.setBackground(menuButtonColor);
        button.setForeground(menuButtonColor);
        button.setOpaque(true);
        button.setContentAreaFilled(false);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
    }

    // EFFECTS: returns a menu button
    public JButton makeMenuButton(String text) {
        JButton button = new JButton(text);
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

    // EFFECTS:  returns a add hike button
    public JButton makeAddHikButton() {
        JButton button = new JButton("Add Hike");
        button.setFont(new Font("Monospaced", Font.BOLD, 17));
        styleButton(button);
        button.setBounds(535, 580, 120, 50);
        return button;
    }

}
