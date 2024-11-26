package homework14_cars;

public class DieselMotorCar extends Car {
    DieselMotorCar() {
        super(4);
    }

    @Override
    public void startDriving() {
        if (!isCarIsDriving()) {
            setCarIsDriving(true);
            System.out.println("Diesel motor car started driving");
        } else {
            System.out.println("Diesel motor car is already driving");
        }
    }
}
