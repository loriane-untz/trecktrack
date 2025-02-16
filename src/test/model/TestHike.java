package model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHike {
    
    Hike hike1;
    Hike hike2;
    Hike hike3;

    @BeforeEach
    void runBefore() {
        hike1 = new Hike("Grouse Grind");
        hike2 = new Hike("Quarry Rock");
        hike3 = new Hike("Runner Peak");
    }

    @Test
    void constructorTest() {
        assertEquals("Grouse Grind", hike1.getName());
    }

}
