import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarRentalGUI {
    private Inventory inventory;
    private JFrame frame;
    private JTextArea displayArea;
    private JScrollPane scrollPane;

    public CarRentalGUI() {
        inventory = new Inventory();
        frame = new JFrame("Car Rental System");
        frame.setSize(700, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        
        JButton rentCarButton = new JButton("Rent a Car");
        JButton returnCarButton = new JButton("Return a Car");
        JButton addCarButton = new JButton("Add Car");
        JButton removeCarButton = new JButton("Remove Car");
        JButton exitButton = new JButton("Exit");
        
        panel.add(rentCarButton);
        panel.add(returnCarButton);
        panel.add(addCarButton);
        panel.add(removeCarButton);
        panel.add(exitButton);
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        scrollPane = new JScrollPane(displayArea);
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        rentCarButton.addActionListener(e -> rentCar());
        returnCarButton.addActionListener(e -> returnCar());
        addCarButton.addActionListener(e -> addCar());
        removeCarButton.addActionListener(e -> removeCar());
        exitButton.addActionListener(e -> System.exit(0));
        
        displayAvailableCars();
        frame.setVisible(true);
    }
    
    private void displayAvailableCars() {
        ArrayList<Car> availableCars = new ArrayList<>(inventory.getAvailableCars());
        if (availableCars.isEmpty()) {
            displayArea.setText("No available cars.");
        } else {
            displayArea.setText("Available Cars:\n");
            for (Car car : availableCars) {
                displayArea.append("ID: " + car.getId() + " | Make: " + car.getMake() + " | Year: " + car.getYear() + "\n");
            }
        }
    }
    
    private void rentCar() {
        String carIdStr = JOptionPane.showInputDialog("Enter Car ID to Rent:");
        if (carIdStr != null) {
            int carId = Integer.parseInt(carIdStr);
            inventory.removeCar(carId);
            displayAvailableCars();
        }
    }
    
    private void returnCar() {
        String idStr = JOptionPane.showInputDialog("Enter Car ID to Return:");
        String make = JOptionPane.showInputDialog("Enter Car Make:");
        String yearStr = JOptionPane.showInputDialog("Enter Car Year:");
        if (idStr != null && make != null && yearStr != null) {
            int id = Integer.parseInt(idStr);
            int year = Integer.parseInt(yearStr);
            Car returnedCar = new Car(id, make, year, 0, "Available");
            inventory.addCar(returnedCar);
            displayAvailableCars();
            JOptionPane.showMessageDialog(frame, "Car returned successfully.");
        }
    }
    
    private void addCar() {
        String idStr = JOptionPane.showInputDialog("Enter Car ID:");
        String make = JOptionPane.showInputDialog("Enter Car Make:");
        String yearStr = JOptionPane.showInputDialog("Enter Car Year:");
        if (idStr != null && make != null && yearStr != null) {
            int id = Integer.parseInt(idStr);
            int year = Integer.parseInt(yearStr);
            Car newCar = new Car(id, make, year, 0, "Available");
            inventory.addCar(newCar);
            displayAvailableCars();
        }
    }
    
    private void removeCar() {
        String carIdStr = JOptionPane.showInputDialog("Enter Car ID to Remove:");
        if (carIdStr != null) {
            int carId = Integer.parseInt(carIdStr);
            inventory.removeCar(carId);
            displayAvailableCars();
        }
    }
    
    public static void main(String[] args) {
        new CarRentalGUI();
    }
}
