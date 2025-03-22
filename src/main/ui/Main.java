package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        boolean useGUI = true;
        try {
            TreckTrackApp treckTrackApp = new TreckTrackApp();
            if (useGUI) {
                new TreckTrackUI(treckTrackApp).showUI();
            } else {
                new TreckTrackConsole(treckTrackApp).runApp();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application; file not found");
        }
    }
}
