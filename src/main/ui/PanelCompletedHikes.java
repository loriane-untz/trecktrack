package ui;

import javax.swing.JButton;

// represents the panel for the completed hikes list
public class PanelCompletedHikes extends BackgroundPanel {

    private Buttons customButtons;
    private TreckTrackUI parent;

    public PanelCompletedHikes(TreckTrackUI parent) {
        super("assets/completed_background.jpg");
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
