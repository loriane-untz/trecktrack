package ui;

import javax.swing.JButton;

import model.TreckTrackApp;

// represents the panel for the main menu
public class PanelHome extends BackgroundPanel {

    private CustomComponents customButtons;
    private TreckTrackUI parent;
    private TreckTrackApp treckTrackApp;

    // constructs a home panel
    public PanelHome(TreckTrackUI parent, TreckTrackApp treckTrackApp) {
        super("assets/main_background.jpg");
        this.parent = parent;
        this.treckTrackApp = treckTrackApp;
        this.customButtons = new CustomComponents();
        setLayout(null);
        setupCompletedButton();
        setupToDoButton();
        setupLoadButton();
        setupSaveButton();
    }

    // MODIFIES: this
    // EFFECTS: makes a completed button and adds it to this panel; navigates
    // completed hikes list
    public void setupCompletedButton() {
        JButton completedButton = customButtons.makeMenuButton("Completed");
        completedButton.addActionListener(e -> parent.switchPanel("CompletedHikes"));
        completedButton.setBounds(216, 280, 130, 50);
        this.add(completedButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a to-do button and adds it to this panel; navigates to hikes
    // to-do list
    public void setupToDoButton() {
        JButton toDoButton = customButtons.makeMenuButton("To Do");
        toDoButton.addActionListener(e -> parent.switchPanel("HikesToDo"));
        toDoButton.setBounds(359, 280, 130, 50);
        this.add(toDoButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a load button and adds it to this panel; loads progress
    public void setupLoadButton() {
        JButton loadButton = customButtons.makeMenuButton("Load");
        loadButton.setBounds(515, 590, 70, 45);
        loadButton.addActionListener(e -> {
            treckTrackApp.loadTreckTrack();
            parent.addPanel("CompletedHikes", new PanelCompletedHikes(parent, treckTrackApp));
            parent.addPanel("HikesToDo", new PanelHikesToDo(parent, treckTrackApp));
        });
        this.add(loadButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a save button and adds it to this panel; saves progress
    public void setupSaveButton() {
        JButton saveButton = customButtons.makeMenuButton("Save");
        saveButton.addActionListener(e -> treckTrackApp.saveTreckTrack());
        saveButton.setBounds(600, 590, 70, 45);
        this.add(saveButton);
    }
}
