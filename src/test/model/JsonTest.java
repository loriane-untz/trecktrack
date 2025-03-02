package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {

    protected void checkHikeToDo(Hike actualHike, String expectedName, String expectedLocation,
            String expectedDistance, String expectedPeakElevation) {
        assertEquals(expectedName, actualHike.getName());
        assertEquals(expectedLocation, actualHike.getLocation());
        assertEquals(expectedDistance, actualHike.getDistance());
        assertEquals(expectedPeakElevation, actualHike.getPeakElevation());
    }

    protected void checkCompletedHike(Hike actualHike, String expectedName, String expectedLocation,
            String expectedDistance, String expectedPeakElevation, String expectedTotalTime,
            String expectedDifficultyRating, String expectedEnjoymentRating, String expectedNotes) {
        checkHikeToDo(actualHike, expectedName, expectedLocation, expectedDistance, expectedPeakElevation);
        assertEquals(expectedTotalTime, actualHike.getTotalTime());
        assertEquals(expectedDifficultyRating, actualHike.getDifficultyRating());
        assertEquals(expectedEnjoymentRating, actualHike.getEnjoymentRating());
        assertEquals(expectedNotes, actualHike.getNotes());
    }
}
