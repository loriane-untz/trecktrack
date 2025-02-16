package model;

// A class representing a hike with a name
public class Hike {

    private String name;

    // optional information for completed hikes and hikes to do
    private String location;
    private String distance;
    private String peakElevation;

    // optional information for completed hikes only
    private String totalTime;
    private String difficultyRating; // should be between 1 and 5
    private String enjoymentRating; // should be between 1 and 5
    private String notes;

    // EFFECTS: constructs a Hike with a name and an uncompleted status
    public Hike(String name) {
        this.name = name;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDistance() {
        return distance;
    }

    public String getPeakElevation() {
        return peakElevation;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public String getDifficultyRating() {
        return difficultyRating;
    }

    public String getEnjoymentRating() {
        return enjoymentRating;
    }

    public String getNotes() {
        return notes;
    }

    // Setters

    // MODIFIES: this
    // EFFECTS: sets this hike's location to the provided location
    public void setLocation(String location) {
        this.location = location;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's distance to the provided distance
    public void setDistance(String distance) {
        this.distance = distance;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's elevation to the provided elevation
    public void setPeakElevation(String peakElevation) {
        this.peakElevation = peakElevation;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's total time to the provided total time
    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's difficulty rating to the provided difficulty rating
    public void setDifficultyRating(String difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's enjoyment rating to the provided enjoyment rating
    public void setEnjoymentRating(String enjoymentRating) {
        this.enjoymentRating = enjoymentRating;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's notes to the provided notes
    public void setNotes(String notes) {
        this.notes = notes;
    }


}
