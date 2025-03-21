package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

// Represents the app's main window frame
public class TreckTrackUI extends JFrame{

    private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 700;

    private static final Color menuButtonColor = new Color(121, 96, 85);

    // EFFECTS: constructs the frame by setting up the main window
    public TreckTrackUI() {
        settupMainWindow();
    }

    public void showUI() {
        setVisible(true);
    }

    // EFFECTS: creates the main menu window
    // MODIFIES: this
    public void settupMainWindow() {
        setTitle("TreckTrack");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        BackgroundPannel backgroundPanel = new BackgroundPannel("assets/mainBackgroundIMG.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(null);

        JButton completedButton = makeMenuButton("Completed");
        JButton toDoButton = makeMenuButton("To-Do");
        positionCompletedButton(backgroundPanel, completedButton);
        positionToDoButton(backgroundPanel, toDoButton);

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

    // EFFECTS: positions the bompleted button on the main window
    // MODIFIES: this
    public void positionCompletedButton(BackgroundPannel panel, JButton button) {
        button.setBounds(216, 280, 130, 50);
        panel.add(button);
    }

    // EFFECTS: positions the bompleted button on the main window
    // MODIFIES: this
    public void positionToDoButton(BackgroundPannel panel, JButton button) {
        button.setBounds(359, 280, 130, 50); 
        panel.add(button);
    }

}
