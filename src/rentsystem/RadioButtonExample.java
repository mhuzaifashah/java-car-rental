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

public class RadioButtonExample {
    public RadioButtonExample() {
        JFrame frame = new JFrame("Gear Type");
        JPanel panel = new JPanel();
        JRadioButton automaticButton = new JRadioButton("Automatic");
        JRadioButton manualButton = new JRadioButton("Manual");

        ButtonGroup group = new ButtonGroup();
        group.add(automaticButton);
        group.add(manualButton);

        panel.add(automaticButton);
        panel.add(manualButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);
        
        frame.setSize(300, 200);
        
        frame.setVisible(true);
    }
}

