package homework15_heating_system;

public class HouseHeatingSystem extends HeatingSystem {
    HouseHeatingSystem(Boiler boiler, double area, double desiredTemperature) {
        super(boiler, area, 0.5, desiredTemperature);
    }
}
