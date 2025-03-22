package ui;

import javax.swing.JButton;

// represents the panel for the hikes to-do list
public class HikesToDoPanel extends BackgroundPanel {

    private CustomButtons customButtons;
    private TreckTrackUI parent;

    public HikesToDoPanel(TreckTrackUI parent) {
        super("assets/todo_background.jpg");
        this.parent = parent;
        customButtons = new CustomButtons();
        setLayout(null);

        JButton returnButton = customButtons.makeReturnButton();
        JButton addHikeButton = customButtons.makeAddHikButton();
        this.add(returnButton);
        this.add(addHikeButton);

        returnButton.addActionListener(e -> parent.switchPanel("MainMenu"));
        // addHikeButton.addActionListener(e -> treckTrackApp.addHike());
    }

    
}
