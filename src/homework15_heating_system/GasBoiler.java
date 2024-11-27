package homework15_heating_system;

public class GasBoiler extends Boiler {

    protected GasBoiler(String firm, String type, double volumeOfBoiler, double gasEnergyContent) {
        super(firm, type, volumeOfBoiler, 0.85, gasEnergyContent);
    }

    @Override
    public double getGasPriceForOneCubicMeter() {
        return 140;
    }

    @Override
    public double getElectricityPriceForOneCubicMeterOfWater() {
        return 46.2;
    }
}