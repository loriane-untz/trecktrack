package model;

import java.util.ArrayList;

// Represents a list of hikes; either completed or to-do
public abstract class ListOfHikes {

    protected ArrayList<Hike> listOfHikes;

    // EFFECTS: creates an empty list of hikes
    public ListOfHikes() {
        this.listOfHikes = new ArrayList<>();
    }

    public ArrayList<Hike> getListOfHikes() {
        return this.listOfHikes;
    }

    // MODIFIES: this
    // EFFECTS: adds the given hike to the list
    public void addHike(Hike hike) {
        // TODO: implement this method
    }

    // MODIFIES: this
    // EFFECTS: removes the given hike from the list
    public void removeHike(Hike hike) {
        // TODO: implement this method
    }
}
