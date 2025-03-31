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
        
        
}
