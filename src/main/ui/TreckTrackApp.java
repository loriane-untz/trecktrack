package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Hike;

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
        isRunning = true;

        while (isRunning) {
            displayMainMenu();
            handleMainMenu();
        }
    }

    // EFFECTS: displays commands of the main menu
    public void displayMainMenu() {
        printDivider();
        System.out.println("TRECKTRACK");
        System.out.println("Main Menu\n");
        System.out.println("[1] View Completed Hikes");
        System.out.println("[2] View Hikes-To-Do list");
        System.out.println("[3] Exit TreckTrack");
        printSpacer();
    }

    // EFFECTS: handles commands for the main menu
    public void handleMainMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();

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
                isRunning = false;
                System.out.println("Exiting TreckTrack. Happy hiking!");
                break;

            default:
                printSpacer();
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // EFFECTS: controls the completed hikes menu
    public void viewCompletedHikes() {
        printDivider();
        System.out.println("Completed Hikes\n");
        displayListOfHikesMenu();
        if (completedHikes.isEmpty()) {
            System.out.println("You have not completed any hikes.");
        } else {
            displayListOfHikes(completedHikes);
        }
        printSpacer();
        handleCompletedHikesMenu();
    }

    // EFFECTS: controlls the hikes to-do menue
    public void viewHikesToDo() {
        printDivider();
        System.out.println("Hikes To-Do\n");
        displayListOfHikesMenu();
        if (hikesToDo.isEmpty()) {
            System.out.println("There are no hikes in your to-do list.");
        } else {
            displayListOfHikes(hikesToDo);
        }
        printSpacer();
        handleHikesToDoMenu();
    }

    // REQUIRES: list of hikes is not empty
    // EFFECTS: displays a numbered list of hikes
    public void displayListOfHikes(ArrayList<Hike> listOfHikes) {
        int listIndex = 1;
        for (Hike hike : listOfHikes) {
            System.out.println(listIndex + "." + hike.getName());
            listIndex++;
        }
    }

    // EFFECTS: displays commands when viewing one of the lists
    public void displayListOfHikesMenu() {
        System.out.println("[E] Enter 'E' to exit to Main menu");
        System.out.println("[A] Enter 'A' to add a hike");
        System.out.println("[#] Enter a hike's number to view it in more detail");
        printSpacer();
    }

    // EFFECTS: handles commands for the completed hikes menu
    public void handleCompletedHikesMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();

        if (isNumber(input)) {
            int listNum = Integer.parseInt(input);
            if (listNum > 0 && listNum <= completedHikes.size()) {
                viewCompletedHike(findHike(completedHikes, listNum));
            } else {
                printSpacer();
                System.out.println("Invalid choice. Please try again.");
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
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // EFFECTS: handles commands for the hikes to-do menu
    public void handleHikesToDoMenu() {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();

        if (isNumber(input)) {
            int listNum = Integer.parseInt(input);
            if (listNum > 0 && listNum <= hikesToDo.size()) {
                viewHikeToDo(findHike(hikesToDo, listNum));
            } else {
                printSpacer();
                System.out.println("Invalid choice. Please try again.");
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
                    System.out.println("Invalid choice. Please try again.");
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
        String hikeName = this.scanner.nextLine().trim();

        Hike newHike = new Hike(hikeName);

        System.out.print("Would you like to add more information?");
        System.out.print(" (Enter 'Y' or 'N'): ");
        String moreInfo = this.scanner.nextLine().trim();

        if (moreInfo == "Y") {
            addInfoToHike(newHike);
        }

        listOfHikes.add(newHike);

        printSpacer();
        System.out.println(hikeName + " has been added to the list!");
    }

    public Hike findHike(ArrayList<Hike> listOfHikes, int listNum) {
        listNum--;
        return listOfHikes.get(listNum);
    }

    // EFFECTS: controls the menu of a completed hike
    public void viewCompletedHike(Hike hike) {
        printDivider();
        System.out.println(hike.getName());
        printSpacer();
        displayCompletedHikeMenu();
        printSpacer();
        displayHike(hike);
        handleCompletedHike(hike);
    }

    // EFFECTS: displays commands when viewing a completed hike
    public void displayCompletedHikeMenu() {
        System.out.println("[E] Enter 'E' Exit to Completed Hikes menu");
        System.out.println("[D] Enter 'D' to delete hike from the list");
        System.out.println("[I] Enter 'I' to add information to the hike");

    }

    // MODIFIES: this
    // EFFECTS: handles commands when viewing a completed hike
    public void handleCompletedHike(Hike hike) {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();
        printSpacer();

        switch (input) {
            case "E":
                viewCompletedHikes();
                break;
            case "D":
                completedHikes.remove(hike);
                System.out.println(hike.getName() + " has been deleted from the list!");
                viewCompletedHikes();
                break;
            case "I":
                addInfoToHike(hike);
                break;
            default:
                printSpacer();
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }

    // EFFECTS: controls the menu of a hike to do
    public void viewHikeToDo(Hike hike) {
        printDivider();
        System.out.println(hike.getName());
        printSpacer();
        displayHikeToDoMenu();
        printSpacer();
        displayHike(hike);
        handleHikeToDo(hike);
    }

    // EFFECTS: displays commands when viewing a hike to do
    public void displayHikeToDoMenu() {
        System.out.println("[E] Enter 'E' Exit to To-Do menu");
        System.out.println("[D] Enter 'D' to delete hike from the list");
        System.out.println("[I] Enter 'I' to add information to the hike");
        System.out.println("[C] Enter 'C' to mark hike as completed");
    }

    // MODIFIES: this
    // EFFECTS: handles commands when viewing a hike to do
    public void handleHikeToDo(Hike hike) {
        printDivider();
        System.out.print("Enter your choice here: ");
        String input = this.scanner.nextLine().trim();
        printDivider();
        printSpacer();

        switch (input) {
            case "E":
                viewHikesToDo();
                break;
            case "D":
                hikesToDo.remove(hike);
                System.out.println(hike.getName() + " has been deleted from the list!");
                printSpacer();
                viewHikesToDo();
                break;
            case "I":
                addInfoToHike(hike);
                break;
            case "C":
                markHikeAsCompleted(hike);
                printSpacer();
                System.out.println("Hike completed. Good work!");
                break;
            default:
                printSpacer();
                System.out.println("Invalid choice. Please try again.");
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
        System.out.print("Would you like to add more information?");
        System.out.print(" (Enter 'Y' or 'N'): ");
        String moreInfo = this.scanner.nextLine().trim();

        if (moreInfo == "Y") {
            addInfoToHike(hike);
        } else {
            completedHikes.add(hike);
        }
    }

    // EFFECTS: adds more information to a hike
    public void addInfoToHike(Hike hike) {
        System.out.print("Enter the location: ");
        String location = this.scanner.nextLine().trim();
        hike.setLocation(location);

        System.out.print("Enter the distance: ");
        String distance = this.scanner.nextLine().trim();
        hike.setLocation(distance);

        System.out.print("Enter the peak elevation: ");
        String elevation = this.scanner.nextLine().trim();
        hike.setLocation(elevation);

        if (completedHikes.contains(hike)) {
            System.out.print("Enter your total time: ");
            String time = this.scanner.nextLine().trim();
            hike.setLocation(time);

            System.out.print("Enter a difficulty rating: ");
            String difficulty = this.scanner.nextLine().trim();
            hike.setLocation(difficulty);

            System.out.print("Enter a enjoyment rating: ");
            String enjoyment = this.scanner.nextLine().trim();
            hike.setLocation(enjoyment);

            System.out.print("Enter any notes: ");
            String notes = this.scanner.nextLine().trim();
            hike.setLocation(notes);

        }
        printSpacer();
        System.out.println("Hike information has been updated.");
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
