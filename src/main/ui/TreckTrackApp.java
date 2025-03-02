package ui;

import model.Hike;
import model.TreckTrack;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.io.IOException;

// A hiking tracker application that allows users to add and view hikes to the to-do list or the completed list
public class TreckTrackApp {

    private static final String JSON_STORE = "./data/trecktrack.json";

    private ArrayList<Hike> hikesToDo;
    private ArrayList<Hike> completedHikes;
    private TreckTrack tt;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private Boolean isRunning;
    private Scanner scanner;

    // MODIFIES: this
    // EFFECTS: initializes the application and starts the menu loop
    public TreckTrackApp() throws FileNotFoundException {
        this.scanner = new Scanner(System.in);
        this.tt = new TreckTrack();
        this.hikesToDo = tt.getHikesToDo();
        this.completedHikes = tt.getCompletedHikes();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: runs the main menue loop
    public void runApp() {
        isRunning = true;

        while (isRunning) {
            displayMainMenu();
            handleMainMenu();
        }
    }

    // EFFECTS: displays commands when viewing the main menu
    public void displayMainMenu() {
        printDivider();
        System.out.println("TRECKTRACK");
        System.out.println("~ Main Menu ~\n");
        System.out.println("[1] View Completed Hikes");
        System.out.println("[2] View Hikes-To-Do list");
        System.out.println("[3] Save Changes");
        System.out.println("[4] Load File");
        System.out.println("[5] Exit TreckTrack");
        printSpacer();
    }

    // PLEASE READ: at the time I finished coding, I could not check with TAS to
    // confirm if the use of the supress annotation was okay for 3 methods that were
    // over the line limit.
    // I decided I would use it because I don't think abstracting the methods would
    // make them much clearer,
    // and also I have a couple "spacers" in the code that add to the line count,
    // but that are only for asthetic purposes in the console.

    // EFFECTS: handles commands for the main menu
    @SuppressWarnings("methodlength")
    public void handleMainMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim().toUpperCase();

        switch (input) {
            case "1":
                viewCompletedHikes();
                printSpacer();
                break;
            case "2":
                viewHikesToDo();
                printSpacer();
                break;
            case "3":
                saveTreckTrack();
                printSpacer();
                break;
            case "4":
                loadTreckTrack();
                printSpacer();
                break;
            case "5":
                saveReminder();
                isRunning = false;
                printSpacer();
                System.out.println("Exiting TreckTrack. Happy hiking!");
                break;
            default:
                printSpacer();
                printErrorMessage();
                break;
        }
    }

    // EFFECTS: displays and controls the completed hikes menu
    public void viewCompletedHikes() {
        printDivider();
        System.out.println("~ Completed Hikes ~\n");
        displayListOfHikesCommands();
        if (completedHikes.isEmpty()) {
            System.out.println("You have not completed any hikes.");
        } else {
            displayNumberedListOfHikes(completedHikes);
        }
        printSpacer();
        handleCompletedHikesMenu();
    }

    // EFFECTS: displays and controls the hikes to-do menu
    public void viewHikesToDo() {
        printDivider();
        System.out.println("~ Hikes To-Do ~\n");
        displayListOfHikesCommands();
        if (hikesToDo.isEmpty()) {
            System.out.println("There are no hikes in your to-do list.");
        } else {
            displayNumberedListOfHikes(hikesToDo);
        }
        printSpacer();
        handleHikesToDoMenu();
    }

    // REQUIRES: list of hikes is not empty
    // EFFECTS: displays a numbered list of hikes
    public void displayNumberedListOfHikes(ArrayList<Hike> listOfHikes) {
        int listIndex = 1;
        for (Hike hike : listOfHikes) {
            System.out.println(listIndex + "." + hike.getName());
            listIndex++;
        }
    }

    // EFFECTS: displays commands when viewing either completed or to-do list
    public void displayListOfHikesCommands() {
        System.out.println("[E] Enter 'E' to exit to Main menu");
        System.out.println("[A] Enter 'A' to add a hike");
        System.out.println("[#] Enter a hike's number to view it in more detail");
        printSpacer();
    }

