package homework15_heating_system;

public class ElectricBoiler extends Boiler {

    public ElectricBoiler(String firm, String type, double volumeOfBoiler) {
        super(firm, type, volumeOfBoiler, 0.3);
    }

    @Override
    public double getElectricityPriceForOneCubicMeterOfWater() {
        return 46.2;
    }
}