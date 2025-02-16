package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.CompletedHikes;
import model.Hike;
import model.HikesToDo;

// A hiking tracker application that allows users to add and view hikes to the to-do list or the completed list
public class TreckTrackApp {

    private ArrayList<Hike> hikesToDo;
    private ArrayList<Hike> completedHikes;

    private Scanner scanner;
    private Boolean isRunning;

    // EFFECTS: initializes the application and starts the menu loop
    public TreckTrackApp() {
        this.scanner = new Scanner(System.in);
        this.hikesToDo = new ArrayList<>();
        this.completedHikes = new ArrayList<>();
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: runs the main menue loop
    public void runApp() {
        boolean isRunning = true;

        while (isRunning) {
            displayMainMenu();
            handleMainMenu();
        }
    }

    // EFFECTS: controlls the completed hikes menue
    public void viewCompletedHikes() {
        System.out.println("Completed Hikes\n");
        if (completedHikes.isEmpty()) {
            System.out.println("You have not completed any hikes.");
        } else {
            displayListOfHikesMenu();
            handleCompletedHikesMenu();
        }
    }

    // EFFECTS: controlls the hikes to-do menue
    public void viewHikesToDo() {
        System.out.println("Hikes To-Do\n");
        if (hikesToDo.isEmpty()) {
            System.out.println("There are no hikes in your to-do list.");
        } else {
            displayListOfHikesMenu();
            handleHikesToDoMenu();
        }
    }

    // EFFECTS: displays commands of the main menu
    public void displayMainMenu() {
        System.out.println("Main Menu\n");
        System.out.println("[1] View Completed Hikes");
        System.out.println("[2] View Hikes-To-Do list");
        System.out.println("[3] Exit TreckTrack");
        printDivider();
    }

    // EFFECTS: displays commands when viewing one of the lists
    public void displayListOfHikesMenu() {
        System.out.println("[ Enter 'A' to add a hike ]");
        System.out.println("[ Enter a hike's number to view it in more detail ]");
        System.out.println("[ Enter 'E' Exit to Main menu ]");
        displayHikes();
        printDivider();
    }

    // EFFECTS: displays commands when viewing a completed hike
    public void displayCompletedHikeMenu() {
        System.out.println("[ Enter 'R' to remove hike from the list ]");
        System.out.println("[ Enter 'E' Exit to Completed Hikes menu ]");
        printDivider();
    }

      // EFFECTS: displays commands when viewing a hike to do
      public void displayHikeToDoMenu() {
        System.out.println("[ Enter 'R' to remove hike from the list ]");
        System.out.println("[ Enter 'C' to mark hike as completed ]");
        System.out.println("[ Enter 'E' Exit to To-do menu ]");
        printDivider();
    }

    // EFFECTS: handles commands for the main menu
    public void handleMainMenu() {
        System.out.println("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();

        switch (input) {
            case "1":
                viewCompletedHikes();
                break;
            case "2":
                viewHikesToDo();
                break;

            case "3":
                isRunning = false;
                System.out.println("Exiting TreckTrack. Happy hiking!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        printDivider();

    }

    // EFFECTS: handles commands for the completed hikes menu
    public void handleCompletedHikesMenu() {
        // TODO: implement this method
    }

    // EFFECTS: handles commands for the hikes to-do menu
    public void handleHikesToDoMenu() {
        // TODO: implement this method
    }

    // EFFECTS: displays a numbered list of hikes
    public void displayHikes() {
        // TODO: implement this method
    }

    // EFFECTS: displays the given hike
    public void displayHike(Hike hike) {
        // TODO: implement this method

    }

        // MODIFIES: this
    // EFFECTS: adds a new hike to the given list
    public void addHike() {
        // TODO: implement this method
    }


    // MODIFIES: this
    // EFFECTS: handles commands for the view hike menu
    public void handleViewCommands() {
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

    // EFFECTS: prints a divider line
    private void printDivider() {
        System.out.println("................................");
    }

}
