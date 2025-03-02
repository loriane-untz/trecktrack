package model;

import persistence.JsonReader;

import java.util.ArrayList;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonReaderTest extends JsonTest {

    private static final String INVALID_FILE = "/invalid/path/to/file.json";
    private static final String EMPTY_LISTS_FILE = "./data/testReaderEmptyListsTreckTrack.json";
    private static final String NON_EMPTY_LISTS_FILE = "./data/testReaderNonEmptyListsTreckTrack.json";

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader(INVALID_FILE);
        try {
            reader.read();
            fail("IOException expected");

        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyListsTreckTrack() {
        JsonReader reader = new JsonReader(EMPTY_LISTS_FILE);
        try {
            TreckTrack tt = reader.read();
            assertEquals(0, tt.numCompletedHikes());
            assertEquals(0, tt.numHikesToDo());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderNonEmptyListsTreckTrack() {
        JsonReader reader = new JsonReader(NON_EMPTY_LISTS_FILE);
        try {
            TreckTrack tt = reader.read();

            ArrayList<Hike> completedHikes = tt.getCompletedHikes();
            ArrayList<Hike> hikesToDo = tt.getHikesToDo();
            assertEquals(1, hikesToDo.size());
            assertEquals(1, completedHikes.size());

            checkHike(completedHikes.get(0), "Grouse Grind", "Grouse Mountain", "2.5km", "1,100m", "3h", "3",
                    "3", "Too many stairs...");
            checkHike(hikesToDo.get(0), "Quarry Rock", null, null, null, null, null, null, null);

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
