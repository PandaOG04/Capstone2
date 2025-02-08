import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DriverManager {

    // This method loads the drivers from the drivers.txt file
    public List<Driver> loadDrivers() {
        List<Driver> driverList = new ArrayList<>();
        try {
            // Use the relative or absolute path to the drivers.txt file
            File file = new File("drivers.txt");  // Adjust path based on your setup
            System.out.println("Looking for the file at: " + file.getAbsolutePath());  // Debugging output
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String location = parts[1].trim();
                    int load = Integer.parseInt(parts[2].trim());
                    driverList.add(new Driver(name, location, load));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Driver file not found!");
            e.printStackTrace();
        }
        return driverList;
    }
}
