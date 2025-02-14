package model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestHikesToDo {

    private ArrayList<Hike> hikesToDo;
    private Hike hike1;

    @BeforeEach
    void runBefore() {
        hikesToDo = new ArrayList<>();
        hike1 = new Hike("Mount Rainier");
    }


}
