package model.carModel;

/**
 * Class extending AbstractCar, simulating a car model.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains boolean variable turboOn, and a model name.
 */
public class Saab95 extends AbstractCar implements HasTurbo {
    private final static String modelName = "Saab95";
    private final static double enginePower = 325;
    private final static int nrDoors = 2;
    private boolean turboOn;


    /**
     * Constructor sets turboOn to false.
     */
    public Saab95(){
        super();
        turboOn = false;
        setNrDoors(nrDoors);
        setEnginePower(enginePower);
        setImage(modelName);
    }


    /**
     * See speedFactor method in class AbstractIVehicle.
     * <p>
     * Sets speedFactor to 1% of enginePower.
     * In case of turboOn being true, sets speedFactor to 1.3% of enginePower.
     * @return speedFactor
     */
   @Override
    protected double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    /**
     * Sets turboOn to true.
     */
    @Override
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets turboOn to false.
     */
    @Override
    public void setTurboOff(){
        turboOn = false;
    }
}