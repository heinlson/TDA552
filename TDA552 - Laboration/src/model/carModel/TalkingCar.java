package Model.CarModel;

import Model.Point;

import java.awt.*;

import static java.lang.StrictMath.PI;

/**
 * Class extending Vehicle, simulating a vehicle model capable of speech.
 * <p>
 * Overrides speedFactor method, and contains unique turnRate value specific for this class.
 * Also contains static string variable MSG, representing what the vehicle can say.
 * <p>
 * See class Vehicle.
 */
public class TalkingCar extends Car {

    private final static String MSG = "brum brum!"; //A fully formed sentence


    /**
     * Default constructor initializing all instance variables.
     * <p>
     * Constructor sets currentSpeed to 0 by calling stopEngine method in super.
     * <p>
     * See default constructor in super.
     * @param color
     * @param position
     * @param direction
     */
    public TalkingCar(Color color, Model.Point position, Model.Point direction) {
        super(2, 200, color, position, direction, 3);
        setTurnRate(PI/9);
    }


    /**
     * Constructor for instancing objects with default position and direction.
     * Calls default constructor in class, entering the static variables titled 'default' as arguments.
     * <p>
     * See default constructor in super.
     *
     */
    public TalkingCar() {
        this(getDefaultColor(), getDefaultCoords(), getDefaultDirection());
    }

    /**
     * See speedFactor method in class Vehicle.
     * <p>
     * Sets speedFactor to 1% of enginePower.
     * @return speedFactor
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    /**
     * Prints MSG
     */
    public void speak(){
        System.out.println(MSG);
    }



}
