package view;

import model.IVehicleModel;

import javax.swing.*;
import java.awt.*;

public class VehicleView extends JFrame{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 800;
    private static final String title = "CarSim 1.0";

    private DrawPanel drawPanel;

    private JPanel controlPanel = new JPanel();

    private JPanel gasPanel = new JPanel();
    private JSpinner gasSpinner = new JSpinner();
    private JLabel gasLabel = new JLabel("Amount of gas");

    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");

    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");
    private JButton addCarButton = new JButton("Add car");
    private JButton removeCarButton = new JButton("Remove car");



    public VehicleView(IVehicleModel model){
        drawPanel = new DrawPanel(FRAME_WIDTH, FRAME_HEIGHT - 240, model);
        initComponents();
    }

    private void initComponents() {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        setSpinner(0,0,100,1);

        setPanels();

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setSpinner(int initValue, int minValue, int maxValue, int stepSize) {
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(initValue, //initial value
                        minValue, //min
                        maxValue, //max
                        stepSize);//step
        gasSpinner = new JSpinner(spinnerModel);
    }

    private void setPanels() {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addCarButton, 6);
        controlPanel.add(removeCarButton, 7);

        controlPanel.setPreferredSize(new Dimension((FRAME_WIDTH/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(FRAME_WIDTH/5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(FRAME_WIDTH/5-15,200));
        this.add(stopButton);
    }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JSpinner getGasSpinner() {
        return gasSpinner;
    }

    public DrawPanel getDrawPanel() {
        return drawPanel;
    }

    public static int getFrameWidth() {
        return FRAME_WIDTH;
    }

    public static int getFrameHeight() {
        return FRAME_HEIGHT;
    }

    public JButton getAddCarButton() { return addCarButton; }

    public JButton getRemoveCarButton() {
        return removeCarButton;
    }
}
