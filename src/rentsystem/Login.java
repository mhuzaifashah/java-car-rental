/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentsystem;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Login extends JFrame implements ActionListener  {
     private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    static {
        Font font = new Font("Verdana", Font.PLAIN, 20);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("Button.font", font);
    }

    public Login() {
        setTitle("Login Page");
        setSize(3840, 2160); // Set the size according to your laptop dimensions
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Load the background image
        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/LOGIN.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create components
        // JLabel usernameLabel = new JLabel("Username:");
        // JLabel passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        loginButton = new JButton();
        // Set icons for the login button
        ImageIcon loginIcon = new ImageIcon(getClass().getResource("/Image/logbutton.png"));
        Image scaledIcon = loginIcon.getImage().getScaledInstance(168, 100, Image.SCALE_SMOOTH);
        loginButton.setIcon(new ImageIcon(scaledIcon));
        loginButton.setOpaque(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setBorderPainted(false);// Set the scaled icon
        loginButton.addActionListener(this);

        // Set layout to null for absolute positioning
        setLayout(null);

        // Set the position and size of components
        int componentWidth = 250;
        int componentHeight = 37;
        int horizontalGap = 10;
        int verticalGap = 20;

        // Set icons for the username and password fields
         ImageIcon usernameIcon = new ImageIcon(getClass().getResource("/Image/Usertext.png"));
        JLabel usernameLabel = new JLabel(usernameIcon);
        usernameField.setBounds(488, 248, componentWidth, componentHeight);
//        usernameField.setFont(new Font("Verdana", Font.PLAIN, 20)); // Set font and size

        ImageIcon passwordIcon = new ImageIcon(getClass().getResource("/Image/Usertext.png"));
        JLabel passwordLabel = new JLabel(passwordIcon);
        passwordField.setBounds(488, 362, componentWidth, componentHeight);
//        passwordField.setFont(new Font("", Font.PLAIN, 23));

        // Set position and size for the login button
        loginButton.setBounds(525, 443, 160, 57);

        // Add components to the JFrame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // Set JFrame visibility
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();

            // Perform authentication logic here
            if (authenticate(username, password)) {
                // Authentication successful, open HomePage
                new HomePage();
                dispose(); // Close the current login window
            } else {
                // Authentication failed, show notification
                JOptionPane.showMessageDialog(this, "Invalid username or password. Please try again.");
            }
        }
    }

    private boolean authenticate(String username, char[] password) {
        // Replace this with your actual authentication logic
        // For demonstration purposes, hardcoded username and password are used
        return "admin".equals(username) && "huzaifa".equals(new String(password));
    }

    class ImagePanel extends JPanel {
        private BufferedImage image;

        public ImagePanel(BufferedImage image) {
            this.image = image;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
