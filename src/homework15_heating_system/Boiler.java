package homework15_heating_system;

public abstract class Boiler {
    private final String firm;
    private final String type;
    private final double volumeOfBoiler;
    private final double boilerEfficiency;

    public abstract double getElectricityPriceForOneCubicMeterOfWater();

    protected Boiler(String firm, String type, double volumeOfBoiler, double boilerEfficiency) {
        this.firm = firm;
        this.type = type;
        this.boilerEfficiency = boilerEfficiency;
        this.volumeOfBoiler = volumeOfBoiler;
    }

    public double getVolumeOfBoiler() {
        return volumeOfBoiler;
    }

    public double getBoilerEfficiency() {
        return boilerEfficiency;
    }

    public String getFirm() {
        return firm;
    }

    public String getType() {
        return type;
    }

    public double getMonthlyElectricityCost(int daysInMonth, double electricityPower) {
        double dailyElectricityConsumption = electricityPower * 8; //8 hours per day
        double monthlyElectricityConsumption = dailyElectricityConsumption * daysInMonth;
        double monthlyElectricityCost = monthlyElectricityConsumption * getElectricityPriceForOneCubicMeterOfWater();
        return monthlyElectricityCost;
    }

}
