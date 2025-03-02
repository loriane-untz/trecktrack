package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

// CODE FROM THE FOLLOWING REPOSITORY WAS USED AS REFERENCE: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

public class JsonTest {

    protected void checkHike(Hike actualHike, String expectedName, String expectedLocation,
            String expectedDistance, String expectedPeakElevation, String expectedTotalTime,
            String expectedDifficultyRating, String expectedEnjoymentRating, String expectedNotes) {
        assertEquals(expectedName, actualHike.getName());
        assertEquals(expectedLocation, actualHike.getLocation());
        assertEquals(expectedDistance, actualHike.getDistance());
        assertEquals(expectedPeakElevation, actualHike.getPeakElevation());
        assertEquals(expectedTotalTime, actualHike.getTotalTime());
        assertEquals(expectedDifficultyRating, actualHike.getDifficultyRating());
        assertEquals(expectedEnjoymentRating, actualHike.getEnjoymentRating());
        assertEquals(expectedNotes, actualHike.getNotes());
    }
}
