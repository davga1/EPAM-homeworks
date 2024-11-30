package homework15_heating_system;

public class Main {
    public static void main(String[] args) {
        // Create different types of boilers
        GasBoiler gasBoiler = new GasBoiler("GasBoilerCo", "Model G1", 200);
        ElectricBoiler electricBoiler = new ElectricBoiler("ElectricBoilerCo", "Model E1", 150);
        SolarBoiler solarBoiler = new SolarBoiler("SolarBoilerCo", "Model S1", 100);

        // Create HeatingSystems for testing
        HouseHeatingSystem houseHeatingSystemWithGas = new HouseHeatingSystem(gasBoiler, 150, 22);
        HouseHeatingSystem houseHeatingSystemWithElectric = new HouseHeatingSystem(electricBoiler, 150, 22);
        ApartmentHeatingSystem apartmentHeatingSystemWithSolar = new ApartmentHeatingSystem(solarBoiler, 75, 20);

        // Test cost calculation for a 30-day month
        System.out.println("House Heating System with Gas Boiler:");
        houseHeatingSystemWithGas.getCost(30);

        System.out.println("\nHouse Heating System with Electric Boiler:");
        houseHeatingSystemWithElectric.getCost(30);

        System.out.println("\nApartment Heating System with Solar Boiler:");
        apartmentHeatingSystemWithSolar.getCost(30);
    }
}
