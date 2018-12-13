package model;

/**
 * Class representing a ramp
 */
public class Ramp implements HasFlatbed{
    private BedState bedState; //Enum variable representing the two states of the ramp, UP and DOWN.


    /**
     * Constructor initiates bedState to UP.
     */
    public Ramp(){
        bedState = BedState.UP;
    }


    /**
     * Sets bedState to UP.
     */
    @Override
    public void raiseBed() {
        bedState = BedState.UP;
    }

    /**
     * Sets bedState to DOWN.
     */
    @Override
    public void lowerBed() {
        bedState = BedState.DOWN;
    }

    /**
     * checks if bedState has value UP by calling isUP() method in Enum BedState.
     * See BedState.
     * @return boolean value
     */
    public boolean bedIsUp() {
        return bedState.isUp();
    }

    /**
     * Enum for representing the two states of the ramp, UP and DOWN.
     */
    private enum BedState{
        UP, DOWN;

        /**
         * Checks if the current state is UP or not.
         * @return boolean value.
         */
        private boolean isUp(){
            return this == BedState.UP;
        }
    }
}
