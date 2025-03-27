import java.util.ArrayList;
import java.util.List;

public class Inventory extends Car {
    // To store car objects
    private List<Car> cars;

    // Constructor to initialize the inventory
    public Inventory() {
        cars = new ArrayList<>();
    }

    // Method to Add Car
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added to the Inventory.");
    }

    // Method to Remove Car by ID
    public void removeCar(int carId) {
        Car carToRemove = null;
        // Iterate over cars to find the car by ID
        for (Car car : cars) {
            if (car.getId() == carId) {
                carToRemove = car;
                break;
            }
        }

        // If car found, remove it from the list
        if (carToRemove != null) {
            cars.remove(carToRemove);
            System.out.println("Car with ID " + carId + " has been removed from the inventory.");
        } else {
            // If car with the given ID is not found
            System.out.println("Car with ID " + carId + " not found in the inventory.");
        }
    }

    // Method to get a list of available cars
    public List<Car> getAvailableCars() {
        return new ArrayList<>(cars);
    }
}
