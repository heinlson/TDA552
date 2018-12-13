package adapter;

import model.Point;

import java.awt.image.BufferedImage;

class VehicleWrapper implements IVehicle{
    /*
    private Vehicle wrappedVehicle;

    VehicleWrapper(Vehicle toBreWrapped){
        this.wrappedVehicle = toBreWrapped;
    }
    */

    @Override
    public void startEngine() {

    }

    @Override
    public void stopEngine() {

    }

    @Override
    public void gas(double amount) {

    }

    @Override
    public void brake(double amount) {

    }

    @Override
    public Point getPosition() {
        return null;
    }

    @Override
    public Point getDirection() {
        return null;
    }

    @Override
    public BufferedImage getImage() {
        return null;
    }
}
