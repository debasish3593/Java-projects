// WAP in java to do the following
// 1) a login page which will allow incorrect user id and password maximum 3 times

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage extends JFrame {

    private static final String USER_ID = "admin";
    private static final String PASSWORD = "password123";
    private int attempts = 0;

    // UI Components
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginPage() {
        // Setting up the frame
        setTitle("Login Page");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creating the panel for form fields
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        
        JLabel userIdLabel = new JLabel("User ID:");
        userIdField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        
        panel.add(userIdLabel);
        panel.add(userIdField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginButtonListener());

        // Message label
        messageLabel = new JLabel("Attempts left: 3", JLabel.CENTER);
        messageLabel.setForeground(Color.RED);

        // Adding components to frame
        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);
        add(messageLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    // Event listener for the login button
    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String userId = userIdField.getText();
            String password = new String(passwordField.getPassword());

            if (attempts < 3) {
                if (userId.equals(USER_ID) && password.equals(PASSWORD)) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    messageLabel.setText("Welcome!");
                } else {
                    attempts++;
                    if (attempts < 3) {
                        messageLabel.setText("Incorrect credentials. Attempts left: " + (3 - attempts));
                    } else {
                        messageLabel.setText("Account Locked. Too many attempts.");
                        JOptionPane.showMessageDialog(null, "Too many failed attempts. Account Locked.");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}