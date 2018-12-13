package Model.CarModel;

import Model.Point;
import Model.Vehicle;

import java.awt.*;

public abstract class Car extends Vehicle {
    private final int nrDoors; // Number of doors on the vehicle

    public Car(int nrDoors, double enginePower, Color color, Model.Point position, Point direction, int size) {
        super(enginePower, color, position, direction, size);
        this.nrDoors = nrDoors;
    }



    /*public Car(int nrDoors, double enginePower, Color color) {
        super(enginePower, color);
        this.nrDoors = nrDoors;
    }*/


    /**
     *
     * @return nrDoors
     */
    public int getNrDoors(){
        return nrDoors;
    }
}
