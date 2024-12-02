package homework15_heating_system;

public class GasBoiler extends Boiler implements ContainsGasEnergyContent, GasUsable {

    protected GasBoiler(String firm, String type, double volumeOfBoiler) {
        super(firm, type, volumeOfBoiler, 0.85);
    }

    @Override
    public double getGasPriceForOneCubicMeter() {
        return 140;
    }

    @Override
    public double getElectricityPriceForOneCubicMeterOfWater() {
        return 46.2;
    }

    @Override
    public double getGasEnergyContent() {
        return 9.5;
    }

    public double getGasCost(double area, double heatLostCoefficient, double desiredTemperature, double averageTemperature, int daysInMonth) {
        double requiredHeat = area * heatLostCoefficient * (desiredTemperature - averageTemperature);
        double gasConsumption = (requiredHeat / (getBoilerEfficiency() * getGasEnergyContent()) * daysInMonth);
        double gasCost = gasConsumption * getGasPriceForOneCubicMeter();
        return gasCost;
    }

}