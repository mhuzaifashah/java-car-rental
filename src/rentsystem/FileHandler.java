/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentsystem;

/**
 *
 * @author lenovo
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private static final String FILE_PATH = "car_details.txt";

    public static void writeCarToFile(String carDetails) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(carDetails);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readCarsFromFile() {
        StringBuilder carDetails = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                carDetails.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return carDetails.toString();
    }
}
