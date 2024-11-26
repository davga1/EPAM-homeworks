package homework14_cars;

public abstract class Car {
    private int numberOfWheels;
    private boolean carIsDriving = false;

    Car(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public abstract void startDriving();

    public void stop() {
        if (isCarIsDriving()) {
            System.out.println("Car is not driving anymore");
            carIsDriving = false;
        } else {
            System.out.println("Car should be driving to stop");
        }
    }

    public boolean isCarIsDriving() {
        return carIsDriving;
    }

    protected void setCarIsDriving(boolean status) {
        carIsDriving = status;
    }
}
