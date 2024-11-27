package homework15_heating_system;

public class Main {
    public static void main(String[] args) {
        // Test 1: Gas Boiler with Apartment Heating System
        GasBoiler gasBoiler = new GasBoiler("GasFirm", "ModelX", 150, 30);
        ApartmentHeatingSystem apartmentHeating = new ApartmentHeatingSystem(gasBoiler, 100, 22);

        int daysInMonth = 30;
        int hoursPerDay = 8;

        double monthlyGasCost = apartmentHeating.getMonthlyGasCost(daysInMonth);
        double monthlyElectricityCost = apartmentHeating.getMonthlyElectricityCost(daysInMonth, hoursPerDay);

        System.out.println("Test 1 - Gas Boiler (Apartment Heating System):");
        System.out.println("Monthly Gas Cost: " + monthlyGasCost + " AMD");
        System.out.println("Monthly Electricity Cost: " + monthlyElectricityCost + " AMD");

        // Test 2: Electric Boiler with House Heating System
        ElectricBoiler electricBoiler = new ElectricBoiler("ElectricFirm", "ModelY", 120, 0);
        HouseHeatingSystem houseHeating = new HouseHeatingSystem(electricBoiler, 150, 22);

        monthlyGasCost = houseHeating.getMonthlyGasCost(daysInMonth);  // Should be 0 for electric boiler
        monthlyElectricityCost = houseHeating.getMonthlyElectricityCost(daysInMonth, hoursPerDay);

        System.out.println("\nTest 2 - Electric Boiler (House Heating System):");
        System.out.println("Monthly Gas Cost: " + monthlyGasCost + " AMD");
        System.out.println("Monthly Electricity Cost: " + monthlyElectricityCost + " AMD");

        // Test 3: Solar Boiler with House Heating System
        SolarBoiler solarBoiler = new SolarBoiler("SolarFirm", "ModelZ", 100, 30);
        houseHeating = new HouseHeatingSystem(solarBoiler, 150, 22);

        monthlyGasCost = houseHeating.getMonthlyGasCost(daysInMonth);  // Should be 0 for solar boiler
        monthlyElectricityCost = houseHeating.getMonthlyElectricityCost(daysInMonth, hoursPerDay);

        System.out.println("\nTest 3 - Solar Boiler (House Heating System):");
        System.out.println("Monthly Gas Cost: " + monthlyGasCost + " AMD");
        System.out.println("Monthly Electricity Cost: " + monthlyElectricityCost + " AMD");

        // Test 4: Gas Boiler with House Heating System
        gasBoiler = new GasBoiler("GasFirm", "ModelA", 200, 40);
        houseHeating = new HouseHeatingSystem(gasBoiler, 250, 22);

        monthlyGasCost = houseHeating.getMonthlyGasCost(daysInMonth);
        monthlyElectricityCost = houseHeating.getMonthlyElectricityCost(daysInMonth, hoursPerDay);

        System.out.println("\nTest 4 - Gas Boiler (House Heating System):");
        System.out.println("Monthly Gas Cost: " + monthlyGasCost + " AMD");
        System.out.println("Monthly Electricity Cost: " + monthlyElectricityCost + " AMD");
    }
}
