package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Represents the app's main window frame
public class TreckTrackUI extends JFrame {

    private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 700;

    private JPanel mainPanel;
    private CardLayout cardLayout;

    // EFFECTS: constructs the frame by setting up the main window
    public TreckTrackUI() {
        setTitle("TreckTrack");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MainMenuPanel(), "Main Menu");
        mainPanel.add(new CompletedHikesPanel(), "Completed Hikes");
        mainPanel.add(new HikesToDoPanel(), "Hikes To-Do");

        setContentPane(mainPanel);
    }

    public void showUI() {
        setVisible(true);
    }

    

}
