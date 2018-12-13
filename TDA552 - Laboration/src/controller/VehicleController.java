package controller;

import model.IVehicleModel;
import model.carModel.HasTurbo;
import model.HasFlatbed;
import model.IVehicle;
import view.VehicleView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleController {
    private final IVehicleModel model;
    private final VehicleView view;

    private int gasAmount = 0;


    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer;// = new Timer(delay, new EventHandler());



    public VehicleController(IVehicleModel model, VehicleView view){
        this.model = model;
        this.view = view;
        timer = new Timer(delay, new TimerListener());
        initActionListeners();
        initSpinnerListener();
    }


    private void initActionListeners(){

        view.getGasButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });

        view.getBrakeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        view.getTurboOnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        view.getTurboOffButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        view.getLiftBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        view.getLowerBedButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        view.getStartButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startEngine();
            }
        });

        view.getStopButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopEngine();
            }
        });

        view.getAddCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                addCar();
            }
        });

        view.getRemoveCarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e){
                removeCar();
            }
        });
    }


    private void initSpinnerListener(){
        view.getGasSpinner().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }









    // Calls the gas method for each car once
    private void gas(int amount) {
        double gas = ((double) amount) / 100;
        for(IVehicle vehicle : model) {
            vehicle.gas(gas);
        }
    }

    private void brake(int amount) {
        double brake = ((double) amount) / 100;
        for(IVehicle vehicle : model) {
            vehicle.brake(brake);
        }
    }

    private void turboOn() {
        for(IVehicle vehicle : model) {
            if(vehicle instanceof HasTurbo){
                ((HasTurbo) vehicle).setTurboOn();
            }
        }
    }

    private void turboOff() {
        for(IVehicle vehicle : model) {
            if(vehicle instanceof HasTurbo){
                ((HasTurbo) vehicle).setTurboOff();
            }
        }
    }

    private void liftBed() {
        for(IVehicle vehicle : model) {
            if(vehicle instanceof HasFlatbed){
                ((HasFlatbed) vehicle).raiseBed();
            }
        }
    }


    private void lowerBed() {
        for(IVehicle vehicle : model) {
            if(vehicle instanceof HasFlatbed){
                ((HasFlatbed) vehicle).lowerBed();
            }
        }
    }

    private void startEngine() {
        for(IVehicle vehicle : model) {
            vehicle.startEngine();
        }
    }

    private void stopEngine() {
        for(IVehicle vehicle : model) {
            vehicle.stopEngine();
        }
    }

    private void addCar(){
        if(model.size() < 10) {
            model.addRandom();
        }
    }

    private void removeCar(){
        if(model.size() > 0) {
            model.removeRandom();
        }
    }



    public void startTimer(){
        timer.start();
    }



    /* Each step the TimerListener moves all the abstractCars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //PositionHandler positionHandler = new PositionHandler(model);
            for (IVehicle vehicle : model) {
                PositionHandler positionHandler = new PositionHandler(vehicle);
                vehicle.move();
                positionHandler.preventOutOfBounds();
                // repaint() calls the paintComponent method of the panel
                view.getDrawPanel().repaint();
            }
        }
    }







}
