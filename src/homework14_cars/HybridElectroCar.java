package homework14_cars;

public class HybridElectroCar extends Car implements GasSwitchable {
    private boolean switchedToGas = false;

    HybridElectroCar() {
        super(4);
    }

    @Override
    public void startDriving() {
        if (!isCarIsDriving()) {
            System.out.println(switchedToGas ? "Hybrid electrocar is driving using gas" : "Hybrid electrocar is driving using electricity");
            setCarIsDriving(true);
        } else {
            System.out.println("Hybrid electrocar is already driving");
        }
    }

    @Override
    public void switchToGas() {
        switchedToGas = !switchedToGas;
        System.out.println(switchedToGas ? "Hybrid electrocar is switched to gas" : "Hybrid electrocar is switched to electricity");
    }
}
