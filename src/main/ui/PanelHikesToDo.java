package ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import model.Hike;

// represents the panel for the hikes to-do list
public class PanelHikesToDo extends BackgroundPanel {

    private CustomComponents components;
    private TreckTrackUI treckTrackUI;
    private TreckTrackApp treckTrackApp;
    private UserInputHandling userInputHandling;

    private DefaultListModel<String> listModel;
    private JList<String> hikeList;

    public PanelHikesToDo(TreckTrackUI treckTrackUI, TreckTrackApp treckTrackApp) {
        super("assets/todo_background.png");
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
        for (Hike hike : treckTrackApp.getHikesToDo()) {
            listModel.addElement(hike.getName());
        }
    }

    private void addNewHike() {
        Hike newHike = userInputHandling.addHikePopUp(this, "HikesToDo");
        if (newHike != null) {
        treckTrackApp.addHike(treckTrackApp.getHikesToDo(), newHike); // or getHikesToDo()
        refreshHikeList();
        }
    }

    private void selectHike() {
        hikeList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedName = hikeList.getSelectedValue();
                if (selectedName != null) {
                    for (Hike hike : treckTrackApp.getHikesToDo()) {
                        if (hike.getName().equals(selectedName)) {
                            PanelHikeDetails infoPanel = new PanelHikeDetails(treckTrackUI, hike, "HikesToDo");
                            String panelName = "HikeDetail" + hike.getName();
                            treckTrackUI.addPanel(panelName, infoPanel);
                            treckTrackUI.switchPanel(panelName);
                            hikeList.clearSelection();
                            break;
                        }
                    }
                }
            }
        });
    }

}
