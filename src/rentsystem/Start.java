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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Start extends JFrame {

    public Start() {
        setTitle("Start Page");
        setSize(3840, 2160); // Set an initial size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Load the background image
        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/MercedesAMG-55.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set layout to null for absolute positioning
        setLayout(null);

        JButton centerButton = new JButton();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Image/Logo.png"));
        Image scaledIcon = icon.getImage().getScaledInstance(160, 112, Image.SCALE_SMOOTH);
        centerButton.setIcon(new ImageIcon(scaledIcon));
        centerButton.setOpaque(false);
        centerButton.setContentAreaFilled(false);
        centerButton.setBorderPainted(false);


        
         centerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login(); // Open the Login class frame
            }
        });

        // Set the position and size of the button
        int buttonWidth = 100;
        int buttonHeight = 100;

        int buttonX = 490; // Adjust this value as needed
        int buttonY = 360; // Adjust this value as needed

        centerButton.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);

        // Add the button to the JFrame
        add(centerButton);

        // Set JFrame visibility
        setVisible(true);
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

