//Write overloaded convertTemperature methods:
//One version accepts a temperature in Celsius and returns it in Fahrenheit.
//The other version accepts a temperature in Fahrenheit and returns it in Celsius.

package homework7_overloaded_methods;

public class ConvertTemperature {

    static double convertTemperature(double temperatureInCelsius) {
        if (temperatureInCelsius < -273.15) { //absolute zero
            return -459.67;
        }
        return temperatureInCelsius * 9 / 5 + 32;
    }

    static double convertTemperature(double temperatureInFahrenheit, boolean isFahrenheit) {
        if (temperatureInFahrenheit < -459.67) {
            return -273;
        }
        return ((temperatureInFahrenheit - 32) * 5 / 9);
    }

    public static void main(String[] args) {
        float temperatureInCelsius = 66;
        double temperatureInFahrenheit = 150.8;
        System.out.println(temperatureInCelsius + " Celsius is " + convertTemperature(temperatureInCelsius) + " Fahrenheit");
        System.out.println(temperatureInFahrenheit + " Fahrenheit is " + convertTemperature(temperatureInFahrenheit,true) + " Celsius");
    }
}
