package ui;

import model.Hike;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

// represents the panel for the completed hikes list
public class PanelCompletedHikes extends BackgroundPanel {

    private CustomComponents components;
    private TreckTrackUI treckTrackUI;
    private TreckTrackApp treckTrackApp;
    private UserInputHandling userInputHandling;

    private DefaultListModel<String> listModel;
    private JList<String> hikeList;

    public PanelCompletedHikes(TreckTrackUI treckTrackUI, TreckTrackApp treckTrackApp) {
        super("assets/ completed_background.jpg");
        this.components = new CustomComponents();
        this.treckTrackUI = treckTrackUI;
        this.treckTrackApp = treckTrackApp;
        userInputHandling = new UserInputHandling();
        setLayout(null);
        settupButtons();
        settupHikeList();
    }

    public void settupButtons() {
        JButton returnButton = components.makeReturnButton();
        returnButton.addActionListener(e -> treckTrackUI.switchPanel("MainMenu"));
        this.add(returnButton);

        JButton addHikeButton = components.makeAddHikButton();
        addHikeButton.addActionListener(e -> addNewHike());
        this.add(addHikeButton);
    }

    public void settupHikeList() {
        listModel = new DefaultListModel<>();
        hikeList = new JList<>(listModel);
        components.settupHikeList(listModel, hikeList, this);
        refreshHikeList();
        selectHike();
    }

    private void refreshHikeList() {
        listModel.clear();
        for (Hike hike : treckTrackApp.getCompletedHikes()) {
            listModel.addElement(hike.getName());
        }
    }

    private void addNewHike() {
        Hike newHike = userInputHandling.addHikePopUp(this, "CompletedHikes");
        if (newHike != null) {
        treckTrackApp.addHike(treckTrackApp.getCompletedHikes(), newHike); // or getHikesToDo()
        refreshHikeList();
        }
    }

    private void selectHike() {
        hikeList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedName = hikeList.getSelectedValue();
                if (selectedName != null) {
                    for (Hike hike : treckTrackApp.getCompletedHikes()) {
                        if (hike.getName().equals(selectedName)) {
                            PanelHikeDetails infoPanel = new PanelHikeDetails(treckTrackUI, hike, "CompletedHikes");
                            String panelName = "HikeDetail" + hike.getName();
                            treckTrackUI.addPanel(panelName, infoPanel);
                            treckTrackUI.switchPanel(panelName);
                            break;
                        }
                    }
                }
            }
        });
    }

}
