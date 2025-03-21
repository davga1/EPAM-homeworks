package homework14_cars;

public class FuelMotorCar extends Car implements GasSwitchable {
    private boolean switchedToGas = false;

    FuelMotorCar() {
        super(4);
    }

    @Override
    public void switchToGas() {
        switchedToGas = !switchedToGas;
        System.out.println(switchedToGas ? "Fuel motor car is switched to gas" : "Fuel motor car is switched to petrol");
    }

    @Override
    public void startDriving() {
        if (!isCarIsDriving()) {
            System.out.println(switchedToGas ? "Fuel motor car is driving using gas" :
                    "Fuel motor car is driving using petrol");
            setCarIsDriving(true);
        } else {
            System.out.println("Fuel motor car is already driving");
        }
    }
}
