package model;

import model.Hike;
import model.TreckTrack;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    private static final String INVALID_FILE = "./data/my\\0illegal:fileName.json";
    private static final String EMPTY_LISTS_FILE = "./data/testWriterEmptyListsTreckTrack.json";
    private static final String GENERAL_FILE = "./data/testWriterGeneralTreckTrack.json";

    @Test
    void testWriterInvalidFile() {
        try {
            TreckTrack tt = new TreckTrack();
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

            JsonWriter writer = new JsonWriter(GENERAL_FILE);
            writer.open();
            writer.write(tt);
            writer.close();

            JsonReader reader = new JsonReader(GENERAL_FILE);
            tt = reader.read();

            ArrayList<Hike> completedHikes = tt.getCompletedHikes();
            ArrayList<Hike> hikesToDo = tt.getHikesToDo();
            assertEquals(1, hikesToDo.size());
            assertEquals(1, completedHikes.size());

            checkCompletedHike(completedHikes.get(0), "Grouse Grind", null, null, null, null,null,
            null, null);
            checkHikeToDo(hikesToDo.get(0), "Quarry Rock", null, null, null);

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

}
