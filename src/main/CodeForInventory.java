import java.util.ArrayList;
import java.util.List;

public class Inventory {
    // List to store Car objects
    private List<Car> cars;

    // Constructor to initialize the inventory
    public Inventory() {
        cars = new ArrayList<>();
    }

    // Method to add a Car
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added to the Inventory.");
    }

    // Method to remove a Car by ID
    public void removeCar(int carId) {
        Car carToRemove = findCarById(carId);

        if (carToRemove != null) {
            cars.remove(carToRemove);
            System.out.println("Car with ID " + carId + " has been removed from the inventory.");
        } else {
            System.out.println("Car with ID " + carId + " not found in the inventory.");
        }
    }

    // Method to find a Car by ID
    public Car findCarById(int carId) {
        for (Car car : cars) {
            if (car.getId() == carId) {
                return car;
            }
        }
        return null; // Car not found
    }

    // Method to update Car status
    public void updateCarStatus(int carId, String newStatus) {
        Car car = findCarById(carId);
        if (car != null) {
            car.setStatus(newStatus);
            System.out.println("Car ID " + carId + " status updated to: " + newStatus);
        } else {
            System.out.println("Car with ID " + carId + " not found.");
        }
    }

    // Method to get a list of available cars
    public List<Car> getAvailableCars() {
        List<Car> availableCars = new ArrayList<>();
        for (Car car : cars) {
            if ("Available".equalsIgnoreCase(car.getStatus())) {
                availableCars.add(car);
            }
        }
        return availableCars;
    }

    // Method to get total number of Cars in Inventory
    public int getTotalCars() {
        return cars.size();
    }

    // Method to display all Cars in Inventory
    public void displayInventory() {
        if (cars.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("Current Inventory:");
        for (Car car : cars) {
            car.displayCarDetails();
            System.out.println("-------------------------");
        }
    }
}
