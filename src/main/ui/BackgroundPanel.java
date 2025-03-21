package ui;

import javax.swing.JPanel;
import java.awt.image.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

// represents a custom Jpanel with a backgroud image that is used for the main menu
public class BackgroundPanel extends JPanel {

    private BufferedImage backgroundImg;

    // constructs a BackgroundPannel with a background image
    public BackgroundPanel(String imgPath) {
        try {
            backgroundImg = ImageIO.read(new File(imgPath));
        } catch (IOException e) {
            System.out.println("Could not load background image");
        }
        setLayout(new BorderLayout());
    }

    // EFFECTS: draws the background image to fill the panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImg != null) {
            g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
