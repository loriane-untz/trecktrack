package ui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Hike;

// represents user input handling
public class UserInputHandling {

    private JTextField nameField;
    private JTextField locationField;
    private JTextField distanceField;
    private JTextField elevationField;
    private JTextField timeField;
    private JTextField difficultyField;
    private JTextField enjoymentField;
    private JTextField notesField;

    // constructs a UserInputHandling object
    public UserInputHandling() {
    }

    // MODIFIES: this
    // EFFECTS: displays a popup for adding new hikes and returns the new hike
    public Hike addHikePopUp(Component button, String listType) {
        JPanel panel = makePanel(listType);
        int result = showPopup(button, panel);
        if (result == JOptionPane.OK_OPTION) {
            return createHikeFromFields(button, listType);
        }
        return null;
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: hike
    // EFFECTS: displays a popup for editing given hike's information
    public void editHikePopUp(Component button, Hike hike, String listType) {
        JPanel panel = makePanel(listType);

        nameField.setText(hike.getName());
        nameField.setEditable(false);

        locationField.setText(hike.getLocation());
        distanceField.setText(hike.getDistance());
        elevationField.setText(hike.getPeakElevation());

        if (listType.equals("CompletedHikes")) {
            timeField.setText(hike.getTotalTime());
            difficultyField.setText(hike.getDifficultyRating());
            enjoymentField.setText(hike.getEnjoymentRating());
            notesField.setText(hike.getNotes());
        }

        int result = showPopup(button, panel);

        if (result == JOptionPane.OK_OPTION) {
            hike.setLocation(locationField.getText().trim());
            hike.setDistance(distanceField.getText().trim());
            hike.setPeakElevation(elevationField.getText().trim());

            if (listType.equals("CompletedHikes")) {
                hike.setTotalTime(timeField.getText().trim());
                hike.setDifficultyRating(difficultyField.getText().trim());
                hike.setEnjoymentRating(enjoymentField.getText().trim());
                hike.setNotes(notesField.getText().trim());
            }
        }
    }

    @SuppressWarnings("methodlength")
    // MODIFIES: this
    // EFFECTS: makes a pop-up panel
    private JPanel makePanel(String listType) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        nameField = new JTextField(15);
        locationField = new JTextField(15);
        distanceField = new JTextField(15);
        elevationField = new JTextField(15);
        timeField = new JTextField(15);
        difficultyField = new JTextField(15);
        enjoymentField = new JTextField(15);
        notesField = new JTextField(15);

        panel.add(new JLabel("Name*:"));
        panel.add(nameField);

        panel.add(new JLabel("Location:"));
        panel.add(locationField);

        panel.add(new JLabel("Distance (Km):"));
        panel.add(distanceField);

        panel.add(new JLabel("Peak Elevation (m):"));
        panel.add(elevationField);

        if (listType.equals("CompletedHikes")) {
            panel.add(new JLabel("Total Time (hours):"));
            panel.add(timeField);

            panel.add(new JLabel("Difficulty Rating (/5):"));
            panel.add(difficultyField);

            panel.add(new JLabel("Enjoyement Rating (/5):"));
            panel.add(enjoymentField);

            panel.add(new JLabel("Notes:"));
            panel.add(notesField);
        }
        return panel;
    }

    // MODIFIES: this
    // EFFECTS: creates new hike from user input
    private Hike createHikeFromFields(Component button, String listType) {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(button, "Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        Hike hike = new Hike(name);
        hike.setLocation(locationField.getText().trim());
        hike.setDistance(distanceField.getText().trim());
        hike.setPeakElevation(elevationField.getText().trim());
        if (listType.equals("CompletedHikes")) {
            hike.setTotalTime(timeField.getText().trim());
            hike.setDifficultyRating(difficultyField.getText().trim());
            hike.setEnjoymentRating(enjoymentField.getText().trim());
            hike.setNotes(notesField.getText().trim());
        }
        clearFields();
        return hike;
    }

    // EFFECTS: shows the pop-up window
    private int showPopup(Component button, JPanel panel) {
        return JOptionPane.showConfirmDialog(
                button,
                panel,
                "Hike",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }

    // MODIFIES:
    // EFFECTS: clears user input fields
    private void clearFields() {
        nameField.setText("");
        locationField.setText("");
        distanceField.setText("");
        elevationField.setText("");
        timeField.setText("");
        difficultyField.setText("");
        enjoymentField.setText("");
        notesField.setText("");
    }
}
