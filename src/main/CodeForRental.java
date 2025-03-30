public class Rental {
    private int rentalId;
    private int totalCost;
    private int carId;
    private int rentalDate;
    private int returnDate;
    
    private static final int COST_PER_DAY = 4500; // Cost per day for rental

    // Constructor
    public Rental(int rentalId, int carId, int rentalDate, int returnDate) {
        this.rentalId = rentalId;
        this.carId = carId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate; 
        this.totalCost = calculateTotalCost();
    }

    // Method to calculate total cost
    private int calculateTotalCost() {
        int days = returnDate - rentalDate;
        return days > 0 ? days * COST_PER_DAY : 0;
    }

    // Getters and Setters
    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;        
    }

    public int getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(int rentalDate) {
        this.rentalDate = rentalDate;        
    }

    public int getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(int returnDate) {
        this.returnDate = returnDate;
        this.totalCost = calculateTotalCost(); // Update total cost when return date changes
    }

    // Extend the rental period
    public void extendRental(int extraDays) {
        if (extraDays > 0) {
            returnDate += extraDays;
            totalCost = calculateTotalCost();
            System.out.println("Rental extended by " + extraDays + " days. New return date: " + returnDate);
        } else {
            System.out.println("Invalid extension period.");
        }
    }

    // Check if rental is overdue
    public boolean isOverdue(int currentDate) {
        return currentDate > returnDate;
    }

    // Display rental details
    public void displayRentalDetails() {
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Car ID: " + carId);
        System.out.println("Rental Date: " + rentalDate);
        System.out.println("Return Date: " + returnDate);
        System.out.println("Total Cost: $" + totalCost);
    }
}