    // EFFECTS: handles commands for the completed hikes menu
    @SuppressWarnings("methodlength")
    public void handleCompletedHikesMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim().toUpperCase();
        if (isNumber(input)) {
            int listNum = Integer.parseInt(input);
            if (listNum > 0 && listNum <= completedHikes.size()) {
                viewCompletedHike(tt.findHike(completedHikes, listNum));
            } else {
                printSpacer();
                printErrorMessage();
                viewCompletedHikes();
            }
        } else {
            switch (input) {
                case "A":
                    addHike(completedHikes);
                    viewCompletedHikes();
                    break;
                case "E":
                    displayMainMenu();
                    handleMainMenu();
                    break;
                default:
                    printSpacer();
                    printErrorMessage();
                    viewCompletedHikes();
                    break;
            }
        }
    }

    // EFFECTS: handles commands for the hikes to-do menu
    @SuppressWarnings("methodlength")
    public void handleHikesToDoMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim().toUpperCase();
        if (isNumber(input)) {
            int listNum = Integer.parseInt(input);
            if (listNum > 0 && listNum <= hikesToDo.size()) {
                viewHikeToDo(tt.findHike(hikesToDo, listNum));
            } else {
                printSpacer();
                printErrorMessage();
                viewHikesToDo();
            }
        } else {
            switch (input) {
                case "A":
                    addHike(hikesToDo);
                    viewHikesToDo();
                    break;
                case "E":
                    displayMainMenu();
                    handleMainMenu();
                    break;
                default:
                    printSpacer();
                    printErrorMessage();
                    viewHikesToDo();
                    break;
            }
        }
    }

    public Boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new hike to the given list
    public void addHike(ArrayList<Hike> listOfHikes) {
        System.out.print("Enter name of the hike: ");
        String hikeName = this.scanner.nextLine().trim().toUpperCase();
        Hike newHike = new Hike(hikeName);

        System.out.print("Would you like to add more information? ('Y'/'N'): ");
        String moreInfo = this.scanner.nextLine().trim().toUpperCase();

        if (!moreInfo.equals("Y") && !moreInfo.equals("N")) {
            printSpacer();
            printErrorMessage();
        } else if (moreInfo.equals("Y")) {
            addInfoToHike(newHike);
            tt.addHike(listOfHikes, newHike);
            printSpacer();
            System.out.println(hikeName + " has been added to the list!");
        } else {
            tt.addHike(listOfHikes, newHike);
            printSpacer();
            System.out.println(hikeName + " has been added to the list!");
        }
    }

    // EFFECTS: controls the menu of a completed hike
    public void viewCompletedHike(Hike hike) {
        printDivider();
        System.out.println("~ " + hike.getName() + " ~");
        printSpacer();
        displayCompletedHikeMenu();
        printSpacer();
        displayHike(hike);
        handleCompletedHike(hike);
    }

    // EFFECTS: displays commands when viewing a completed hike
    public void displayCompletedHikeMenu() {
        System.out.println("[E] Enter 'E' to exit to your Completed Hikes list");
        System.out.println("[D] Enter 'D' to delete hike from the list");
        System.out.println("[I] Enter 'I' to add information to the hike");
    }

    // MODIFIES: this
    // EFFECTS: handles commands when viewing a completed hike
    public void handleCompletedHike(Hike hike) {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim().toUpperCase();

        switch (input) {
            case "E":
                viewCompletedHikes();
                break;
            case "D":
                completedHikes.remove(hike);
                printSpacer();
                System.out.println(hike.getName() + " has been deleted from the list!");
                viewCompletedHikes();
                break;
            case "I":
                addInfoToHike(hike);
                viewCompletedHikes();
                break;
            default:
                printSpacer();
                printErrorMessage();
                viewCompletedHike(hike);
                break;
        }
    }

    // EFFECTS: controls the menu of a hike to do
    public void viewHikeToDo(Hike hike) {
        printDivider();
        System.out.println("~ " + hike.getName() + " ~");
        printSpacer();
        displayHikeToDoMenu();
        printSpacer();
        displayHike(hike);
        handleHikeToDo(hike);
    }

    // EFFECTS: displays commands when viewing a hike to do
    public void displayHikeToDoMenu() {
        System.out.println("[E] Enter 'E' to exit to your To-Do list");
        System.out.println("[D] Enter 'D' to delete hike from the list");
        System.out.println("[I] Enter 'I' to add information to the hike");
        System.out.println("[C] Enter 'C' to mark hike as completed");
    }

    // MODIFIES: this
    // EFFECTS: handles commands when viewing a hike to do
    @SuppressWarnings("methodlength")
    public void handleHikeToDo(Hike hike) {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim().toUpperCase();
        switch (input) {
            case "E":
                viewHikesToDo();
                break;
            case "D":
                hikesToDo.remove(hike);
                printSpacer();
                System.out.println(hike.getName() + " has been deleted from the list!");
                viewHikesToDo();
                break;
            case "I":
                addInfoToHike(hike);
                viewHikesToDo();
                break;
            case "C":
                markHikeAsCompleted(hike);
                printSpacer();
                viewHikesToDo();
                break;
            default:
                printSpacer();
                printErrorMessage();
                viewHikeToDo(hike);
                break;
        }
    }

    // EFFECTS: displays the given hike
    public void displayHike(Hike hike) {
        System.out.println("Location: " + hike.getLocation());
        System.out.println("Distance: " + hike.getDistance());
        System.out.println("Peak Elevation: " + hike.getPeakElevation());
        if (completedHikes.contains(hike)) {
            System.out.println("Total Time: " + hike.getTotalTime());
            System.out.println("Difficulty: " + hike.getDifficultyRating() + "/5");
            System.out.println("Enjoyment: " + hike.getEnjoymentRating() + "/5");
            System.out.println();
            System.out.println("NOTES: " + hike.getNotes());
        }
        printSpacer();
    }

    // REQUIRES: hikeToDo must be a hike in the to-do list
    // MODIFIES: this
    // EFFECTS: moves the hike from to-do list to list of completed hikes,
    // and asks user if they want to add more information
    public void markHikeAsCompleted(Hike hike) {
        hikesToDo.remove(hike);
        printSpacer();
        System.out.print("Would you like to add more information? ('Y'/'N'): ");
        String moreInfo = this.scanner.nextLine().trim().toUpperCase();

        if (!moreInfo.equals("Y") && !moreInfo.equals("N")) {
            printSpacer();
            printErrorMessage();
        } else if (moreInfo.equals("Y")) {
            completedHikes.add(hike);
            addInfoToHike(hike);
            printSpacer();
            System.out.println("You completed " + hike.getName() + ". Good work!");
        } else {
            completedHikes.add(hike);
            printSpacer();
            System.out.println("You completed " + hike.getName() + ". Good work!");
        }
    }

    // EFFECTS: adds more information to a hike
    @SuppressWarnings("methodlength")
    public void addInfoToHike(Hike hike) {
        System.out.print("Enter the location: ");
        String location = this.scanner.nextLine().trim();
        hike.setLocation(location);

        System.out.print("Enter the distance: ");
        String distance = this.scanner.nextLine().trim();
        hike.setDistance(distance);

        System.out.print("Enter the peak elevation: ");
        String elevation = this.scanner.nextLine().trim();
        hike.setPeakElevation(elevation);

        if (completedHikes.contains(hike)) {
            System.out.print("Enter your total time: ");
            String time = this.scanner.nextLine().trim();
            hike.setTotalTime(time);

            System.out.print("Enter a difficulty rating (/5): ");
            String difficulty = this.scanner.nextLine().trim();
            hike.setDifficultyRating(difficulty);

            System.out.print("Enter a enjoyment rating (/5): ");
            String enjoyment = this.scanner.nextLine().trim();
            hike.setEnjoymentRating(enjoyment);

            System.out.print("Enter any notes: ");
            String notes = this.scanner.nextLine().trim();
            hike.setNotes(notes);

        }
        printSpacer();
        System.out.println("Hike information has been updated.");
    }

    // EFFECTS: displays a reminder to save user progress
    private void saveReminder() {
        System.out.print("Save progress before quitting? ('Y'/'N'): ");
        String doesSave = this.scanner.nextLine().trim().toUpperCase();

        if (!doesSave.equals("Y") && !doesSave.equals("N")) {
            printSpacer();
            printErrorMessage();
        } else if (doesSave.equals("Y")) {
            saveTreckTrack();
        }
    }

    // EFFECTS: saves TreckTrack to file
    private void saveTreckTrack() {
        try {
            jsonWriter.open();
            jsonWriter.write(tt);
            jsonWriter.close();
            printDivider();
            System.out.println("Saved changes to: " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads TreckTrack from file
    private void loadTreckTrack() {
        try {
            tt = jsonReader.read();
            printDivider();
            printSpacer();
            hikesToDo = tt.getHikesToDo();
            completedHikes = tt.getCompletedHikes();
            System.out.println("Loaded progress from: " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS: prints an error message
    private void printErrorMessage() {
        System.out.println("Invalid choice, please try again.");
    }

    // EFFECTS: prints a divider line
    private void printDivider() {
        System.out.println("................................");
    }

    // EFFECTS: prints a spacer
    private void printSpacer() {
        System.out.println();
    }

}
