package model;

import model.carModel.AbstractCar;

import java.util.ArrayList;
import java.util.List;

/**
 * Class simulating a car ferry. Extends AbstractIVehicle.
 * <p>
 * Overrides speedFactor() and move() methods from super.
 * Implements interface HasCargo.
 * <p>
 * See class AbstractIVehicle and interface  HasCargo.
 */
public class CarFerry extends AbstractIVehicle implements HasCargo{
    private final static double enginePower = 300;
    private static final int maxCargoCapacity = 16;
    private List<AbstractCar> abstractCarList; //represents cargo
    private Ramp ramp; //See class Ramp.


    public CarFerry(){
        super(new Point(100,100), new Point(-1,0));
        abstractCarList = new ArrayList<>();
        ramp = new Ramp();
        setEnginePower(enginePower);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }


    /**
     * Calls gas() method in AbstractIVehicle if ramp is UP.
     * See gas() in AbstractIVehicle.
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
     * Sets ramp to DOWN.
     */
    public void lowerBed() {
        if(getCurrentSpeed() == 0){
            ramp.lowerBed();
        }
    }



    /**
     * Adds AbstractCar instances to abstractCarList in a try/catch.
     * Calls canAddToCargo() method to see if object is eligible to be placed in cargo.
     * If placed in cargo, changes transport status of cargo to onTransport.
     * See method canAddToCargo(), and TransportStatus enum in AbstractCar class.
     * @param cargo
     * @param <T>
     */
    @Override
    public <T> void loadCargo(T cargo) {
        try{
            AbstractCar abstractCar = (AbstractCar)cargo;
            if (canAddToCargo(abstractCar)) {
                abstractCarList.add(abstractCar);
                abstractCar.changeTransportStatus();
            }
        }catch(IllegalArgumentException invalidArg){
            //TODO?
        }
    }

    /**
     * Checks if cargo is eligible to be placed in abstractCarList.
     * @param abstractCar
     * @return
     */
    private boolean canAddToCargo(AbstractCar abstractCar){
        boolean hasSpace = abstractCarList.size() < maxCargoCapacity;
        boolean isAtSameLocation = this.getPosition().equals(abstractCar.getPosition());

        return !ramp.bedIsUp() && !abstractCarList.contains(abstractCar) && hasSpace && isAtSameLocation;
    }

    /**
     * Removes latest placed element in abstractCarList if ramp is DOWN.
     * Changes transport status of removed element to notOnTransport.
     * See TransportStatus enum in AbstractCar class.
     */
    @Override
    public void unloadCargo(){
        if(!ramp.bedIsUp()) {
            AbstractCar abstractCar = abstractCarList.remove(0);
            abstractCar.changeTransportStatus();
        }
    }


    /**
     * Makes sure cargo has same position as itself when moving.
     */
    @Override
    public void move(){
        super.move();
        for(AbstractCar abstractCar : abstractCarList){
            abstractCar.getPosition().setPoint(this.getPosition());
        }
    }
}
