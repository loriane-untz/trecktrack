package ui;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

// Represents the app's main UI window frame
public class TreckTrackUI extends JFrame {

    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_HEIGHT = 700;

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private TreckTrackApp treckTrackApp;

    // constructs treckTrackUI object, sets up main window frame
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

    // MODIFIES: this
    // EFFECTS: makes the UI visible
    public void showUI() {
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: switched to panel with given name
    public void switchPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    // MODIFIES: this
    // EFFECTS: adds panel with given name to the card layout
    public void addPanel(String name, JPanel panel) {
        mainPanel.add(panel, name);
    }

    public TreckTrackApp getTreckTrackApp() {
        return treckTrackApp;
    }
}
