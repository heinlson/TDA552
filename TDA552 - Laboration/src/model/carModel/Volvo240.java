package model.carModel;

/**
 * Class extending AbstractCar, simulating a car model.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains a static variable trimFactor, not inherited from super.
 * Has a model name variable.
 * <p>
 * See class Vehicle.
 */
public class Volvo240 extends AbstractCar {
    private final static String modelName = "Volvo240";
    private final static double trimFactor = 1.25;
    private final static double enginePower = 310;
    private final static int nrDoors = 4;


    public Volvo240(){
        super();
        setNrDoors(nrDoors);
        setEnginePower(enginePower);
        setImage(modelName);
    }


    /**
     * See speedFactor method in class AbstractIVehicle.
     * <p>
     * Sets speedFactor to trimFactor% of enginePower.
     * As in, if trimFactor is set to 1.25, speedFactor is set to 1.25% of enginePower.
     * @return speedFactor
     */
    @Override
    protected double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
