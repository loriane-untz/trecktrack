package ui;

import javax.swing.JButton;

// represents the panel for the hikes to-do list
public class PanelHikesToDo extends BackgroundPanel {

    private Buttons customButtons;
    private TreckTrackUI parent;

    public PanelHikesToDo(TreckTrackUI parent) {
        super("assets/todo_background.jpg");
        this.parent = parent;
        customButtons = new Buttons();
        setLayout(null);

        JButton returnButton = customButtons.makeReturnButton();
        JButton addHikeButton = customButtons.makeAddHikButton();
        this.add(returnButton);
        this.add(addHikeButton);

        returnButton.addActionListener(e -> parent.switchPanel("MainMenu"));
        // addHikeButton.addActionListener(e -> treckTrackApp.addHike());
    }

    
}
