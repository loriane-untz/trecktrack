package ui;

import java.io.FileNotFoundException;

import model.EventLog;
import model.TreckTrackApp;

public class Main {
    public static void main(String[] args) {

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\n--- Event Log ---");
            for (model.Event e : EventLog.getInstance()) {
                System.out.println(e);
                System.out.println();
            }
        }));

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
