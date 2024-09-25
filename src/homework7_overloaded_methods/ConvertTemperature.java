//Write overloaded convertTemperature methods:
//One version accepts a temperature in Celsius and returns it in Fahrenheit.
//The other version accepts a temperature in Fahrenheit and returns it in Celsius.

package homework7_overloaded_methods;

public class ConvertTemperature {

    static double convertTemperature(float temperatureInCelsius) {
        if (temperatureInCelsius < -273.15) { //absolute zero
            return -459.67;
        }
        if (temperatureInCelsius > 56.7) {//highest registered temperature on Earth
            return 132.8;
        }
        return temperatureInCelsius * 9 / 5 + 32;
    }

    static double convertTemperature(double temperatureInFahrenheit) {
        if (temperatureInFahrenheit < -459.67) {
            return -273;
        }
        if (temperatureInFahrenheit > 132.8) {
            return 56.7;
        }
        return ((temperatureInFahrenheit - 32) * 5 / 9);
    }

    public static void main(String[] args) {
        float temperatureInCelsius = 56.7f;
        double temperatureInFahrenheit = -459.4;
        System.out.println(temperatureInCelsius + " Celsius is " + convertTemperature(temperatureInCelsius) + " Fahrenheit");
        System.out.println(temperatureInFahrenheit + " Fahrenheit is " + convertTemperature(temperatureInFahrenheit) + " Celsius");
        System.out.println(convertTemperature(132.8));
    }
}
