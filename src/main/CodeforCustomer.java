/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package car.rental.system;

 
public class Customer {
    private int id;
    private String name;
    private String email;
    private int phoneNumber;
    private int licenseNumber;

    // Correct Constructor
    public Customer(int id, String name, String email, int phoneNumber, int licenseNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // Additional Methods
    public void updateEmail(String newEmail) {
        if (validateEmail(newEmail)) {
            this.email = newEmail;
        } else {
            System.out.println("Invalid email format.");
        }
    }

    public void updatePhoneNumber(int newPhoneNumber) {
        if (validatePhoneNumber(newPhoneNumber)) {
            this.phoneNumber = newPhoneNumber;
        } else {
            System.out.println("Invalid phone number format.");
        }
    }

    private boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean validatePhoneNumber(int phoneNumber) {
        return String.valueOf(phoneNumber).length() == 10; // Assumes 10-digit phone numbers
    }

    // Improved Display Method
    public void displayCustomerDetails() {
        System.out.println("Customer ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("License Number: " + licenseNumber);
    }
}
