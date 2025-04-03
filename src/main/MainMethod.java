import javax.swing.*;
import java.awt.*;

public class CarRentalUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Car Rental System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        
        // Labels and text fields
        panel.add(new JLabel("Customer Name:"));
        panel.add(new JTextField(15));
        
        panel.add(new JLabel("Car Model:"));
        panel.add(new JTextField(15));
        
        panel.add(new JLabel("Rental Days:"));
        panel.add(new JTextField(5));
        
        panel.add(new JLabel("Total Cost:"));
        panel.add(new JTextField(10));
        
        // Buttons
        panel.add(new JButton("Rent Car"));
        panel.add(new JButton("Return Car"));
        panel.add(new JButton("View Inventory"));
        panel.add(new JButton("Exit"));
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
