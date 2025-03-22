package ui;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import model.Hike;

// represents the panel for the hikes to-do list
public class PanelHikesToDo extends BackgroundPanel {

    private Components components;
    private TreckTrackUI parent;
    private TreckTrackApp treckTrackApp;

    private DefaultListModel<String> listModel;
    private JList<String> hikeList;

    public PanelHikesToDo(TreckTrackUI parent, TreckTrackApp treckTrackApp) {
        super("assets/todo_background.jpg");
        this.components = new Components();
        this.parent = parent;
        this.treckTrackApp = treckTrackApp;
        setLayout(null);

        settupButtons();
        settupHikeList();
    }

    public void settupButtons() {
        JButton returnButton = components.makeReturnButton();
        returnButton.addActionListener(e -> parent.switchPanel("MainMenu"));
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
    }

    private void refreshHikeList() {
        listModel.clear();
        for (Hike hike : treckTrackApp.getHikesToDo()) {
            listModel.addElement(hike.getName());
        }
    }

    private void addNewHike() {
        String name = JOptionPane.showInputDialog(this, "Enter the name of the hike:");
        if (name != null && !name.trim().isEmpty()) {
            Hike newHike = new Hike(name.trim());
            treckTrackApp.addHike(treckTrackApp.getHikesToDo(), newHike);
            refreshHikeList();
        }
    }

}
