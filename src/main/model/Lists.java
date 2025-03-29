package model;

import persistence.Writable;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// represents a Lists instance with a completed hikes lists and a hikes to-do list
public class Lists implements Writable {

    private ArrayList<Hike> completedHikes;
    private ArrayList<Hike> hikesToDo;

    // EFFECTS: constructs a Lists object
    public Lists() {
        completedHikes = new ArrayList<>();
        hikesToDo = new ArrayList<>();
    }

    public ArrayList<Hike> getCompletedHikes() {
        return completedHikes;
    }

    public ArrayList<Hike> getHikesToDo() {
        return hikesToDo;
    }

    // EFFECTS: returns number of hikes in completedHikes
    public int numCompletedHikes() {
        return completedHikes.size();
    }

    // EFFECTS: returns number of hikes in completedHikes
    public int numHikesToDo() {
        return hikesToDo.size();
    }

    // EFFECTS: adds given hike to given list
    public void addHike(ArrayList<Hike> listOfHikes, Hike hike) {
        listOfHikes.add(hike);
    }

    // EFFECTS: returns the hike that is at given number in list
    public Hike findHike(ArrayList<Hike> listOfHikes, int listNum) {
        listNum--;
        return listOfHikes.get(listNum);
    }

    // EFFECTS: converts TreckTrack into a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("hikesToDo", hikesToJson(hikesToDo));
        json.put("completedHikes", hikesToJson(completedHikes));
        return json;
    }

    // EFFECTS: convert a list of hikes into a JSON array
    private JSONArray hikesToJson(ArrayList<Hike> hikes) {
        JSONArray jsonArray = new JSONArray();
        for (Hike hike : hikes) {
            jsonArray.put(hike.toJson());
        }
        return jsonArray;
    }
}