package model;

// A class representing a hike with a name and completed status
public class Hike {

    private String name;
    private Boolean completedStatus;

    // optional information for completed hikes and hikes to do
    private String location;
    private int distance;
    private int peakElevation;

    // optional information for completed hikes only
    private int totalTime;
    private int difficultyRating; // should be between 1 and 5
    private int enjoymentRating; // should be between 1 and 5
    private String notes;

    // EFFECTS: constructs a Hike with a name and an uncompleted status
    public Hike(String name) {
        this.name = name;
        this.completedStatus = false;
    }

    // Getters

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: returns true if the hike is completed, else returns false
    public boolean getCompletedStatus() {
        return this.completedStatus;
    }

    public String getLocation() {
        return this.location;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getPeakElevation() {
        return this.peakElevation;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public int getDifficultyRating() {
        return this.difficultyRating;
    }

    public int getEnjoymentRating() {
        return this.enjoymentRating;
    }

    public String getNotes() {
        return this.notes;
    }

    // Setters

    // MODIFIES: this
    // EFFECTS: sets this hike's status to completed
    public void markHikeAsCompleted() {
        this.completedStatus = true;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's location to the provided location
    public void setLocation(String location) {
        this.location = location;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's distance to the provided distance
    public void setDistance(int distance) {
        this.distance = distance;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's elevation to the provided elevation
    public void setPeakElevation(int peakElevation) {
        this.peakElevation = peakElevation;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's total time to the provided total time
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's difficulty rating to the provided difficulty rating
    public void setDifficultyRating(int difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's enjoyment rating to the provided enjoyment rating
    public void setEnjoymentRating(int enjoymentRating) {
        this.enjoymentRating = enjoymentRating;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's notes to the provided notes
    public void setNotes(String notes) {
        this.notes = notes;
    }


}
