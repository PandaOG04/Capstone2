public class Customer {
    private String orderNumber;
    private String name;
    private String contactNumber;
    private String address;
    private String city;
    private String email;

    public Customer(String orderNumber, String name, String contactNumber, String address, String city, String email) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.contactNumber = contactNumber;
        this.address = address;
        this.city = city;
        this.email = email;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getEmail() {
        return email;
    }
}
