package model;

/**
 * Interface defining methods for movement.
 */
public interface Movable {

    /**
     * Updates position.
     */
    void move();

    /**
     * Method for turning left.
     */
    void turnLeft();

    /**
     * Method for turning right.
     */
    void turnRight();
}
