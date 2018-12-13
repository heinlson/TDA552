package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class for connecting the model to the controller and view
 * by using an iterator.
 */
public class IVehicleModel implements Iterable<IVehicle>{
    List<IVehicle> vehicles = new ArrayList<>(); //List to be iterated.

    /**
     * Adds argument to list
     * @param vehicle
     */
    public void add(IVehicle vehicle){
        vehicles.add(vehicle);
    }

    //TODO javadoc
    public void addRandom(){
        vehicles.add(VehicleFactory.createRandomCar());
    }

    public void removeRandom(){
        vehicles.remove(0);
    }

    public int size(){
        return vehicles.size();
    }

    /**
     * Iterate list
     * @return list
     */
    @Override
    public Iterator iterator() {
        return vehicles.iterator();
    }
}
