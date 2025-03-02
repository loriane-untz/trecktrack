package persistence;

import model.Hike;
import model.TreckTrack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import org.json.*;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a reader that reads TreckTrack from JSON data stored in file
public class JsonReader {

    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads TreckTrack from file and returns it;
    // throws IOException if an error occurs reading data from file
    public TreckTrack read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTreckTrack(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses TreckTrack from JSON object and returns it
    private TreckTrack parseTreckTrack(JSONObject jsonObject) {
        TreckTrack tt = new TreckTrack();
        addLists(tt, jsonObject);
        return tt;
    }

    // MODIFIES: TreckTrack
    // EFFECTS: parses the lists of hikes from JSON object and adds them to
    // TreckTrack
    private void addLists(TreckTrack tt, JSONObject jsonObject) {
        JSONArray completedArray = jsonObject.getJSONArray("completedHikes");
        JSONArray toDoArray = jsonObject.getJSONArray("hikesToDo");

        for (Object json : completedArray) {
            JSONObject nextHike = (JSONObject) json;
            addHike(tt.getCompletedHikes(), nextHike);
        }

        for (Object json : toDoArray) {
            JSONObject nextHike = (JSONObject) json;
            addHike(tt.getHikesToDo(), nextHike);
        }
    }

    // MODIFIES: TreckTrack
    // EFFECTS: parses hike from JSON object and adds it to TreckTrack
    private void addHike(ArrayList<Hike> listOfHikes, JSONObject jsonObject) {
        Hike hike = new Hike(jsonObject.getString("name"));

        hike.setLocation(jsonObject.optString("location", null));
        hike.setDistance(jsonObject.optString("distance", null));
        hike.setPeakElevation(jsonObject.optString("peakElevation", null));
        hike.setTotalTime(jsonObject.optString("totalTime", null));
        hike.setDifficultyRating(jsonObject.optString("difficultyRating", null));
        hike.setEnjoymentRating(jsonObject.optString("enjoymentRating", null));
        hike.setNotes(jsonObject.optString("notes", null));

        listOfHikes.add(hike);
    }
}
