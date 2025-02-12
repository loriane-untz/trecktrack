package model;

import java.util.ArrayList;

public class HikesToDo {

    private ArrayList<Hike> hikesToDo;

    // EFFECTS: creates an instance of this class
    public HikesToDo() {
        hikesToDo = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds a new hike to the list of hikes to do
    public void addHike() {
        // TODO: implement this method
    }

    // MODIFIES: this
    // EFFECTS: sets the status of this hike to completed,
    // moves this hike to the list of completed hikes
    // and asks user if they want to add more information
    // NOTE: I want to have an extra confirmation when users activate this method to
    // make sure they want to mark the hike as completed
    public void markHikeAsCompleted() {
        // TODO: implement this method
    }

}
