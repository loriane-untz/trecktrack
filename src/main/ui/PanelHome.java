package ui;

import javax.swing.JButton;

// represents the panel for the main menu
public class PanelHome extends BackgroundPanel {

    private Buttons customButtons;
    private TreckTrackUI parent;
    //private TreckTrackApp treckTrackApp;

    
    public PanelHome(TreckTrackUI parent) {
        super("assets/main_background.jpg");
        this.parent = parent;
        customButtons = new Buttons();
        //this.treckTrackApp = treckTrackApp;
        setLayout(null);

        JButton completedButton = customButtons.makeMenuButton("Completed");
        JButton toDoButton = customButtons.makeMenuButton("To-Do");
        JButton loadButton = customButtons.makeMenuButton("Load");
        JButton saveButton = customButtons.makeMenuButton("Save");
        positionCompletedButton(this, completedButton);
        positionToDoButton(this, toDoButton);
        positionLoadButton(this, loadButton);
        positionSaveButton(this, saveButton);

        completedButton.addActionListener(e -> parent.switchPanel("CompletedHikes"));
        toDoButton.addActionListener(e -> parent.switchPanel("HikesToDo"));
        //loadButton.addActionListener(e -> treckTrackApp.loadTreckTrack());
        //saveButton.addActionListener(e -> treckTrackApp.loadTreckTrack());
    }

    // EFFECTS: positions the completed button on the main menu panel 
    // MODIFIES: this
    public void positionCompletedButton(BackgroundPanel panel, JButton button) {
        button.setBounds(216, 285, 130, 50);
        panel.add(button);
    }

    // EFFECTS: positions the to-do button on the main menu panel 
    // MODIFIES: this
    public void positionToDoButton(BackgroundPanel panel, JButton button) {
        button.setBounds(359, 285, 130, 50); 
        panel.add(button);
    }
    // EFFECTS: positions the load button on the main menu panel 
    // MODIFIES: this
    public void positionLoadButton(BackgroundPanel panel, JButton button) {
        button.setBounds(520, 30, 70, 45); 
        panel.add(button);
    }

    // EFFECTS: positions the save button on the main menu panel
    // MODIFIES: this
    public void positionSaveButton(BackgroundPanel panel, JButton button) {
        button.setBounds(600, 30, 70, 45); 
        panel.add(button);
    }
}
