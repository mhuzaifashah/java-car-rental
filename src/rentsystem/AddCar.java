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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddCar extends JFrame implements ActionListener {
    JTextField carIdField;
    JTextField regNoField;
    JTextField brandField;
    JTextField nameField;
    JTextField modelField;
    JTextField fuelTypeField;
    JTextField priceField;
    JRadioButton economicRadioButton;
    JRadioButton sportRadioButton;
    JRadioButton luxuryRadioButton;
    private JButton addCarButton;
    private JButton editCarButton;
    private JButton deleteCarButton;
    private JButton logoutButton;
     private JButton homepage;
    
     static {
        Font font = new Font("Verdana", Font.PLAIN, 15);
        UIManager.put("TextField.font", font);
        
        }

    public AddCar() {
        setTitle("Add Car Page");
        setSize(3840, 2160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        

        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/AddCar.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        carIdField = new JTextField();
        regNoField = new JTextField();
        brandField = new JTextField();
        nameField = new JTextField();
        modelField = new JTextField();
        fuelTypeField = new JTextField();
        priceField = new JTextField();
         
        economicRadioButton = new JRadioButton("Economic");
        sportRadioButton = new JRadioButton("Sport");
        luxuryRadioButton = new JRadioButton("Luxury");
        ButtonGroup carTypeGroup = new ButtonGroup();
        carTypeGroup.add(economicRadioButton);
        carTypeGroup.add(sportRadioButton);
        carTypeGroup.add(luxuryRadioButton);
        
          homepage = new JButton();
        addCarButton = new JButton("Add Car");
        editCarButton = new JButton("Edit Car");
        deleteCarButton = new JButton("Delete Car");
         logoutButton = new JButton();
          logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setBorderPainted(false);
        ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Image/logout.png"));
        Image scaledLogoutIcon = logoutIcon.getImage().getScaledInstance(158, 100, Image.SCALE_SMOOTH);
        logoutButton.setIcon(new ImageIcon(scaledLogoutIcon));
       
         economicRadioButton.setOpaque(false);
        sportRadioButton.setOpaque(false);
        luxuryRadioButton.setOpaque(false);

        // Set text color to white for RadioButtons
        
        
        economicRadioButton.setForeground(Color.WHITE);
        sportRadioButton.setForeground(Color.WHITE);
        luxuryRadioButton.setForeground(Color.WHITE);

        // Set content area filled to false for Add, Edit, Delete buttons
        addCarButton.setContentAreaFilled(false);
        editCarButton.setContentAreaFilled(false);
        deleteCarButton.setContentAreaFilled(false);

        // Remove borders from Add, Edit, Delete buttons
        addCarButton.setBorderPainted(false);
        editCarButton.setBorderPainted(false);
        deleteCarButton.setBorderPainted(false);
        
        homepage.setOpaque(false);
        homepage.setContentAreaFilled(false);
        homepage.setBorderPainted(false);
        ImageIcon homepageIcon = new ImageIcon(getClass().getResource("/Image/Homepage.png"));
        Image scaledhomeIcon = homepageIcon.getImage().getScaledInstance(110,40, Image.SCALE_SMOOTH);
        homepage.setIcon(new ImageIcon(scaledhomeIcon));

        
       // Set icons for Add, Edit, Delete buttons
        ImageIcon addIcon = new ImageIcon(getClass().getResource("/Image/Caradd.png"));
        Image scaledAddIcon = addIcon.getImage().getScaledInstance(168, 80, Image.SCALE_SMOOTH);
        addCarButton.setIcon(new ImageIcon(scaledAddIcon));

        ImageIcon editIcon = new ImageIcon(getClass().getResource("/Image/Editcar.png"));
        Image scaledEditIcon = editIcon.getImage().getScaledInstance(168, 80, Image.SCALE_SMOOTH);
        editCarButton.setIcon(new ImageIcon(scaledEditIcon));

        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Image/Deletecar.png"));
        Image scaledDeleteIcon = deleteIcon.getImage().getScaledInstance(168, 80, Image.SCALE_SMOOTH);
        deleteCarButton.setIcon(new ImageIcon(scaledDeleteIcon));

        setLayout(null);

        int componentWidth = 230;
        int componentHeight = 27;

        carIdField.setBounds(680, 100, componentWidth, componentHeight);
        regNoField.setBounds(990, 100, componentWidth, componentHeight);
        brandField.setBounds(680, 190, componentWidth, componentHeight);
        nameField.setBounds(990, 190, componentWidth, componentHeight);
        modelField.setBounds(680, 283, componentWidth, componentHeight);
        fuelTypeField.setBounds(990, 283, componentWidth, componentHeight);
        priceField.setBounds(990, 475, componentWidth, componentHeight);

        

        economicRadioButton.setBounds(990, 380, 100, componentHeight);
        sportRadioButton.setBounds(1085, 380, 80, componentHeight);
        luxuryRadioButton.setBounds(1155, 380, 80, componentHeight);

        addCarButton.setBounds(720, 545, 150, 59);
        editCarButton.setBounds(889, 539, 150, 59);
        deleteCarButton.setBounds(1040, 532, 150, 75);
        logoutButton.setBounds(3, 12, 130, 59);
        homepage.setBounds(114,16,100,30);

        add(carIdField);
        add(regNoField);
        add(brandField);
        add(nameField);
        add(modelField);
        add(fuelTypeField);
        add(priceField);

        add(economicRadioButton);
        add(sportRadioButton);
        add(luxuryRadioButton);

        add(addCarButton);
        add(editCarButton);
        add(deleteCarButton);
        add(logoutButton);
        add(homepage);

        addCarButton.addActionListener(this);
        editCarButton.addActionListener(this);
        deleteCarButton.addActionListener(this);
        logoutButton.addActionListener(this);
        homepage.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == addCarButton) {
        // Handle add car button click
        // Perform logic to add a new car
        
        String carDetails = "Car ID: " + carIdField.getText() +
                            "\tReg No: " + regNoField.getText() +
                            "\tBrand: " + brandField.getText() +
                            "\tName: " + nameField.getText() +
                            "\tModel: " + modelField.getText() +
                            "\tFuel Type: " + fuelTypeField.getText() +
                            "\tPrice: " + priceField.getText() +
                            "\tCar Type: " + (economicRadioButton.isSelected() ? "Economic" :
                                              sportRadioButton.isSelected() ? "Sport" : "Luxury");

        FileHandler.writeCarToFile(carDetails);

        JOptionPane.showMessageDialog(this, "Car Added Successfully");
    } else if (e.getSource() == editCarButton) {
        // Handle edit car button click
        // Perform logic to edit a car
        String editedCarDetails = "Car ID: " + carIdField.getText() +
                                  "\tReg No: " + regNoField.getText() +
                                  "\tBrand: " + brandField.getText() +
                                  "\tName: " + nameField.getText() +
                                  "\tModel: " + modelField.getText() +
                                  "\tFuel Type: " + fuelTypeField.getText() +
                                  "\tPrice: " + priceField.getText() +
                                  "\tCar Type: " + (economicRadioButton.isSelected() ? "Economic" :
                                                    sportRadioButton.isSelected() ? "Sport" : "Luxury");

        // Read existing car details from the file
        String existingCarDetails = FileHandler.readCarsFromFile();

        // Replace the old car details with the edited details
        String updatedCarDetails = existingCarDetails.replaceFirst("Car ID: " + carIdField.getText(), editedCarDetails);

        // Write the updated car details back to the file
        FileHandler.writeCarToFile(updatedCarDetails);

        JOptionPane.showMessageDialog(this, "Car Edited Successfully");
    } else if (e.getSource() == deleteCarButton) {
        // Handle delete car button click
        // Perform logic to delete a car

        // Read existing car details from the file
        String existingCarDetails = FileHandler.readCarsFromFile();

        // Remove the details of the car to be deleted
        String carToDelete = "Car ID: " + carIdField.getText();
        String updatedCarDetails = existingCarDetails.replace(carToDelete, "");

        // Write the updated car details back to the file
        FileHandler.writeCarToFile(updatedCarDetails);

        JOptionPane.showMessageDialog(this, "Car Deleted");
    } else if (e.getSource() == logoutButton) {
        new Login();
    } else if (e.getSource() == homepage) {
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
