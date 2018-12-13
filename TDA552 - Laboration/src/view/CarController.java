package View;
import Model.CarModel.*;
import Model.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    List<Car> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(Color.BLACK, new Point(150, 100), new Point(0, -1)));
        cc.cars.add(new Saab95(Color.BLACK, new Point(250, 100), new Point(0, -1)));
        cc.cars.add(new Scania(Color.BLACK, new Point(350, 100), new Point(0, -1)));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Car car : cars) {
                car.move();
                frame.drawPanel.moveit(car);
                frame.drawPanel.repaint();
            }
        }
    }




    //--------------Methods for user input-------------------------


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Car car : cars) {
            car.gas(gas);
        }

    }


    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars
        ) {
            car.brake(brake);
        }
    }


    void setTurboOn(){
        for (Car car : cars){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    void setTurboOff(){
        for (Car car : cars){
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    void setBedAngle(int amount){
        for (Car car : cars){
            if(car instanceof Scania){
                ((Scania) car).setBedAngle(amount);
            }
        }
    }

    void speak(){
        for (Car car : cars){
            if(car instanceof TalkingCar){
                ((TalkingCar) car).speak();
            }
        }
    }

    void startAllCars(){
        for (Car car : cars){
            car.startEngine();
        }
    }

    void stopAllCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }


}