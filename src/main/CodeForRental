public class Rental {
    private int rentalId;
    private int totalCost;
    private int carId;
    private int rentalDate;
    private int returnDate;
    
    public void Rental(int rentalId, int totalCost, int carId, int rentalDate, int returnDate){
        this.rentalId = rentalId;
        this.totalCost = totalCost;
        this.carId = carId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate; 
        this.totalCost = calculateTotalCost();
    }
    private int calculateTotalCost(){
        int days = returnDate - rentalDate;
        int costPerDay = 4500;
        return days > 0 ? days * costPerDay: 0;
    }
    public int getRentalId(){
        return rentalId;
    }
    public void setRentalId(int rentalId){
        this.rentalId = rentalId;
    }
    public int getTotalCost(){
        return totalCost = totalCost;
    }
    public void setTotalCost (int totalCost){
        this.totalCost = totalCost;
    }
    public int getCarId(){
        return carId;
    }
    public void setCarId(int carId){
        this.carId = carId;        
    }
    public int getRentalDate(){
        return rentalDate = rentalDate;
    }
    public void setRentalDate(int rentalDate){
        this.rentalDate = rentalDate;        
    }
    public int getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(int returnDate){
        this.returnDate = returnDate;
    }
}
