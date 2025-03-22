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
    private TreckTrackApp treckTrackApp;

    // EFFECTS: constructs the frame by setting up the main window
    public TreckTrackUI(TreckTrackApp treckTrackApp) {
        this.treckTrackApp = treckTrackApp;

        setTitle("TreckTrack");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new PanelHome(this), "MainMenu");
        mainPanel.add(new PanelCompletedHikes(this), "CompletedHikes");
        mainPanel.add(new PanelHikesToDo(this), "HikesToDo");

        setContentPane(mainPanel);
    }

    public void showUI() {
        setVisible(true);
    }

    public void switchPanel(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    

}
