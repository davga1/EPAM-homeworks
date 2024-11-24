package homework14_cars;

public class MotorCycle extends Car {
    MotorCycle() {
        super(2);
    }

    @Override
    public void startDriving() {
        System.out.println("Started driving on motorcycle");
    }
}
