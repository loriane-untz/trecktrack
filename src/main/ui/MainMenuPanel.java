package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

// represents the panel for the main menu
public class MainMenuPanel extends BackgroundPanel {

    private static final Color menuButtonColor = new Color(121, 96, 85);
    
    public MainMenuPanel() {
        super("assets/mainBackgroundIMG.png");
        setLayout(null);

        JButton completedButton = makeMenuButton("Completed");
        JButton toDoButton = makeMenuButton("To-Do");
        positionCompletedButton(this, completedButton);
        positionToDoButton(this, toDoButton);
    }

    // EFFECTS: creates a main menu button
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

    // EFFECTS: positions the completed button on the main window
    // MODIFIES: this
    public void positionCompletedButton(BackgroundPanel panel, JButton button) {
        button.setBounds(216, 280, 130, 50);
        panel.add(button);
    }

    // EFFECTS: positions the to-do button on the main window
    // MODIFIES: this
    public void positionToDoButton(BackgroundPanel panel, JButton button) {
        button.setBounds(359, 280, 130, 50); 
        panel.add(button);
    }
}
