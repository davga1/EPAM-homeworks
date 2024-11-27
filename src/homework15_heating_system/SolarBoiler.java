package homework15_heating_system;

public class SolarBoiler extends Boiler {

    protected SolarBoiler(String firm, String type, double volumeOfBoiler, double gasEnergyContent) {
        super(firm, type, volumeOfBoiler, 0.1, gasEnergyContent);
    }

    @Override
    public double getGasPriceForOneCubicMeter() {
        return 0;
    }

    @Override
    public double getElectricityPriceForOneCubicMeterOfWater() {
        return 5;
    }
}