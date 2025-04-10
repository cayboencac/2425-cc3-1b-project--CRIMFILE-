import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginScreen {

    private final HashMap<String, String> users = new HashMap<>();

    public void show() {
        JFrame loginFrame = new JFrame("Login/Register - Car Rental System");
        loginFrame.setSize(400, 250);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        panel.add(registerBtn);
        panel.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (users.containsKey(username) && users.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(loginFrame,
                            "Login successful! Welcome, " + username + "!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.dispose();  // Close the login frame
                    CarRentalUI.createAndShowGUI();  // Show the Car Rental UI after login
                } else {
                    JOptionPane.showMessageDialog(loginFrame,
                            "Invalid username or password!",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(loginFrame,
                        "Username and password cannot be empty!",
                        "Registration Failed", JOptionPane.WARNING_MESSAGE);
            } else if (users.containsKey(username)) {
                JOptionPane.showMessageDialog(loginFrame,
                        "Username already exists!",
                        "Registration Failed", JOptionPane.ERROR_MESSAGE);
            } else {
                users.put(username, password);
                JOptionPane.showMessageDialog(loginFrame,
                        "Registration successful! You can now log in.",
                        "Registered", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        loginFrame.add(panel);
        loginFrame.setVisible(true);
    }
}
