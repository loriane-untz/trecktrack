package ui;

import model.Hike;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PanelHikeInfo extends BackgroundPanel {

    private Components components;
    private TreckTrackUI parent;
    private Hike hike;
    private TreckTrackApp treckTrackApp;

    public PanelHikeInfo(TreckTrackUI parent, Hike hike) {
        super("assets/hike_background.jpg");
        this.components = new Components();
        this.parent = parent;
        this.hike = hike;
        // this.treckTrackApp = treckTrackApp;
        setLayout(null);
        setupButtons();
        setupInfo();
    }

    public void setupButtons() {
        JButton returnButton = components.makeReturnButton();
        returnButton.addActionListener(e -> parent.switchPanel("CompletedHikes"));
        this.add(returnButton);

        JButton changeInfoButton = components.makeAddInfoButton();
        // changeInfoButton.addActionListener(e -> //treckTrackApp.);
        this.add(changeInfoButton);

        JButton deleteButton = components.makeDeletedButton();
        //deleteButton.addActionListener(e -> treckTrackApp.deleteHike());
        this.add(deleteButton);
    }

    public void setupInfo() {
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

    public void addInfo(JTextPane infoPane, StyledDocument doc, SimpleAttributeSet nameStyle,
            SimpleAttributeSet infoCategoryStyle) {
        try {
            doc.insertString(doc.getLength(), hike.getName() + "\n\n", nameStyle);

            doc.insertString(doc.getLength(), "Location: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getLocation() + "\n", null);

            doc.insertString(doc.getLength(), "Distance: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getDistance() + "\n", null);

            doc.insertString(doc.getLength(), "Peak Elevation: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getPeakElevation() + "\n", null);

            doc.insertString(doc.getLength(), "Total Time: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getTotalTime() + "\n", null);

            doc.insertString(doc.getLength(), "Difficulty: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getDifficultyRating() + "/5\n", null);

            doc.insertString(doc.getLength(), "Enjoyment: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getEnjoymentRating() + "/5\n", null);

            doc.insertString(doc.getLength(), "Notes: ", infoCategoryStyle);
            doc.insertString(doc.getLength(), hike.getNotes() + "\n", null);

        } catch (Exception e) {
            e.printStackTrace();
        }
        add(infoPane);
    }
}
