package model.carModel;

import model.AbstractIVehicle;
import model.Point;

/**
 * Defines a car. Extends AbstractIVehicle.
 */
public abstract class AbstractCar extends AbstractIVehicle {
    private int nrDoors; //Number of doors on vehicle
    private TransportStatus transportStatus; //Enum value for whether Car is on a transport or not.

    /**
     * Default constructor, calls other constructor in class.
     */
    public AbstractCar(){
       this(new Point(100,100), new Point(-1, 0));
    }


    /**
     * Constructor sets transportStatus to notOnTransport. Calls super
     * constructor with values given in argument.
     * @param position
     * @param direction
     */
    public AbstractCar(Point position, Point direction){
       super(position, direction);
       transportStatus = TransportStatus.notOnTransport;
    }


    //Getters and Setters

    /**
     *
     * @return nrDoors
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * Sets number of doors to value in argument.
     * @param nrDoors
     */
    protected void setNrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
    }


    /**
     * Calls super gas() method if not on transport.
     * @param amount
     */
    @Override
    public void gas(double amount){
        if(!transportStatus.isOnTransport()) {
            super.gas(amount);
        }
    }


    /**
     * Used for changing transport status (on or off transport).
     */
    public void changeTransportStatus(){
        transportStatus = transportStatus.changeStatus();
    }



    //Enum

    /**
     * Enum representing values for wether a car is on a transport or not.
     */
    private enum TransportStatus{
        onTransport, notOnTransport;

        private static TransportStatus[] vals = values();

        /**
         * Changes transport status from on to notOn or vice verse
         * @return TransportStatus value
         */
        private TransportStatus changeStatus() {
            return vals[(this.ordinal() + 1) % vals.length];
        }

        /**
         * Checks if car is on a transport or not.
         * @return boolean value
         */
        private boolean isOnTransport(){
            return this == TransportStatus.onTransport;
        }
    }
}
