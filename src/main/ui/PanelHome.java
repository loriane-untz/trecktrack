package ui;

import javax.swing.JButton;

// represents the panel for the main menu
public class PanelHome extends BackgroundPanel {

    private Components customButtons;
    private TreckTrackUI parent;
    private TreckTrackApp treckTrackApp;

    public PanelHome(TreckTrackUI parent, TreckTrackApp treckTrackApp) {
        super("assets/main_background.jpg");
        this.parent = parent;
        this.treckTrackApp = treckTrackApp;
        this.customButtons = new Components();
        setLayout(null);

        settupButtons();
    }

    public void settupButtons() {
        JButton completedButton = customButtons.makeMenuButton("Completed");
        completedButton.addActionListener(e -> parent.switchPanel("CompletedHikes"));
        positionCompletedButton(this, completedButton);
        
        JButton toDoButton = customButtons.makeMenuButton("To-Do");
        toDoButton.addActionListener(e -> parent.switchPanel("HikesToDo"));
        positionToDoButton(this, toDoButton);

        JButton loadButton = customButtons.makeMenuButton("Load");
        loadButton.addActionListener(e -> treckTrackApp.loadTreckTrack());
        positionLoadButton(this, loadButton);

        JButton saveButton = customButtons.makeMenuButton("Save");
        saveButton.addActionListener(e -> treckTrackApp.loadTreckTrack());
        positionSaveButton(this, saveButton);
    }

    // EFFECTS: positions the completed button on the main menu panel 
    // MODIFIES: this
    public void positionCompletedButton(BackgroundPanel panel, JButton button) {
        button.setBounds(216, 280, 130, 50);
        panel.add(button);
    }

    // EFFECTS: positions the to-do button on the main menu panel 
    // MODIFIES: this
    public void positionToDoButton(BackgroundPanel panel, JButton button) {
        button.setBounds(359, 280, 130, 50); 
        panel.add(button);
    }
    // EFFECTS: positions the load button on the main menu panel 
    // MODIFIES: this
    public void positionLoadButton(BackgroundPanel panel, JButton button) {
        button.setBounds(515, 590, 70, 45); 
        panel.add(button);
    }

    // EFFECTS: positions the save button on the main menu panel
    // MODIFIES: this
    public void positionSaveButton(BackgroundPanel panel, JButton button) {
        button.setBounds(600, 590, 70, 45); 
        panel.add(button);
    }
}
