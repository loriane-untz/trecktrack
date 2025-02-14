package model;

import java.util.ArrayList;

// A class representing list of hikes to do
public class HikesToDo {

    private ArrayList<Hike> hikesToDo;
    private Hike hikeToDo;

    // EFFECTS: creates an instance of this class
    public HikesToDo() {
        hikesToDo = new ArrayList<>();
    }

}
