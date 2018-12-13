package model;

import model.carModel.Saab95;
import model.carModel.Scania;
import model.carModel.Volvo240;

import java.util.Random;

/**
 * Class used for hiding constructors of IVehicles
 */
public class VehicleFactory {

    /**
     *
     * @return Saab95
     */
    public static IVehicle createSaab95(){
        return new Saab95();
    }

    /**
     *
     * @return Volvo240
     */
    public static IVehicle createVolvo240(){
        return new Volvo240();
    }

    /**
     *
     * @return Scania
     */
    public static IVehicle createScania(){
        return new Scania();
    }

    public static IVehicle createRandomCar(){
        Random rand = new Random();
        int randInt = rand.nextInt(3);

        switch(randInt){
            case 0:
                return createSaab95();
            case 1:
                return createVolvo240();
            case 2:
                return createScania();
            default:
                return createVolvo240();
        }
    }
}
