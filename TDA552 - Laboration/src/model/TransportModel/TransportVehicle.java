package Model.TransportModel;

import Model.CarModel.Car;
import Model.Point;
import Model.Vehicle;

import java.awt.*;

public abstract class TransportVehicle extends Vehicle {
    private boolean rampIsExtended;
    private CargoBed cargoSpace;
    private final int nrDoors; // Number of doors on the vehicle
    
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
     * @param enginePower
     * @param color
     * @param position
     * @param direction
     * @param size
     */
    public TransportVehicle(int nrDoors, double enginePower, Color color, Model.Point position, Point direction, int size) {
        super(enginePower, color, position, direction, size);
        this.nrDoors = nrDoors;
        cargoSpace = new CargoBed();
        rampIsExtended=false;
    }

    /**
     * Checks conditions for whether cargo can be loaded to cargo space.
     *
     * @param car
     * @return boolean value
     */
    public boolean isLoadable(Car car){
        double truckXPos = this.getPosition().getX();
        double truckYPos = this.getPosition().getY();
        double carXPos = car.getPosition().getX();
        double carYPos = car.getPosition().getY();
        boolean samePosition = (truckXPos == carXPos && truckYPos == carYPos);
        boolean truckHasSpace = (cargoSpace.size()<3);
        boolean fits = car.getSize() < this.getSize();

        return (rampIsExtended && samePosition && truckHasSpace && fits);
    }

    /**
     * Extends ramp if not moving.
     */
    public void extendRamp(){
        if(getCurrentSpeed()==0){
            rampIsExtended = true;
        }
    }

    /**
     * Retracts ramp.
     */
    public void retractRamp(){
        rampIsExtended = false;
    }

    /**
     * Removes Car instance from cargo space.
     */
    public abstract void unloadCar();


    /**
     * Adds Car instance to cargo space.
     * @param car
     */
    public void loadCar(Car car){
        if (isLoadable(car)){
            car.stopEngine();
            cargoSpace.addCargo(car);
        }
    }

    /**
     * Calls move() method in super (Class Vehicle), and moveCargo().
     *
     * See move() (in Vehicle), and moveCargo().
     */
    @Override
    public void move(){
        super.move();
        moveCargo();
    }

    /**
     * Sets positional values of cargo to be the same as SemiTruck carrying it.
     */
    private void moveCargo(){
        for (int i = 0; i < cargoSpace.size(); i++){
            Car car = (Car) cargoSpace.get(i);
            car.setPosition(this.getPosition());
        }
    }


    @Override
    protected abstract double speedFactor();


    public CargoBed getCargoSpace() {
        return cargoSpace;
    }

    public boolean getRampExtended(){
        return rampIsExtended;
    }
}
