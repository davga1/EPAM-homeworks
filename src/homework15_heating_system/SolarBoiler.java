package homework15_heating_system;

public class SolarBoiler extends Boiler {

    protected SolarBoiler(String firm, String type, double volumeOfBoiler) {
        super(firm, type, volumeOfBoiler, 0.1);
    }

    @Override
    public double getElectricityPriceForOneCubicMeterOfWater() {
        return 5;
    }
}