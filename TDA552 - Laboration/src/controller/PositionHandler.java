package controller;

import model.IVehicle;
import model.IVehicleModel;
import model.Point;
import view.VehicleView;

/**
 * Class for preventing a object from moving outside of view.
 */
class PositionHandler {
    private IVehicle vehicle;

    PositionHandler(IVehicle vehicle){
        this.vehicle = vehicle;
    }

    void preventOutOfBounds(){
        //for(IVehicle vehicle : model){
            double xPosition = vehicle.getPosition().getX();
            double yPosition = vehicle.getPosition().getY();
            //Point direction = vehicle.getDirection();

            if(!isInFrame(xPosition,yPosition)){
                invertDirection(vehicle);

            //}

            /*double xDirection = direction.getX();
            double yDirection = direction.getY();

            boolean isRightOfFrame = xPosition > VehicleView.getFrameWidth()-100;
            boolean isLeftOfFrame = xPosition < 0;
            boolean isBelowFrame = yPosition > VehicleView.getFrameHeight() - 300;
            boolean isAboveFrame = yPosition < 0;

            /*
            if (isAboveFrame){
                direction.setPoint(xDirection, -yDirection);
                vehicle.setPosition(new Point(xPosition, yPosition+10));
            } else if (isBelowFrame){
                direction.setPoint(xDirection, -yDirection);
                vehicle.setPosition(new Point(xPosition, yPosition-10));

            } else if (isLeftOfFrame){
                vehicle.setPosition(new Point(xPosition+10, yPosition));
                invertDirection(vehicle);


                //direction.setPoint(-xDirection, yDirection);

            } else if (isRightOfFrame){
                direction.setPoint(-xDirection, yDirection);
                vehicle.setPosition(new Point(xPosition-10, yPosition));

            }

            if(!isInFrame(xPosition, yPosition)){
                invertDirection(vehicle);
                vehicle.getPosition().setPoint(correctPosition(xPosition, yPosition));
            }
            */
        }
    }


    private boolean isInFrame(double xPosition, double yPosition){

        boolean isRightOfFrame = xPosition > VehicleView.getFrameWidth()-100;
        boolean isLeftOfFrame = xPosition < 0;
        boolean isBelowFrame = yPosition > VehicleView.getFrameHeight() - 300;
        boolean isAboveFrame = yPosition < 0;

        return  (!(isAboveFrame||isBelowFrame||isLeftOfFrame||isRightOfFrame));
    }

    /*
    private Point correctPosition(double xPosition, double yPosition){
        boolean isRightOfFrame = xPosition > VehicleView.getFrameWidth()-100;
        boolean isLeftOfFrame = xPosition < 0;
        boolean isBelowFrame = yPosition > VehicleView.getFrameHeight() - 300;
        boolean isAboveFrame = yPosition < 0;

        if(isRightOfFrame){
            return new Point(VehicleView.getFrameWidth()-100, yPosition);
        } else if(isLeftOfFrame){
            return new Point(0, yPosition);
        }else if(isAboveFrame) {
            return new Point(xPosition, 0);
        } else if(isBelowFrame) {
            return new Point(xPosition, VehicleView.getFrameHeight()-300);
        } else{
            throw new IllegalStateException("hur lyckas du?");
        }
    }
    */

    private void invertDirection(IVehicle vehicle){
        //Point direction = vehicle.getDirection();
        //direction.setPoint(-direction.getX(),-direction.getY());


        vehicle.setDirection(new Point(-vehicle.getDirection().getX(), -vehicle.getDirection().getY()));
    }


}
