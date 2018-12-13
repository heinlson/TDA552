package Test;

import Model.CarModel.Car;
import Model.CarModel.Saab95;
import Model.CarModel.Volvo240;
import Model.TransportModel.CargoBed;
import Model.Point;
import Model.TransportModel.CarFerry;
import Model.TransportModel.SemiTruck;
import Model.Vehicle;
import View.DrawPanel;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {
/*
    Car car = new Volvo240(4, 100, Color.BLACK);
    Car car2 = new Saab95(4, 100, Color.RED);



    @Test
    void getNrDoors() {
        assertEquals(vehicle.getNrDoors(), 4);
    }

    @Test
    void getEnginePower() {
        assertEquals(vehicle.getEnginePower(), 100);
    }

    @Test
    void getCurrentSpeed() {
            assertEquals(vehicle.getCurrentSpeed(), 0);
    }

    @Test
    void getColor() {
        assertEquals(vehicle.getColor(), Color.BLACK);
    }

    @Test
    void setColor() {
        vehicle.setColor(Color.RED);
        assertEquals(vehicle.getColor(), Color.RED);
    }

    @Test
    void getTurnRate(){
        assertEquals(vehicle.getTurnRate(), PI/3);
    }

    @Test
    void setTurnRate() {
        vehicle.setTurnRate(5.4);
        assertEquals(vehicle.getTurnRate(), 5.4);
    }

    @Test
    void startEngine() {
        vehicle.startEngine();
        assertEquals(vehicle.getCurrentSpeed(), 0.1);
    }

    @Test
    void stopEngine() {
        vehicle.stopEngine();
        assertEquals(vehicle.getCurrentSpeed(), 0);
    }

    @Test
    void speedFactor() {
        assertEquals(vehicle.speedFactor(), 1.25);
    }


    @Test
    void checkArgument() {

        try{
            vehicle.gas(2);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Vehicle.INVALID_ARG));
        }


        try{
            vehicle.brake(4);
        } catch(RuntimeException e){
            System.out.println(e.getMessage().equals(Vehicle.INVALID_ARG));
        }
    }


    @Test
    void gas(){
        vehicle.gas(0.5);
        assertEquals(1.25*0.5, vehicle.getCurrentSpeed());

    }

    @Test
    void brake() {
        vehicle.gas(1);
        vehicle.brake(0.5);
        assertEquals(1.25*0.5, vehicle.getCurrentSpeed());

    }

    @Test
    void move() {
        vehicle.gas(1);

        vehicle.move();
        assertEquals(100+0*1.25 ,vehicle.getPosition().getX() );
        assertEquals(100+(-1)*1.25 ,vehicle.getPosition().getY() );


    }

    @Test
    void turnLeft() {
        vehicle.turnLeft();
        assertEquals(vehicle.getDirection().getX(), 0*cos(PI/3)-(-1)*sin(PI/3));
        assertEquals(vehicle.getDirection().getY(), 0*sin(PI/3)+(-1)*cos(PI/3));
    }

    @Test
    void turnRight() {
        vehicle.turnRight();
        assertEquals(vehicle.getDirection().getX(), 0*cos((5*PI)/3)-(-1)*sin((5*PI)/3));
        assertEquals(vehicle.getDirection().getY(), 0*sin((5*PI)/3)+(-1)*cos((5*PI)/3));
    }

    @Test
    void checkDirection(){
        Vehicle c = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(1,1));

        //assertEquals(c.getDirection().getX(), sqrt(2)/2);
        //assertEquals(c.getDirection().getY(), sqrt(2)/2);

        Vehicle c2 = new Saab95(4, 100, Color.BLUE, new Point(10,10), new Point(0,2));

        assertEquals(c2.getDirection().getX(), 0);
        assertEquals(c2.getDirection().getY(), 1);
    }

    @Test
    void Constructor(){
        Vehicle c = new Saab95(4, 100, Color.BLUE);

    }




    //Labb 2
    Point p = new Point(1,1);
    SemiTruck semitruck = new SemiTruck(2, 100, Color.BLUE, p, p);

    String msg = "Is car loaded after set to loadable? ";
    String msg2 = "expected: true, actual: ";
    String msg3 = "Is vehicle loadable? expected: false, actual: ";

    @Test
    void isLoadable(){
        System.out.println(msg3 + semitruck.isLoadable(car));
    }


    @Test
    void loadCar(){
        //Allow for loading
        semitruck.extendRamp();

        //Make vehicle loadable
        car.setPosition(semitruck.getPosition());

        //Load vehicle
        semitruck.loadCar(car);

        //Check if all conditions are met
        System.out.println(msg +" "+ semitruck.getCargoSpace().get(0).equals(car));

        assertEquals(semitruck.getCargoSpace().get(0), car);


    }


    @Test
    void unloadCar(){
        //Allow for unloading
        semitruck.extendRamp();

        //Make vehicles loadable
        car.setPosition(semitruck.getPosition());
        car2.setPosition(semitruck.getPosition());



        //Load extra object to confirm that correct car is unloaded
        semitruck.loadCar(car2);

        //Load vehicle
        semitruck.loadCar(car);

        //Unload vehicle which was just loaded
        semitruck.unloadCar();

        //Check results

        if(semitruck.getCargoSpace().get(0).equals(car2)){
            System.out.println("Unload is working as expected");
        }else{
            System.out.println("Object " + semitruck.getCargoSpace().get(0) + " should have been removed but wasn't");
        }
        assertEquals(semitruck.getCargoSpace().get(0),car2);
    }

    @Test
    void move(){
        //Allow for loading
        semitruck.extendRamp();

        //Make vehicle loadable
        car.setPosition(semitruck.getPosition());
        car2.setPosition(semitruck.getPosition());

        //Load vehicle
        semitruck.loadCar(car);
        semitruck.loadCar(car2);

        //Perform action
        semitruck.move();

        //Check that vehicle has also moved
        System.out.println("move: " + msg2 + semitruck.getPosition().toString().equals(car.getPosition().toString()));

        assertEquals(semitruck.getPosition().toString(), car.getPosition().toString());
        assertEquals(semitruck.getPosition().toString(), car2.getPosition().toString());
    }

    //CarFerry
    CarFerry ferry = new CarFerry(100, Color.BLUE, p, p);

    @Test
    void unloadCargoFerry(){
        //Allow for unloading
        ferry.extendRamp();

        //Make vehicles loadable
        car.setPosition(ferry.getPosition());
        car2.setPosition(ferry.getPosition());



        //Load extra object to confirm that all is correct
        ferry.loadCar(car2);

        //Load vehicle
        ferry.loadCar(car);

        //Unload vehicle which was just loaded
        ferry.unloadCar();

        assertEquals(ferry.getCargoSpace().get(0), car);
    }




    private DrawPanel drawPanel = new DrawPanel(800,800);

    @Test
    public void testDrawPanel(){
        drawPanel.cars.add(new Volvo240());
        Car testCar = drawPanel.cars.get(0);

        drawPanel.mapCarToPosition(testCar);
        int xPosition = (int)drawPanel.carPosition.get(testCar).getX();
        int yPosition = (int)drawPanel.carPosition.get(testCar).getY();

        assertEquals(150, xPosition);
        assertEquals(100, yPosition);


        testCar.setPosition(new Point(200, 300));

        //drawPanel.mapCarToPosition(testCar);

        int xPosition2 = (int)drawPanel.carPosition.get(testCar).getX();
        int yPosition2 = (int)drawPanel.carPosition.get(testCar).getY();

        assertEquals(200, xPosition2);
        assertEquals(300, yPosition2);

    }
*/


}
