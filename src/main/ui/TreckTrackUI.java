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

        addPanel("MainMenu", new PanelHome(this, treckTrackApp));
        addPanel("CompletedHikes", new PanelCompletedHikes(this, treckTrackApp));
        addPanel("HikesToDo", new PanelHikesToDo(this, treckTrackApp));

        setContentPane(mainPanel);
    }

    // EFFECTS: makes the UI visible
    public void showUI() {
        setVisible(true);
    }

    // EFFECTS: switched to panel with given name
    public void switchPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    // EFFECTS: adds panel with given name to the card layout
    public void addPanel(String name, JPanel panel) {
        mainPanel.add(panel, name);
    }

    public TreckTrackApp getTreckTrackApp() {
        return treckTrackApp;
    }
}
