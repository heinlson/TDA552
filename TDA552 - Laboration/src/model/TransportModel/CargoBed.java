package Model.TransportModel;

import java.util.ArrayList;
import java.util.List;


public class CargoBed {
    private List<Object> cargoList;

    /**
     * Constructor
     */
    public CargoBed() {
        cargoList = new ArrayList<>();
    }

    /**
     * Adds cargo to cargoList
     * @param o
     */
    public void addCargo(Object o){
        cargoList.add(o);
    }

    /**
     * Removes cargo from cargoList
     * @return cargo at index given in argument
     */
    public Object unloadCargo(int i){
        Object tmp = cargoList.get(i);
        cargoList.remove(i);
        return tmp;
    }


    /**
     *
     * @return size
     */
    public int size(){
        return cargoList.size();
    }

    /**
     *
     * @param i
     * @return read object at index given in argument in cargoList
     */
    public Object get(int i){
        return cargoList.get(i);
    }


}
