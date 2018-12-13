package model.carModel;
import model.HasCargo;
import model.Ramp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class extending AbstractCar, simulating a juggernaut.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Implements interface HasCargo.
 * <p>
 * See class AbstractCar and interface  HasCargo.
 */
public class Juggernaut extends AbstractCar implements HasCargo {
    private final static double enginePower = 300;
    private final static int nrDoors = 2;
    private static final int maxCargoCapacity = 10;
    private Deque<AbstractCar> abstractCarStack; //represents cargo
    private final Ramp ramp; //See class Ramp.


    public Juggernaut(){
        super();
        abstractCarStack = new ArrayDeque<>();
        ramp = new Ramp();
        setNrDoors(nrDoors);
        setEnginePower(enginePower);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Calls gas() method in AbstractCar if ramp is UP.
     * See gas() in AbstractCar.
     * @param amount
     */
    @Override
    public void gas(double amount){
        if(ramp.bedIsUp()){
            super.gas(amount);
        }
    }


    /**
     * Sets ramp to UP.
     */
    public void raiseBed() {
        ramp.raiseBed();
    }

    /**
     * Sets ramp to Down.
     */
    public void lowerBed() {
        if(getCurrentSpeed() == 0){
            ramp.lowerBed();
        }
    }


    /**
     * Adds AbstractCar instances to abstractCarStack in a try/catch.
     * Calls canAddToCargo() method to see if object is eligible to be placed in cargo.
     * If placed in cargo, changes transport status of cargo to onTransport.
     * See method canAddToCargo(), and TransportStatus enum in AbstractCar class.
     * @param cargo
     * @param <T>
     */
    @Override
    public <T> void loadCargo(T cargo) {
        try {
            AbstractCar abstractCar = (AbstractCar)cargo;
            if (canAddToCargo(abstractCar)) {
                abstractCarStack.push(abstractCar);
                abstractCar.changeTransportStatus();
            }
        }catch(IllegalArgumentException invalidArg){
            //TODO?
        }
    }

    /**
     * Checks if cargo is eligible to be placed in abstractCarStack.
     * @param abstractCar
     * @return
     */
    private boolean canAddToCargo(AbstractCar abstractCar){
        boolean hasSpace = abstractCarStack.size() < maxCargoCapacity;
        boolean isAtSameLocation = this.getPosition().equals(abstractCar.getPosition());

        return !ramp.bedIsUp() && hasSpace && !abstractCarStack.contains(abstractCar) && !abstractCar.equals(this) && isAtSameLocation;
    }


    /**
     * Removes latest placed element in abstractCarStack if ramp is DOWN.
     * Changes transport status of removed element to notOnTransport.
     * See TransportStatus enum in AbstractCar class.
     */
    @Override
    public void unloadCargo(){
        if(!ramp.bedIsUp()) {
            AbstractCar abstractCar = abstractCarStack.pop();
            abstractCar.changeTransportStatus();
        }
    }


    /**
     * Makes sure cargo has same position as itself when moving.
     */
    @Override
    public void move(){
        super.move();
        for(AbstractCar abstractCar : abstractCarStack){
            abstractCar.getPosition().setPoint(this.getPosition());
        }
    }

}
