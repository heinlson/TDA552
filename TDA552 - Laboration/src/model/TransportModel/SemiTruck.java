package Model.TransportModel;

import Model.CarModel.Car;
import Model.Point;

import static java.lang.StrictMath.*;
import java.awt.*;

/**
 * Class extending Car, simulating a semi truck.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Has a CargoBed.
 * <p>
 * See class Car.
 */
public class SemiTruck extends TransportVehicle {

    //For cargo
    private CargoBed trailer = getCargoSpace();


    /**
     * Constructor
     * @param color
     * @param position
     * @param direction
     */
    public SemiTruck(Color color, Model.Point position, Model.Point direction) {
        super(2, 300, color, position, direction, 8);
        setTurnRate(PI/5);
    }


    /**
     * Constructor for instancing objects with default position and direction.
     * Calls default constructor in class, entering the static variables titled 'default' as arguments.
     * <p>
     * See default constructor in super.
     *
     */
    public SemiTruck(){
        this(getDefaultColor(), getDefaultCoords(), getDefaultDirection());
    }



    /**
     * See speedFactor method in super (class Vehicle).
     * @return speedFactor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Removes Car instance from last index in cargo space.
     */
    @Override
    public void unloadCar(){
        if(getRampExtended()){
            Car car = (Car) trailer.unloadCargo(trailer.size()-1);
            car.setPosition(new Point(this.getPosition().getX()+5,this.getPosition().getY()+5));
        }else {
            //does nothing yet
        }
    }


    /**
     * Calls move() method in super (Class TransportVehicle).
     *
     * See move() (in TransportVehicle).
     */
    @Override
    public void move(){
        super.move();
    }


}
