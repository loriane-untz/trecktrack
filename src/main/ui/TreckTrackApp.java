package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import model.Hike;
import model.TreckTrack;
import persistence.JsonReader;
import persistence.JsonWriter;

// represents basic logic for trecktrack application 
public class TreckTrackApp {

    private static final String JSON_STORE = "./data/trecktrack.json";

    private TreckTrack tt;
    private ArrayList<Hike> hikesToDo;
    private ArrayList<Hike> completedHikes;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // constructs a treckTrackApp object
    public TreckTrackApp() throws FileNotFoundException {
        this.tt = new TreckTrack();
        this.hikesToDo = tt.getHikesToDo();
        this.completedHikes = tt.getCompletedHikes();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    public ArrayList<Hike> getCompletedHikes() {
        return completedHikes;
    }

    public ArrayList<Hike> getHikesToDo() {
        return hikesToDo;
    }

    // MODIFIES: this
    // EFFECTS: adds given hike to the given list
    public void addHike(ArrayList<Hike> listOfHikes, Hike hike) {
        listOfHikes.add(hike);
    }

    // REQUIRES: hikeToDo must be a hike in the to-do list
    // MODIFIES: this
    // EFFECTS: moves the given hike from to-do list to completed hikes list
    public void markHikeAsCompleted(Hike hike) {
        hikesToDo.remove(hike);
        completedHikes.add(hike);
    }

    // EFFECTS: saves TreckTrack to file
    public void saveTreckTrack() {
        try {
            jsonWriter.open();
            jsonWriter.write(tt);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads TreckTrack from file
    public void loadTreckTrack() {
        try {
            tt = jsonReader.read();
            hikesToDo = tt.getHikesToDo();
            completedHikes = tt.getCompletedHikes();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // MODIFIES: hike
    // EFFECTS: updates given info for given hike
    public void addInfoToHike(Hike hike, String location, String distance, String elevation,
            String time, String difficulty, String enjoyment, String notes) {
        hike.setLocation(location);
        hike.setDistance(distance);
        hike.setPeakElevation(elevation);
        hike.setTotalTime(time);
        hike.setDifficultyRating(difficulty);
        hike.setEnjoymentRating(enjoyment);
        hike.setNotes(notes);
    }

    // EFFECTS: determines if given string is a number
    public Boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
