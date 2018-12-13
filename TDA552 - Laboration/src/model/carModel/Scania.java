package model.carModel;

import model.HasFlatbed;

/**
 * Class extending AbstractCar, simulating a truck of brand Scania.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Implements interface HasFlatBed.
 * <p>
 * See class AbstractCar and interface HasFlatBed.
 */
public class Scania extends AbstractCar implements HasFlatbed {
    private final static String modelName = "Scania";
    private final static double enginePower = 300;
    private final static int nrDoors = 2;
    private double bedAngle; //variable representing angle of flatbed in degrees.



    public Scania(){
        super();
        setNrDoors(nrDoors);
        setEnginePower(enginePower);
        setImage(modelName);
    }


    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * If flatbed angle at 0, calls gas() method in super AbstractCar.
     * See gas() method in AbstractCar.
     * @param amount
     */
    @Override
    public void gas(double amount){
        if(bedAngle == 0){
            super.gas(amount);
        }
    }

    /**
     * If flatbed angle at 0, calls startEngine() method in super AbstractIVehicle.
     * See startEngine() method in AbstractIVehicle.
     */
    @Override
    public void startEngine(){
        if(bedAngle == 0){
            super.startEngine();
        }
    }


    /**
     * Raises flatbed by 10 degrees if currentSpeed is at 0.
     * Also prevents flatbed from exceeding 70 degrees by calling
     * correctAngle() method.
     * See correctAngle().
     */
    //TODO flatbed error msg
    @Override
    public void raiseBed(){
        if(getCurrentSpeed() == 0){
            bedAngle += 10;
            correctAngle();
        }
    }

    /**
     * Lowers flatbed by 10 degrees if currentSpeed is at 0.
     * Also prevents flatbed from reaching below 0 degrees by calling
     * correctAngle() method.
     * See correctAngle().
     */
    @Override
    public void lowerBed(){
        if(getCurrentSpeed() == 0){
            bedAngle -= 10;
            correctAngle();
        }
    }

    /**
     * Prevents flatbed angle from either exceeding 70 degrees
     * or reaching below 0 degrees.
     */
    private void correctAngle(){
        if(bedAngle > 70){
            bedAngle = 70;
        } else if(bedAngle < 0){
            bedAngle = 0;
        }
    }

}
