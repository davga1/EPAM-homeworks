package homework15_heating_system;

public class ApartmentHeatingSystem extends HeatingSystem {

    ApartmentHeatingSystem(Boiler boiler, double area, double desiredTemperature) {
        super(boiler, area, 0.2, desiredTemperature);
    }
}
