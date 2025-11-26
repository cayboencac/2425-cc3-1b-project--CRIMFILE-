import java.util.ArrayList;
import java.util.List;

public class RentalSystem {

    private ArrayList<Car> availableCars;
    private ArrayList<Car> rentedCars;

    // Constructor
    public RentalSystem() {
        availableCars = new ArrayList<>();
        rentedCars = new ArrayList<>();
        // Adding some initial cars
        availableCars.add(new Car(123, "Toyota", 2022, 300, "Available", 100));
        availableCars.add(new Car(234, "Toyota", 2024, 12745, "Available", 150));
        availableCars.add(new Car(345, "Toyota", 2025, 12385, "Available", 170));
        availableCars.add(new Car(456, "Toyota", 2021, 12445, "Available", 100));
        availableCars.add(new Car(567, "Toyota", 2015, 12645, "Available", 100));
        availableCars.add(new Car(678, "Toyota", 2016, 12865, "Available", 80));
        availableCars.add(new Car(789, "Honda", 2021, 67890, "Available", 90));
        availableCars.add(new Car(890, "Honda", 2022, 67390, "Available", 120));
        availableCars.add(new Car(912, "Honda", 2023, 67290, "Available", 150));
        availableCars.add(new Car(101, "Honda", 2023, 67840, "Available", 150));
        availableCars.add(new Car(111, "Honda", 2025, 67860, "Available", 180));
        availableCars.add(new Car(121, "Ford", 2022, 54321, "Available", 150));
        availableCars.add(new Car(131, "Ford", 2021, 54671, "Available", 100));
        availableCars.add(new Car(141, "Ford", 2019, 54891, "Available", 90));
        availableCars.add(new Car(151, "Ford", 2018, 54121, "Available", 80));
        availableCars.add(new Car(162, "Ford", 2020, 54551, "Available", 100));
        availableCars.add(new Car(172, "Ferrari", 2022, 45291, "Available", 300));
        availableCars.add(new Car(182, "Ferrari", 2023, 45991, "Available", 400));
        availableCars.add(new Car(192, "Ferrari", 2024, 45781, "Available", 600));
        availableCars.add(new Car(202, "Ferrari", 2025, 45201, "Available", 1000));
    }

    // Method to add a rental
    public boolean addRental(int carId) {
        Car car = findCarById(carId, availableCars);
        if (car != null) {
            availableCars.remove(car);
            car.setStatus("Rented");
            rentedCars.add(car);
            System.out.println(car.getMake() + " (ID: " + car.getId() + ") has been rented.");
            return true;
        } else {
            System.out.println("Car ID " + carId + " is not available.");
            return false;
        }
    }

    // Method to return a car
    public boolean returnCar(int carId) {
        Car car = findCarById(carId, rentedCars);
        if (car != null) {
            rentedCars.remove(car);
            car.setStatus("Available");
            availableCars.add(car);
            System.out.println(car.getMake() + " (ID: " + car.getId() + ") has been returned.");
            return true;
        } else {
            System.out.println("Car ID " + carId + " was not rented.");
            return false;
        }
    }

    // Method to view available cars
    public void viewAvailableCars() {
        System.out.println("Available Cars:");
        if (availableCars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : availableCars) {
                System.out.println("- ID: " + car.getId() +
                        " | Make: " + car.getMake() +
                        " | Year: " + car.getYear() +
                        " | Price/Day: " + String.format("$%.2f", car.getPricePerDay()));
            }
        }
    }

    // Method to get rented cars as a list
    public List<Car> getRentedCars() {
        return rentedCars;
    }

    // Method to add a car to the system inventory
    public void addCarToInventory(Car car) {
        availableCars.add(car);
        System.out.println(car.getMake() + " (ID: " + car.getId() + ") added to inventory.");
    }

    // Method to remove a car from the inventory
    public boolean removeCarFromInventory(int carId) {
        Car car = findCarById(carId, availableCars);
        if (car != null) {
            availableCars.remove(car);
            System.out.println(car.getMake() + " (ID: " + car.getId() + ") removed from inventory.");
            return true;
        } else {
            System.out.println("Car ID " + carId + " not found in inventory.");
            return false;
        }
    }

    // Method to find a car by ID in a given list
    private Car findCarById(int carId, ArrayList<Car> carList) {
        for (Car car : carList) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null;
    }

    // Display all cars (both available and rented)
    public void displayAllCars() {
        System.out.println("\n*** All Cars in System ***");
        viewAvailableCars();
        getRentedCars();
    }

    public ArrayList<Car> getAvailableCars() {
        return availableCars;
    }

    // Rental ID getter method
    int getRentalId() {
        throw new UnsupportedOperationException("Not supported yet."); // Placeholder method
    }
}
