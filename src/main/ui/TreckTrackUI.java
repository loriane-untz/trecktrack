package ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Represents the app's main window frame
public class TreckTrackUI extends JFrame {

    private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 700;

    private JPanel mainPanel;
    private CardLayout cardLayout;
    //private TreckTrackApp treckTrackApp;

    // EFFECTS: constructs the frame by setting up the main window
    public TreckTrackUI() {
        //this.treckTrackApp = treckTrackApp;

        setTitle("TreckTrack");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new MainMenuPanel(this), "MainMenu");
        mainPanel.add(new CompletedHikesPanel(this), "CompletedHikes");
        mainPanel.add(new HikesToDoPanel(this), "HikesToDo");

        setContentPane(mainPanel);
    }

    public void showUI() {
        setVisible(true);
    }

    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    

}
