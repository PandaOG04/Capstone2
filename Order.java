import java.util.List;

public class Order {
    private String orderNumber;
    private Customer customer;
    private Restaurant restaurant;
    private List<Meal> meals;
    private String specialInstructions;
    private double totalAmount;
    private Driver driver;
    private String deliveryAddress;
    // Order constructor
    public Order(String orderNumber, Customer customer, Restaurant restaurant, List<Meal> meals, String specialInstructions, Driver driver, String deliveryAddress) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.restaurant = restaurant;
        this.meals = meals;
        this.specialInstructions = specialInstructions;
        this.driver = driver;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = calculateTotalAmount();
    }
    // Calculate the total amount of the meal
    private double calculateTotalAmount() {
        double total = 0;
        for (Meal meal : meals) { // Iterate meals and add price to total
            total += meal.getPrice();
        }
        return total;
    }
    // Create an invoice with all the details
    public void generateInvoice() {
        String invoice = "Order Number: " + orderNumber + "\n";
        invoice += "Customer: " + customer.getName() + "\n";
        invoice += "Email: " + customer.getEmail() + "\n";
        invoice += "Phone Number: " + customer.getContactNumber() + "\n";
        invoice += "Location: " + customer.getAddress() + "\n";
        invoice += "You have ordered the following from " + restaurant.getName() + " in " + restaurant.getLocation() + ":\n";
        // Loop trough meals and add to invoice
        for (Meal meal : meals) {
            invoice += meal.getName() + " (" + meal.getPrice() + ")\n";
        }

        invoice += "Special Instructions: " + specialInstructions + "\n";
        invoice += "Total: R" + totalAmount + "\n";

        invoice += driver.getName() + " is nearest to the restaurant and will be delivering your order to you at: " + deliveryAddress + "\n";
        invoice += "If you need to contact the restaurant, their number is " + restaurant.getContactNumber() + "\n";

        try {
            java.nio.file.Files.write(java.nio.file.Paths.get("invoice_" + orderNumber + ".txt"), invoice.getBytes());
        } catch (java.io.IOException e) {
            System.out.println("Error writing invoice to file");
        }
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public Driver getDriver() {
        return driver;
    }
}
