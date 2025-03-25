public class Car {
    private int id;
    private String make;
    private int year;
    private int licensePlate;
    private String status;
    
    public void Car(int id, String make, int year, int licensePlate, String status){
        this.id = id;
        this.make = make;
        this.year = year;
        this.licensePlate = licensePlate;
        this.status = status;               
    }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getMake(){
            return make;      
        }
        public void setMake(String make){
            this.make = make;
        }
        public int getYear(){
            return year; 
        }
        public void setYear(int year){
            this.year = year;
        }
        public int getLicensePlate(){
            return licensePlate;
        }
        public void setLicensePlate(int LicensePlate){
            this.licensePlate = licensePlate;
        }
        public String getStatus(){
            return status;
        }
        public void setStatus(String status){
            this.status = status;
        }
        
        public void displayCarDetails(){
            System.out.print("Car ID: " + id);
            System.out.print("Car Make: " + make);
            System.out.print("Year: " + year);
            System.out.print("License Plate: " + licensePlate);
            System.out.print("Car Status: " + status);
        }
}

