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

public class RentCar extends JFrame implements ActionListener {
    private JTextField carIdField;
    private JTextField regNoField;
    private JTextField carNameField;
    private JTextField price;
    private JTextField pickupDateField;
    private JTextField returnDateField;
    private JTextField phoneNo;
    private JTextField Surname;
    private JTextField CustomerID;
    private JTextField customerNameField;
    private JButton rentButton;
    private JButton logoutButton;
    private JTextField IDCard;
    private JButton homepage;

    static {
        Font font = new Font("Verdana", Font.PLAIN, 15);
        UIManager.put("TextField.font", font);
    }

    public RentCar() {
        setTitle("Rent Car Page");
        setSize(3840, 2160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/RentCar.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        carIdField = new JTextField();
        regNoField = new JTextField();
        carNameField = new JTextField();
        price = new JTextField();
        pickupDateField = new JTextField();
        returnDateField = new JTextField();
        phoneNo = new JTextField();
        Surname = new JTextField();
        CustomerID = new JTextField();
        customerNameField = new JTextField();

        rentButton = new JButton("Rent");
        homepage = new JButton();
        logoutButton = new JButton();
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setBorderPainted(false);
        ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Image/logout.png"));
        Image scaledLogoutIcon = logoutIcon.getImage().getScaledInstance(158, 100, Image.SCALE_SMOOTH);
        logoutButton.setIcon(new ImageIcon(scaledLogoutIcon));
        
        
        homepage.setOpaque(false);
        homepage.setContentAreaFilled(false);
        homepage.setBorderPainted(false);
        ImageIcon homepageIcon = new ImageIcon(getClass().getResource("/Image/Homepage.png"));
        Image scaledhomeIcon = homepageIcon.getImage().getScaledInstance(110,40, Image.SCALE_SMOOTH);
        homepage.setIcon(new ImageIcon(scaledhomeIcon));

        rentButton.setOpaque(false);
        rentButton.setContentAreaFilled(false);
        rentButton.setBorderPainted(false);
        rentButton.setForeground(Color.WHITE);

        ImageIcon rentIcon = new ImageIcon(getClass().getResource("/Image/Rent.png"));
        Image scaledRentIcon = rentIcon.getImage().getScaledInstance(168, 70, Image.SCALE_SMOOTH);
        rentButton.setIcon(new ImageIcon(scaledRentIcon));

        IDCard = new JTextField();

        setLayout(null);

        int componentWidth = 230;
        int componentHeight = 27;

        carIdField.setBounds(75, 85, componentWidth, componentHeight);
        regNoField.setBounds(350, 85, componentWidth, componentHeight);
        carNameField.setBounds(73, 160, componentWidth, componentHeight);
        price.setBounds(350, 160, componentWidth, componentHeight);
        pickupDateField.setBounds(73, 248, componentWidth, componentHeight);
        returnDateField.setBounds(354, 248, componentWidth, componentHeight);
        phoneNo.setBounds(353, 555, componentWidth, componentHeight);
        Surname.setBounds(353, 465, componentWidth, componentHeight);
        CustomerID.setBounds(77, 384, componentWidth, componentHeight);
        customerNameField.setBounds(77, 465, componentWidth, componentHeight);

        rentButton.setBounds(220, 600, 160, 59);
        logoutButton.setBounds(1050, 12, 130, 59);
        homepage.setBounds(1163,14,100,30);

        IDCard.setBounds(77, 555, 150, 30);

        add(carIdField);
        add(regNoField);
        add(carNameField);
        add(price);
        add(pickupDateField);
        add(returnDateField);
        add(phoneNo);
        add(Surname);
        add(CustomerID);
        add(customerNameField);

        add(rentButton);
        add(logoutButton);
        add(homepage);
        add(IDCard);

        rentButton.addActionListener(this);
        logoutButton.addActionListener(this);
        homepage.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rentButton) {
            // Handle rent button click
            // Perform logic to rent a car
            
            JOptionPane.showMessageDialog(this, "Car Rented Successfully");
        } else if (e.getSource() == logoutButton) {
            new Login();
        }
        else if (e.getSource() == homepage) {
            new HomePage();
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
