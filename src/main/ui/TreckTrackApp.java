package ui;

import java.util.ArrayList;
import java.util.List;

import model.Hike;

// A hiking tracker application that allows users to add and view hikes to the to-do list or the completed list
public class TreckTrackApp {

    private ArrayList<Hike> hikesToDo;
    private ArrayList<Hike> completedHikes;

    // EFFECTS: creates an instance of the TreckTrack console ui application
    public TreckTrackApp() {
        // TODO: implement this method
    }

    // MODIFIES: this
    // EFFECTS: initializes the application with the starting values
    public void initialize() {
        // TODO: implement this method
    }

    // EFFECTS: displays and processes inputs for the main menu
    public void handleInputMenu() {
        // TODO: implement this method
    }

    // EFFECTS: displays commands for the main menu
    public void displayMenu() {
        // TODO: implement this method
    }

    // EFFECTS: processes user input in the main menu
    public void processMenuCommands(String input) {
        // TODO: implement this method
    }

    // MODIFIES: this
    // EFFECTS: adds a new hike to the given list
    public void addHike() {
        // TODO: implement this method
    }

    // MODIFIES: this
    // EFFECTS: displays the given list of hikes and handles inputs related to
    // viewing the hikes
    public void viewGivenListOfHikes(ArrayList<Hike> hikes) {
        // TODO: implement this method
    }

    // EFFECTS: displays the given hike
    public void displayHike(Hike hike) {
        // TODO: implement this method

    }

    // EFFECTS: displays a list of commands that can be used while viewing a hike
    public void displayViewMenu() {
        // TODO: implement this method

    }

    // MODIFIES: this
    // EFFECTS: processes the user's input in the view hike menu
    public void handleViewCommands(String input, ArrayList<Hike> hikes) {
        // TODO: implement this method
    }

    // REQUIRES: hikeToDo must be a hike in the to-do list
    // MODIFIES: this
    // EFFECTS: sets the status of the given hike to completed,
    // moves the hike from this list to the list of completed hikes,
    // and asks user if they want to add more information
    // NOTE: I want to have an extra confirmation when users activate this method to
    // make sure they want to mark the hike as completed
    public void markHikeAsCompleted(Hike hikeToDo) {
        // TODO: implement this method
    }

}
