package homework14_cars;

public class Main {
    public static void main(String[] args) {
        //Did some tests like trying to start driving twice without stopping the car, switching gas and driving with/without gas
        FuelMotorCar fuelMotorCar = new FuelMotorCar();
        fuelMotorCar.stop();
        fuelMotorCar.switchToGas();
        fuelMotorCar.startDriving();
        fuelMotorCar.stop();
        fuelMotorCar.switchToGas();
        fuelMotorCar.startDriving();
        fuelMotorCar.startDriving();
        fuelMotorCar.stop();
        DieselMotorCar d = new DieselMotorCar();
        d.stop();
        d.startDriving();
        d.stop();
        HybridElectroCar h = new HybridElectroCar();
        h.stop();
        h.startDriving();
        h.stop();
        h.switchToGas();
        h.startDriving();
        h.stop();
        h.switchToGas();
        h.startDriving();
        h.stop();
        MotorCycle m = new MotorCycle();
        m.startDriving();
        m.stop();
    }
}
