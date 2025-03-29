package ui;

import model.Hike;
import model.TreckTrackApp;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

// represents the panel for a hike
public class PanelHikeDetails extends BackgroundPanel {

    private CustomComponents components;
    private TreckTrackUI treckTrackUI;
    private TreckTrackApp treckTrackApp;
    private Hike hike;
    private String sourcePanel;
    private UserInputHandling userInputHandling;

    // constructs a hike details panel
    public PanelHikeDetails(TreckTrackUI treckTrackUI, Hike hike, String sourcePanel) {
        super("assets/hike_background.jpg");
        this.components = new CustomComponents();
        this.treckTrackUI = treckTrackUI;
        this.treckTrackApp = treckTrackUI.getTreckTrackApp();
        this.hike = hike;
        this.sourcePanel = sourcePanel;
        userInputHandling = new UserInputHandling();
        setLayout(null);
        setupReturnButton();
        setupCompleteButton();
        setupEditInfoButton();
        setupDeleteButton();
        setupInfo();
    }

    // MODIFIES: this
    // EFFECTS: makes a return button and adds it to this panel; navigates one of
    // the list panels
    public void setupReturnButton() {
        JButton returnButton = components.makeReturnButton();
        returnButton.addActionListener(e -> {
            if (sourcePanel.equals("CompletedHikes")) {
                treckTrackUI.switchPanel("CompletedHikes");
            } else if (sourcePanel.equals("HikesToDo")) {
                treckTrackUI.switchPanel("HikesToDo");
            }
        });
        this.add(returnButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a edit info button and adds it to this panel; opens a pop-up
    // to
    // edit the hike's info
    public void setupEditInfoButton() {
        JButton changeInfoButton = components.makeEditInfoButton();
        changeInfoButton.addActionListener(e -> {
            userInputHandling.editHikePopUp(changeInfoButton, hike, sourcePanel);
            PanelHikeDetails newDetailsPanel = new PanelHikeDetails(treckTrackUI, hike, sourcePanel);
            treckTrackUI.addPanel("HikeDetail" + hike.getName(), newDetailsPanel);
            treckTrackUI.switchPanel("HikeDetail" + hike.getName());
        });
        this.add(changeInfoButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a complete hike button and adds it to this panel; moves hike
    // to completed list
    public void setupCompleteButton() {
        JButton completeButton = components.makeCompleteButton();
        completeButton.addActionListener(e -> {
            treckTrackApp.markHikeAsCompleted(hike);
            // treckTrackApp.getHikesToDo().remove(hike);
            // treckTrackApp.getCompletedHikes().add(hike);

            treckTrackUI.addPanel("HikesToDo", new PanelHikesToDo(treckTrackUI, treckTrackApp));
            treckTrackUI.addPanel("CompletedHikes", new PanelCompletedHikes(treckTrackUI, treckTrackApp));
            treckTrackUI.switchPanel("HikesToDo");
        });
        if (sourcePanel.equals("HikesToDo")) {
            this.add(completeButton);
        }
    }

    // MODIFIES: this
    // EFFECTS: makes a delete button and adds it to this panel; deleted hike from
    // list
    public void setupDeleteButton() {
        JButton deleteButton = components.makeDeletedButton();
        deleteButton.addActionListener(e -> {

            if (sourcePanel.equals("CompletedHikes")) {
                treckTrackApp.deleteHike(treckTrackApp.getCompletedHikes(), hike);
                //treckTrackUI.getTreckTrackApp().getCompletedHikes().remove(hike);
            } else if (sourcePanel.equals("HikesToDo")) {
                treckTrackApp.deleteHike(treckTrackApp.getHikesToDo(), hike);
                //treckTrackUI.getTreckTrackApp().getHikesToDo().remove(hike);
            }

            treckTrackUI.addPanel(sourcePanel, makeListPanel(sourcePanel));
            treckTrackUI.switchPanel(sourcePanel);
        });
        this.add(deleteButton);
    }

    // MODIFIES: this
    // EFFECTS: makes a panel based on given list name
    private JPanel makeListPanel(String panelName) {
        if (panelName.equals("CompletedHikes")) {
            return new PanelCompletedHikes(treckTrackUI, treckTrackUI.getTreckTrackApp());
        } else {
            return new PanelHikesToDo(treckTrackUI, treckTrackUI.getTreckTrackApp());
        }
    }

    // EFFECTS: creates and add hike details to this panel
    private void setupInfo() {
        JTextPane infoPane = new JTextPane();
        infoPane.setBounds(100, 100, 500, 400);
        infoPane.setEditable(false);
        infoPane.setOpaque(false);
        infoPane.setFont(new Font("Monospaced", Font.BOLD, 25));
        infoPane.setForeground(new Color(121, 96, 85));

        StyledDocument doc = infoPane.getStyledDocument();

        SimpleAttributeSet nameStyle = new SimpleAttributeSet();
        StyleConstants.setFontSize(nameStyle, 50);
        StyleConstants.setBold(nameStyle, true);

        SimpleAttributeSet infoCategoryStyle = new SimpleAttributeSet();
        StyleConstants.setFontSize(infoCategoryStyle, 25);
        StyleConstants.setBold(infoCategoryStyle, false);
        StyleConstants.setSpaceBelow(infoCategoryStyle, 20);

        addInfo(infoPane, doc, nameStyle, infoCategoryStyle);
    }

    // MODIFIES: infoPane
    // EFFECTS: makes a styled text pane showing hike info
    private void addInfo(JTextPane infoPane, StyledDocument doc, SimpleAttributeSet nameStyle,
            SimpleAttributeSet infoCategoryStyle) {
        try {
            doc.insertString(doc.getLength(), hike.getName() + "\n\n", nameStyle);

            doc.insertString(doc.getLength(), "Location: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getLocation() + "\n", null);

            doc.insertString(doc.getLength(), "Distance: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getDistance() + "\n", null);

            doc.insertString(doc.getLength(), "Peak Elevation: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getPeakElevation() + "\n", null);

            if (sourcePanel.equals("CompletedHikes")) {
                doc.insertString(doc.getLength(), "Total Time: ", infoCategoryStyle);
                doc.insertString(doc.getLength(), hike.getTotalTime() + "\n", null);

                doc.insertString(doc.getLength(), "Difficulty: ", infoCategoryStyle);
                doc.insertString(doc.getLength(), hike.getDifficultyRating() + "/5\n", null);

                doc.insertString(doc.getLength(), "Enjoyment: ", infoCategoryStyle);
                doc.insertString(doc.getLength(), hike.getEnjoymentRating() + "/5\n", null);

                doc.insertString(doc.getLength(), "Notes: ", infoCategoryStyle);
                doc.insertString(doc.getLength(), hike.getNotes() + "\n", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(infoPane);
    }
}
