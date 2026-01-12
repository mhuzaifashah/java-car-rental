/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentsystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */



public class CarFileHandler implements ActionListener {
    private AddCar addCarInstance;

    public CarFileHandler(AddCar addCarInstance) {
        this.addCarInstance = addCarInstance;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btntxt = e.getActionCommand();
        if (btntxt.equals("Add Car")) {
            addCarRecord();
        } else if (btntxt.equals("Edit Car")) {
            // Implement logic to edit car record
            JOptionPane.showMessageDialog(addCarInstance, "Edit Car functionality not implemented yet.");
        } else if (btntxt.equals("Delete Car")) {
            deleteCarRecord();
        } else if (btntxt.equals("Logout")) {
            // Handle logout
            addCarInstance.dispose(); // Close the AddCar window
            new Login(); // Open the login window
        }
    }

    private void addCarRecord() {
        try {
            FileWriter f = new FileWriter("CarRecords.txt", true);
            f.write(getCarRecordData());
            f.close();
            clearFields();
            JOptionPane.showMessageDialog(addCarInstance, "Car Added Successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(addCarInstance, "Error adding car record", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getCarRecordData() {
        // Create a formatted string with car record data
        return String.format("Car ID: %s\tReg No: %s\tBrand: %s\tName: %s\tModel: %s\tFuel Type: %s\tPrice: %s\n",
                addCarInstance.carIdField.getText(),
                addCarInstance.regNoField.getText(),
                addCarInstance.brandField.getText(),
                addCarInstance.nameField.getText(),
                addCarInstance.modelField.getText(),
                addCarInstance.fuelTypeField.getText(),
                addCarInstance.priceField.getText());
    }

    private void clearFields() {
        addCarInstance.carIdField.setText("");
        addCarInstance.regNoField.setText("");
        addCarInstance.brandField.setText("");
        addCarInstance.nameField.setText("");
        addCarInstance.modelField.setText("");
        addCarInstance.fuelTypeField.setText("");
        addCarInstance.priceField.setText("");
        addCarInstance.economicRadioButton.setSelected(false);
        addCarInstance.sportRadioButton.setSelected(false);
        addCarInstance.luxuryRadioButton.setSelected(false);
    }

    private void deleteCarRecord() {
        try {
            File inputFile = new File("CarRecords.txt");
            File tempFile = new File("tempCarRecords.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = getCarRecordData();
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.contains(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }

            writer.close();
            reader.close();

            tempFile.renameTo(inputFile);

            JOptionPane.showMessageDialog(addCarInstance, "Car Deleted Successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(addCarInstance, "Error deleting car record", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

