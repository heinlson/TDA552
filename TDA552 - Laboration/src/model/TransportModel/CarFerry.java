package Model.TransportModel;

import Model.CarModel.Car;
import Model.Movable;
import Model.Point;

import java.awt.*;
import static java.lang.Math.PI;

public class CarFerry extends TransportVehicle implements Movable {

    //For cargo
    private final CargoBed cargoSpace = getCargoSpace();

    /**
     * Default constructor initializing all instance variables except for turnRate,
     * which is instead initialized by each class extending Vehicle.
     * <p>
     * Constructor sets currentSpeed to 0 by calling stopEngine method.
     * All other instance variables are initialized through constructor arguments.
     * Method checkDirection is used in constructor to correct direction given
     * in argument if needed.
     * <p>
     * See methods stopEngine and checkDirection.
     *
     * @param color
     * @param position
     * @param direction
     */
    public CarFerry(Color color, Model.Point position, Model.Point direction) {
        super(1, 700, color, position, direction, 15);
        setTurnRate(PI/8);
    }


    /**
     * Constructor for instancing objects with default position and direction.
     * Calls default constructor in class, entering the static variables titled 'default' as arguments.
     * <p>
     * See default constructor in super.
     *
     */
    public CarFerry(){
        this(getDefaultColor(), getDefaultCoords(), getDefaultDirection());
    }

    /**
     * Removes car from first index in cargo space.
     */
    @Override
    public void unloadCar(){
        if(getRampExtended()){
            Car car = (Car) cargoSpace.unloadCargo(0);
            car.setPosition(new Point(this.getPosition().getX()+5,this.getPosition().getY()+5));
        }else {
            //does nothing yet
        }
    }

    /**
     * See speedFactor method in class Vehicle.
     * @return speedFactor
     */
    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Calls move() method in super (Class TransportVehicle).
     *
     * See move() (in TransportVehicle).
     */
    @Override
    public void move() {
        super.move();
    }
}
