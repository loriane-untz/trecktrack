package model;

import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.ArrayList;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonWriterTest extends JsonTest {

    private static final String INVALID_FILE = "/invalid/path/to/file.json";
    private static final String EMPTY_LISTS_FILE = "./data/testWriterEmptyListsTreckTrack.json";
    private static final String NON_EMPTY_LISTS_FILE = "./data/testWriterNonEmptyListsTreckTrack.json";

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter(INVALID_FILE);
            writer.open();
            fail("IOException was expected");

        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyListsTreckTrack() {
        try {
            TreckTrack tt = new TreckTrack();
            JsonWriter writer = new JsonWriter(EMPTY_LISTS_FILE);
            writer.open();
            writer.write(tt);
            writer.close();

            JsonReader reader = new JsonReader(EMPTY_LISTS_FILE);
            tt = reader.read();
            assertEquals(0, tt.numCompletedHikes());
            assertEquals(0, tt.numHikesToDo());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterNonEmptyListsTreckTrack() {
        try {
            TreckTrack tt = new TreckTrack();

            tt.addHike(tt.getCompletedHikes(), new Hike("Grouse Grind"));
            tt.addHike(tt.getHikesToDo(), new Hike("Quarry Rock"));

            JsonWriter writer = new JsonWriter(NON_EMPTY_LISTS_FILE);
            writer.open();
            writer.write(tt);
            writer.close();

            JsonReader reader = new JsonReader(NON_EMPTY_LISTS_FILE);
            tt = reader.read();

            ArrayList<Hike> completedHikes = tt.getCompletedHikes();
            ArrayList<Hike> hikesToDo = tt.getHikesToDo();
            assertEquals(1, hikesToDo.size());
            assertEquals(1, completedHikes.size());

            checkHike(completedHikes.get(0), "Grouse Grind", null, null, null, null, null,
                    null, null);
            checkHike(hikesToDo.get(0), "Quarry Rock", null, null, null, null, null, null, null);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
