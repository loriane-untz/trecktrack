package ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import model.Hike;
import model.TreckTrackApp;

// represents the panel for the hikes to-do list
public class PanelHikesToDo extends BackgroundPanel {

    private CustomComponents components;
    private TreckTrackUI treckTrackUI;
    private TreckTrackApp treckTrackApp;
    private UserInputHandling userInputHandling;

    private DefaultListModel<String> listModel;
    private JList<String> hikeList;

    // constructs a to-do list panel
    public PanelHikesToDo(TreckTrackUI treckTrackUI, TreckTrackApp treckTrackApp) {
        super("assets/todo_background.png");
        this.components = new CustomComponents();
        this.treckTrackUI = treckTrackUI;
        this.treckTrackApp = treckTrackApp;
        userInputHandling = new UserInputHandling();
        setLayout(null);
        setupReturnButton();
        setupAddHikeButton();
        settupHikeList();
    }

    // MODIFIES: this
    // EFFECTS: makes a return button and adds it to this panel; navigates to home
    public void setupReturnButton() {
        JButton returnButton = components.makeReturnButton();
        returnButton.addActionListener(e -> treckTrackUI.switchPanel("MainMenu"));
        this.add(returnButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a add-hike button and adds it to this panel; opens a pop-up to
    // add a new hike
    public void setupAddHikeButton() {
        JButton addHikeButton = components.makeAddHikButton();
        addHikeButton.addActionListener(e -> addNewHike());
        this.add(addHikeButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a list of completed hikes and adds it to this panel
    public void settupHikeList() {
        listModel = new DefaultListModel<>();
        hikeList = new JList<>(listModel);
        components.settupHikeList(listModel, hikeList, this);
        refreshHikeList();
        selectHike();
    }

    // MODIFIES: listModel
    // EFFECTS: refreshes the list of hikes
    private void refreshHikeList() {
        listModel.clear();
        for (Hike hike : treckTrackApp.getHikesToDo()) {
            listModel.addElement(hike.getName());
        }
    }

    // MODIFIES: treckTrackApp (HikesToDo), listModel
    // EFFECTS: opens a pop-up to create a new hike from user info and adds it to
    // to-do list
    private void addNewHike() {
        Hike newHike = userInputHandling.addHikePopUp(this, "HikesToDo");
        if (newHike != null) {
            treckTrackApp.addHike(treckTrackApp.getHikesToDo(), newHike); // or getHikesToDo()
            refreshHikeList();
        }
    }

    // MODIFIES: this
    // EFFECTS: allows for the selection of a hike in the list in order to view its
    // details
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
