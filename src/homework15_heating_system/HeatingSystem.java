package homework15_heating_system;

public abstract class HeatingSystem {
    private Boiler boiler;
    private final double area;
    private final double heatLostCoefficient;
    private final double desiredTemperature;
    private final double averageTemperature = 10;
    private final double electricityPower = 3;

    HeatingSystem(Boiler boiler, double area, double heatLostCoefficient, double desiredTemperature) {
        this.boiler = boiler;
        this.area = area;
        this.heatLostCoefficient = heatLostCoefficient;
        this.desiredTemperature = desiredTemperature;
    }

    public double getAverageTemperature() {
        return averageTemperature;
    }

    public double getArea() {
        return area;
    }

    public double getDesiredTemperature() {
        return desiredTemperature;
    }

    public double getHeatLostCoefficient() {
        return heatLostCoefficient;
    }

    public Boiler getBoiler() {
        return boiler;
    }

    public double getElectricityPower() {
        return electricityPower;
    }

    public double getMonthlyGasCost(int daysInMonth) {
        if (getBoiler().getGasPriceForOneCubicMeter() == 0) {
            return 0;
        }

        double requiredHeat = getArea() * getHeatLostCoefficient() * (getDesiredTemperature() - getAverageTemperature());
        double gasConsumption = (requiredHeat / (getBoiler().getBoilerEfficiency() * getBoiler().getGasEnergyContent()) * daysInMonth);
        double gasCost = gasConsumption * getBoiler().getGasPriceForOneCubicMeter();
        return gasCost;
    }

    public double getMonthlyElectricityCost(int daysInMonth, int hoursPerDay) {
        double dailyElectricityConsumption = getElectricityPower() * hoursPerDay;
        double monthlyElectricityConsumption = dailyElectricityConsumption * daysInMonth;
        double monthlyElectricityCost = monthlyElectricityConsumption * getBoiler().getElectricityPriceForOneCubicMeterOfWater();
        return monthlyElectricityCost;
    }
}
