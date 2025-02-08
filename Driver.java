public class Driver {
    private String name;
    private String location;
    private int load;

    // Constructor
    public Driver(String name, String location, int load) {
        this.name = name;
        this.location = location;
        this.load = load;
    }

    // Getters and setters for the fields
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    @Override
    public String toString() {
        return "Driver{name='" + name + "', location='" + location + "', load=" + load + "}";
    }
}
