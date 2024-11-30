package homework15_heating_system;

public abstract class HeatingSystem {
    private final Boiler boiler;
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

    public void getCost(int daysInMonth) {
        double gasPrice = -1;
        double electricityPrice;
        if (getBoiler() instanceof GasBoiler) {
            gasPrice = ((GasBoiler) getBoiler()).getGasCost(getArea(), getHeatLostCoefficient(), getDesiredTemperature(), getAverageTemperature(), daysInMonth);
        }
        electricityPrice = getBoiler().getMonthlyElectricityCost(daysInMonth, getElectricityPower());
        System.out.println("Monthly electricity price:" + electricityPrice + (gasPrice > 0 ? ",Monthly gas price:" + gasPrice : " "));
    }
}
