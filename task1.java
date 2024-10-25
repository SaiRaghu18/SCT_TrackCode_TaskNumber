import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the conversion type:");
        System.out.println("1. Celsius to Fahrenheit/Kelvin");
        System.out.println("2. Fahrenheit to Celsius/Kelvin");
        System.out.println("3. Kelvin to Celsius/Fahrenheit");

        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= 3) {
            System.out.print("Enter the temperature: ");
            double temperature = scanner.nextDouble();

            switch (choice) {
                case 1:
                    double fahrenheit = (temperature * 9 / 5) + 32;
                    double kelvin = temperature + 273.15;
                    System.out.println("Fahrenheit: " + fahrenheit);
                    System.out.println("Kelvin: " + kelvin);
                    break;
                case 2:
                    double celsius = (temperature - 32) * 5 / 9;
                    kelvin = (celsius + 273.15);
                    System.out.println("Celsius: " + celsius);
                    System.out.println("Kelvin: " + kelvin);
                    break;
                case 3:
                    celsius = temperature - 273.15;
                    fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("Celsius: " + celsius);
                    System.out.println("Fahrenheit: " + fahrenheit);
                    break;
            }
        } else {
            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
        }

        scanner.close();
    }
}
