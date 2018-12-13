package model;

import java.awt.image.BufferedImage;

/**
 * Interface defining a vehicle
 */
public interface IVehicle extends Movable{

    void startEngine();
    void stopEngine();

    void gas(double amount);
    void brake(double amount);

    Point getPosition();

    void setPosition(Point position);

    Point getDirection();

    void setDirection(Point direction);

    /**
     * Used for rendering
     * @return image
     */
    BufferedImage getImage();





}
