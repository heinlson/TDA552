import controller.VehicleController;
import model.IVehicleModel;
import model.VehicleFactory;
import view.VehicleView;


public class Application {



    public static void main(String[] args){
        IVehicleModel model = createModel();

        VehicleView view = new VehicleView(model);

        VehicleController controller = new VehicleController(model, view);

        controller.startTimer();
    }


    private static IVehicleModel createModel(){
        IVehicleModel vehicles = new IVehicleModel();

        vehicles.add(VehicleFactory.createSaab95());
        vehicles.add(VehicleFactory.createVolvo240());
        vehicles.add(VehicleFactory.createScania());

        return vehicles;
    }
}
