import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Get the customer's details
        System.out.print("Enter the customer's name: ");
        String customerName = scanner.nextLine().trim();

        System.out.print("Enter the customer's email: ");
        String customerEmail = scanner.nextLine().trim();

        System.out.print("Enter the customer's phone number: ");
        String customerPhoneNumber = scanner.nextLine().trim();

        System.out.print("Enter the customer's location (city): ");
        String customerLocation = scanner.nextLine().trim();

        // Get the number of meals
        System.out.print("Enter the number of meals ordered: ");
        int numberOfMeals = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Enter the list of meals and their prices (e.g., 'Pizza 10.50').");

        // Use a loop to get the meal details from the user
        double totalAmount = 0;
        for (int i = 0; i < numberOfMeals; i++) {
            System.out.print("Meal " + (i + 1) + " name: ");
            String mealName = scanner.nextLine().trim();

            System.out.print("Meal " + (i + 1) + " price: ");
            double mealPrice = Double.parseDouble(scanner.nextLine().trim());

            totalAmount += mealPrice;
        }

        System.out.println("Enter any special instructions: ");
        String specialInstructions = scanner.nextLine().trim();

        // Create a DriverManager instance to load the drivers from the file
        DriverManager driverManager = new DriverManager();
        List<Driver> drivers = driverManager.loadDrivers();

        // Find the best driver for the customer's location with the least load
        Driver bestDriver = findBestDriver(drivers, customerLocation);

        // Format the invoice output as required
        printInvoice(
            customerName, customerEmail, customerPhoneNumber, customerLocation,
            numberOfMeals, totalAmount, specialInstructions, bestDriver
        );

        // Close the scanner
        scanner.close();
    }

    // Method to find the driver with the lowest load for a given location
    public static Driver findBestDriver(List<Driver> drivers, String location) {
        Driver bestDriver = null;
        int minLoad = Integer.MAX_VALUE;

        for (Driver driver : drivers) {
            if (driver.getLocation().equalsIgnoreCase(location)) {
                if (driver.getLoad() < minLoad) {
                    minLoad = driver.getLoad();
                    bestDriver = driver;
                }
            }
        }

        return bestDriver;
    }

    // Method to print the invoice in the requested format
    public static void printInvoice(
        String customerName, String customerEmail, String customerPhoneNumber,
        String customerLocation, int numberOfMeals, double totalAmount,
        String specialInstructions, Driver bestDriver
    ) {
        // Print the invoice in the required format line by line
        System.out.println("Order Number: 1234");
        System.out.println("Customer: " + customerName);
        System.out.println("Email: " + customerEmail);
        System.out.println("Phone number: " + customerPhoneNumber);
        System.out.println("Location: " + customerLocation);
        System.out.println("You have ordered the following from Aesop's Pizza in " + customerLocation + ":");

        // Print the meals ordered
        for (int i = 1; i <= numberOfMeals; i++) {
            System.out.println(i + "x Pizza (R" + (totalAmount / numberOfMeals) + ")");
        }

        // Print special instructions if provided
        System.out.println("Special instructions: " + specialInstructions);

        // Print the total amount
        System.out.println("Total: R" + totalAmount);

        // Print the driver details if available
        if (bestDriver != null) {
            System.out.println(bestDriver.getName() + " is nearest to the restaurant and so he will be delivering your order to you at: ");
            System.out.println(bestDriver.getLocation());
            System.out.println("If you need to contact the restaurant, their number is 0987654321");
        } else {
            System.out.println("No available drivers found for your location.");
        }
    }
}
