
import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the temperature value
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        // Prompt the user for the unit of measurement
        System.out.print("Enter the unit of the temperature (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().toUpperCase().charAt(0);

        // Perform conversion based on the input unit
        if (unit == 'C') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is equal to %.2f°F\n", temperature, fahrenheit);
        } else if (unit == 'F') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is equal to %.2f°C\n", temperature, celsius);
        } else {
            System.out.println("Invalid unit entered. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }

        scanner.close();
    }

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
