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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class HomePage extends JFrame implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton logoutButton;

    public HomePage() {
        setTitle("Home Page");
        setSize(3840, 2160); // Set the size according to your laptop dimensions
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Load the background image
        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/CarManage.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create buttons with images
        button1 = createButton("/Image/Rim.png");
        button2 = createButton("/Image/Rim.png");
        button3 = createButton("/Image/Rim.png");

        // Create logout button
        logoutButton = new JButton();
        ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Image/logout.png"));
        Image scaledLogoutIcon = logoutIcon.getImage().getScaledInstance(168, 100, Image.SCALE_SMOOTH);
        logoutButton.setIcon(new ImageIcon(scaledLogoutIcon));
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setBorderPainted(false);
        logoutButton.addActionListener(this);

        // Set layout to null for absolute positioning
        setLayout(null);

        // Set position and size for the buttons
        button1.setBounds(340, 26, 200, 200);
        button2.setBounds(545, 26, 200, 200);
        button3.setBounds(745, 26, 200, 200);
        logoutButton.setBounds(3, 12, 130, 59);

        // Add buttons to the JFrame
        add(button1);
        add(button2);
        add(button3);
        add(logoutButton);

        // Set JFrame visibility
        setVisible(true);
    }

    private JButton createButton(String imagePath) {
        JButton button = new JButton();
        ImageIcon buttonIcon = new ImageIcon(getClass().getResource(imagePath));
        Image scaledButtonIcon = buttonIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(scaledButtonIcon));
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == logoutButton) {
            new Login();
        } else if (e.getSource() == button1) {
            // Handle button1 click
            new AddCar();
            // Add your button1 logic here
        } else if (e.getSource() == button2) {
            // Handle button2 click
            new RentCar();            
            // Add your button2 logic here
        } else if (e.getSource() == button3) {
            // Handle button3 click
            new ReturnCar();
            // Add your button3 logic here
        }
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