package model;

import persistence.JsonReader;

import java.util.ArrayList;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    private static final String INVALID_FILE = "./data/noSuchFile.json";
    private static final String EMPTY_LISTS_FILE = "./data/testReaderEmptyListsTreckTrack.json";
    private static final String GENERAL_FILE = "./data/testReaderGeneralTreckTrack.json";

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
        JsonReader reader = new JsonReader(GENERAL_FILE);
        try {
            TreckTrack tt = reader.read();

            ArrayList<Hike> completedHikes = tt.getCompletedHikes();
            ArrayList<Hike> hikesToDo = tt.getHikesToDo();
            assertEquals(1, hikesToDo.size());
            assertEquals(1, completedHikes.size());

            checkCompletedHike(completedHikes.get(0), "Grouse Grind", "Grouse Mountain", "2.5km", "1,100m", "3h", "3",
                    "3", "Too many stairs...");
            checkHikeToDo(hikesToDo.get(0), "Quarry Rock", null, null, null);

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
