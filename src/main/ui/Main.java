package ui;

import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TreckTrackUI ui = new TreckTrackUI();
                ui.showUI();
                // try {
                //     new TreckTrackApp();
                // } catch (FileNotFoundException e) {
                //     System.out.println("Unable to run application; file not found");
                // }
            }
        });
    }
    //     SwingUtilities.invokeLater(() -> {
    //         try {
    //             System.out.println("Initializing TreckTrackApp...");
    //             TreckTrackApp treckTrackApp = new TreckTrackApp();
    //             System.out.println("Launching UI...");
    //             TreckTrackUI ui = new TreckTrackUI(treckTrackApp);
    //             ui.showUI();
    //         } catch (FileNotFoundException e) {
    //             System.out.println("Unable to run application; file not found");
    //         }
    //     });
    // }
}
