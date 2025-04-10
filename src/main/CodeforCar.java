public class Car {
    private int id;
    private String make;
    private int year;
    private int licensePlate;
    private String status;
    private int pricePerDay;

    // Constructor with pricePerDay
    public Car(int id, String make, int year, int licensePlate, String status, int pricePerDay) {
        this.id = id;
        this.make = make;
        this.year = year;
        this.licensePlate = licensePlate;
        this.status = status;
        this.pricePerDay = pricePerDay;
    }

    // Overloaded constructor without pricePerDay
    public Car(int id, String make, int year, int licensePlate, String status) {
        this.id = id;
        this.make = make;
        this.year = year;
        this.licensePlate = licensePlate;
        this.status = status;
        this.pricePerDay = 0;  // Default value for pricePerDay
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(int licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    // Additional Methods
    public void markAsRented() {
        this.status = "Rented";
    }

    public void markAsAvailable() {
        this.status = "Available";
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(this.status);
    }

    public void updateLicensePlate(int newLicensePlate) {
        this.licensePlate = newLicensePlate;
    }

    // Improved Display Method
    public void displayCarDetails() {
        System.out.println("Car ID: " + id);
        System.out.println("Make: " + make);
        System.out.println("Year: " + year);
        System.out.println("License Plate: " + licensePlate);
        System.out.println("Status: " + status);
        System.out.println("Price per day: $" + pricePerDay);
    }
}
