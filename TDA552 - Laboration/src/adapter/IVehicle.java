package adapter;

import model.Point;

import java.awt.image.BufferedImage;

public interface IVehicle {
    void startEngine();
    void stopEngine();

    void gas(double amount);
    void brake(double amount);

    Point getPosition();

    Point getDirection();

    BufferedImage getImage();



}
