package persistence;

import model.Hike;
import model.TreckTrack;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        // TODO: implement this method
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        // TODO: implement this method
        return null;
    }

    // EFFECTS: parses TreckTrack from JSON object and returns it
    private TreckTrack parseTreckTrack(JSONObject jsonObject) {
        // TODO: implement this method
        return null;
    }

    // MODIFIES: TreckTrack
    // EFFECTS: parses the lists of hikes from JSON object and adds them to TreckTrack
    private void addLists(TreckTrack tt, JSONObject jsonObject) {
        // TODO: implement this method
    }

    // MODIFIES: TreckTrack
    // EFFECTS: parses hike from JSON object and adds it to workroom
    private void addHike(TreckTrack tt, JSONObject jsonObject) {
         // TODO: implement this method
    }
}
