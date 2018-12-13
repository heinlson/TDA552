package model;

/**
 * Interface defining methods for cargo carriers
 */
public interface HasCargo {

    <T> void loadCargo(T cargo);

    void unloadCargo();

}
