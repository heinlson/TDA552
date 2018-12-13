package view;

import model.IVehicle;
import model.IVehicleModel;

import java.awt.*;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private final IVehicleModel model;


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, IVehicleModel model) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.pink);
        this.model = model;
    }


    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(IVehicle vehicle : model){
            int xPosition = (int)vehicle.getPosition().getX();
            int yPosition = (int)vehicle.getPosition().getY();
            g.drawImage(vehicle.getImage(), xPosition, yPosition, null);
        }
    }
}