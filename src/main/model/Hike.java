package model;

// A class representing a hike with a name, location, distance, elevation and a completed status
public class Hike {
    
    private String name;
    private Boolean completedStatus;

    // optional information for completed hikes and hikes to do
    private String location;
    private int distance;
    private int elevation;

    // optional information for completed hikes only
    private int totalTime;
    private int difficultyRating;
    private int enjoymentRating;
    private String notes;

    // EFFECTS: constructs a Hike with a name and an uncompleted status
    public Hike(String name) {
        this.name = name;
        completedStatus = false;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return this.location;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getElevation() {
        return this.elevation;
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

    // MODIFIES: this
    // EFFECTS: returns true if the hike is completed, else returns false
    public boolean isCompleted() {
        return this.completedStatus;
    }

    // MODIFIES: this
    // EFFECTS: sets this hike's status to completed
    public void setCompletedHike() {
        // TODO: implement this method
    }


}
