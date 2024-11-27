package homework15_heating_system;

public abstract class Boiler {
    private final String firm;
    private final String type;
    private final double volumeOfBoiler;
    private final double boilerEfficiency;
    private final double gasEnergyContent;

    public abstract double getGasPriceForOneCubicMeter();

    public abstract double getElectricityPriceForOneCubicMeterOfWater();

    protected Boiler(String firm, String type, double volumeOfBoiler, double boilerEfficiency, double gasEnergyContent) {
        this.firm = firm;
        this.type = type;
        this.gasEnergyContent = gasEnergyContent;
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

    public double getGasEnergyContent() {
        return gasEnergyContent;
    }
}
