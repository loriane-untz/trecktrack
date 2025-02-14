package model;

import java.util.ArrayList;

// A class representing list of hikes to do
public class HikesToDo extends ListOfHikes {

    private ArrayList<Hike> hikesToDo;

    // EFFECTS: creates an instance of this class
    public HikesToDo() {
        super();
    }

    // REQUIRES: given hike must be a hike in the to-do list
    // MODIFIES: this
    // EFFECTS: sets the status of the given hike to completed,
    // moves the hike from this list to the list of completed hikes,
    // and asks user if they want to add more information
    public void markHikeAsCompleted(Hike hike) {
        // TODO: implement this method
    }

}
