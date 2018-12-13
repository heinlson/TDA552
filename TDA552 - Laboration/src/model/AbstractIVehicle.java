package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.cos;
import static java.lang.StrictMath.sin;

/**
 * AbstractIVehicle is the abstract base class for all vehicle models.
 * <p>
 * A vehicle has a color, position, direction of movement,
 * a set degree of turn rate unique for each model, current speed variable, and a set engine power.
 * <p>
 * The class mainly contains various methods for allowing movement of the vehicle,
 * including: a method move; methods for turning; starting and stopping the engine;
 * as well as methods used in changing the current speed.
 *
 */
public abstract class AbstractIVehicle implements IVehicle {
    private double enginePower;
    private double currentSpeed;
    private Color color;
    private Point position;
    private Point direction;
    private double turnRate;
    private BufferedImage image;


    /**
     * Default constructor. Places vehicle at coordinates of first argument with direction of
     * value given in second argument. Calls stopEngine() method.
     * See stopEngine()
     *
     * @param position
     * @param direction
     */
    public AbstractIVehicle(Point position, Point direction){
        this.position = new Point(position);
        this.direction = new Point(direction);
        turnRate = PI/3;
        setColor(Color.BLACK);
        stopEngine();
    }


    //Getters and Setters

    /**
     *
     * @return enginePower
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Sets enginePower to value of argument.
     * @param enginePower
     */
    protected void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }


    /**
     *
     * @return currentSpeed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     *
     * @return color
     */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return position
     */
    @Override
    public Point getPosition() {
        return new Point(position);
    }

    /**
     *
     * @return direction
     */
    @Override
    public Point getDirection() {
        return direction;
    }

    /**
     *
     * @return image of vehicle
     */
    @Override
    public BufferedImage getImage(){
        return image;
    }

    /**
     * Used in subclasses to connect instances to images.
     * Images are named after the subclasses own respective name.
     * @param modelName
     */
    protected void setImage(String modelName){
        try{
            image = ImageIO.read(new File("src//pics//" + modelName + ".jpg"));
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }


    //Methods for speed

    /**
     * Sets currentSpeed to 0.1 if not already moving.
     * Simulates the engine starting.
     */
    @Override
    public void startEngine() {
        if(currentSpeed == 0) {
            currentSpeed = 0.1;
        }
    }

    /**
     * Sets currentSpeed to 0.
     * Simulates the engine being turned off.
     */
    @Override
    public void stopEngine(){
        currentSpeed = 0;
    }


    /**
     * Abstract method used for setting a speed factor unique to each subclass of AbstractIVehicle.
     * Return value determines the degree of acceleration/retardation in methods increment/decrementSpeed.
     *
     * @return speedFactor
     */
    protected abstract double speedFactor();

    /**
     * Calls method incrementSpeed() using value given as argument, after
     * first having made sure the argument is within interval [0,1] by calling
     * correctInput method.
     * See methods correctInput and incrementSpeed().
     *
     * @param amount
     */
    @Override
    public void gas(double amount) {
        amount = correctInput(amount);
        incrementSpeed(amount);
    }

    /**
     * Calls method decrementSpeed() using value given as argument, after
     * first having made sure the argument is within interval [0,1] by calling
     * correctInput method.
     * See methods correctInput and decrementSpeed().
     * @param amount
     */
    @Override
    public void brake(double amount){
        amount = correctInput(amount);
        decrementSpeed(amount);
    }

    /**
     * Increments currentSpeed by speedFactor (see speedFactor method) multiplied by argument value.
     * Also prevents currentSpeed from exceeding enginePower by calling correctSpeed() method.
     * See correctSpeed();
     * @param amount
     */
    private void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
        correctSpeed();
    }

    /**
     * Decrements currentSpeed by speedFactor (see speedFactor method) multiplied by argument value.
     * Also prevents currentSpeed from being less than 0 by calling correctSpeed() method.
     * See correctSpeed().
     * @param amount
     */
    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
        correctSpeed();
    }

    /**
     * Prevents speed from being outside of interval [0, enginePower]
     */
    private void correctSpeed() {
        if(currentSpeed > enginePower){
            currentSpeed = enginePower;
        } else if(currentSpeed < 0){
            currentSpeed = 0;
        }
    }

    /**
     * If input is greater than 1, sets value to 1. If input less than 0, sets value to 0.
     * Used in gas and break method.
     * @param amount
     * @return
     */
    private double correctInput(double amount) {
        if(amount > 1){
            amount = 1;
        } else if(amount < 0){
            amount = 0;
        }
        return amount;
    }

    //Methods from interface model.Movable

    /**
     * Sets x and y position of vehicle to the respective coordinates of the
     * direction vector multiplied by currentSpeed.
     */
    @Override
    public void move(){
        double nextX = position.getX() + direction.getX() * currentSpeed;
        double nextY = position.getY() + direction.getY() * currentSpeed;

        position.setPoint(nextX, nextY);

    }

    /**
     *  Method for changing direction to the left using the turnRate variable unique to each subClass.
     *
     */
    @Override
    public void turnLeft() {
        double nextX = direction.getX() *cos(turnRate)- direction.getY() *sin(turnRate);
        double nextY = direction.getX() *sin(turnRate)+ direction.getY() *cos(turnRate);

        direction.setPoint(nextX,nextY);
    }

    /**
     *  Method for changing direction to the right using the turnRate variable unique to each subClass.
     *
     */
    @Override
    public void turnRight() {
        double rightTurnRate = 2*PI-turnRate;

        double nextX = direction.getX() *cos(rightTurnRate)- direction.getY() *sin(rightTurnRate);
        double nextY = direction.getX() *sin(rightTurnRate)+ direction.getY() *cos(rightTurnRate);

        direction.setPoint(nextX,nextY);
    }


    //TODO
    public void setPosition(Point p){
        position.setPoint(p);
    }

    //TODO
    public void setDirection(Point p){
        direction.setPoint(p);
    }
}
