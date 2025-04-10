import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarRentalUI {

    private static RentalSystem rentalSystem = new RentalSystem();

    public static void createAndShowGUI() {
        // Create the main window frame
        JFrame frame = new JFrame("Car Rental System");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Create the container panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add a title
        JLabel title = new JLabel("Car Rental System", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(title, BorderLayout.NORTH);

        // Create the main button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 10, 10));

        JButton viewCarsBtn = new JButton("View Available Cars");
        JButton rentCarBtn = new JButton("Rent a Car");
        JButton returnCarBtn = new JButton("Return a Car");
        JButton viewRentedCarsBtn = new JButton("View Rented Cars");

        buttonPanel.add(viewCarsBtn);
        buttonPanel.add(rentCarBtn);
        buttonPanel.add(returnCarBtn);
        buttonPanel.add(viewRentedCarsBtn);

        panel.add(buttonPanel, BorderLayout.CENTER);

        // Create and add the bottom status label
        JLabel statusLabel = new JLabel("Status: Ready", JLabel.CENTER);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(statusLabel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);

        // Action for View Available Cars (GUI table)
        viewCarsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Car> availableCars = rentalSystem.getAvailableCars();

                String[] columnNames = { "Car ID", "Make", "Year", "Price Per Day", "Status" };
                Object[][] data = new Object[availableCars.size()][5];

                for (int i = 0; i < availableCars.size(); i++) {
                    Car car = availableCars.get(i);
                    data[i][0] = car.getId();
                    data[i][1] = car.getMake();
                    data[i][2] = car.getYear();
                    data[i][3] = "$" + car.getPricePerDay();  // Show price with dollar sign
                    data[i][4] = car.getStatus();  // Display updated status
                }

                JTable carTable = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(carTable);

                JFrame carFrame = new JFrame("Available Cars");
                carFrame.setSize(1000, 1000);
                carFrame.setLocationRelativeTo(null);
                carFrame.add(scrollPane);
                carFrame.setVisible(true);

                statusLabel.setText("Status: Viewing available cars.");
            }
        });

        // Action for Rent a Car
        rentCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carIdStr = JOptionPane.showInputDialog(frame, "Enter Car ID to rent:");
                try {
                    int carId = Integer.parseInt(carIdStr);
                    if (rentalSystem.addRental(carId)) {
                        statusLabel.setText("Status: Car rented successfully.");
                    } else {
                        statusLabel.setText("Status: Rent failed. Car not available.");
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Invalid car ID.");
                }
            }
        });

        // Action for Return a Car
        returnCarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String carIdStr = JOptionPane.showInputDialog(frame, "Enter Car ID to return:");
                try {
                    int carId = Integer.parseInt(carIdStr);
                    if (rentalSystem.returnCar(carId)) {
                        statusLabel.setText("Status: Car returned successfully.");
                    } else {
                        statusLabel.setText("Status: Return failed. Car not rented.");
                    }
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Status: Invalid car ID.");
                }
            }
        });

        // Action for View Rented Cars
        viewRentedCarsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the rented cars list
                List<Car> rentedCars = rentalSystem.getRentedCars();

                // Check if there are rented cars
                if (rentedCars.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No cars have been rented yet.", "No Rented Cars", JOptionPane.INFORMATION_MESSAGE);
                    return; // Exit early if no rented cars
                }

                // Define the column names for the rented cars table
                String[] columnNames = { "Car ID", "Make", "Year", "Status" };
                Object[][] data = new Object[rentedCars.size()][4];

                // Populate the data array with rented car information
                for (int i = 0; i < rentedCars.size(); i++) {
                    Car car = rentedCars.get(i);
                    data[i][0] = car.getId();  // Car ID
                    data[i][1] = car.getMake();  // Car Make
                    data[i][2] = car.getYear();  // Car Year
                    data[i][3] = car.getStatus();  // Status
                }

                // Create a JTable to display the rented cars
                JTable rentedCarTable = new JTable(data, columnNames);
                JScrollPane scrollPane = new JScrollPane(rentedCarTable);

                // Create a new JFrame to show the rented cars table
                JFrame rentedCarFrame = new JFrame("Rented Cars");
                rentedCarFrame.setSize(1000, 1000);
                rentedCarFrame.setLocationRelativeTo(null);
                rentedCarFrame.add(scrollPane);
                rentedCarFrame.setVisible(true);

                // Update the status label
                statusLabel.setText("Status: Viewing rented cars.");
            }
        });
    }

    public static void main(String[] args) {
        // First, show the login screen
        SwingUtilities.invokeLater(() -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.show();
        });
    }
}
