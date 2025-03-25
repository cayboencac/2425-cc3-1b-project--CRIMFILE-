public class Customer {
    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private int licenseNumber;
    
    
    public void Car(int id, String make, int year, int licensePlate, String status){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;               
    }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getName(){
            return name;      
        }
        public void setName(String name){
            this.name = name;
        }
        public String getEmail(){
            return email; 
        }
        public void setemail(String email){
            this.email = email;
        }
        public int getPhoneNumber(){
            return phoneNumber;
        }
        public void setPhoneNumber(int phoneNumber){
            this.phoneNumber = phoneNumber;
        }
        public int licenseNumber(){
            return licenseNumber;
        }
        public void setLicenseNumber(int licenseNumber){
            this.licenseNumber = licenseNumber;
        }
        
        public void displayCustomerDetails(){
            System.out.print("Customer ID: " + id);
            System.out.print("Customer Name: " + name);
            System.out.print("Customer Email: " + email);
            System.out.print("Customer Phone Number: " + phoneNumber);
            System.out.print("Customer License Number: " + licenseNumber);
        }
}
