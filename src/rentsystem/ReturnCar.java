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

public class ReturnCar extends JFrame implements ActionListener {
    private JTextField carNameField;
    private JTextField brandField;
    private JTextField pickupDateField;
    private JTextField returnDateField;
    private JTextField priceField;
    private JTextField chargesField;
    private JTextField phoneField;
    private JTextField customerNameField;
    private JTextField surnameField;
    private JTextField idCardNoField;
    private JButton updateButton;
    private JButton logoutButton;
    private JTextField searchField;
     private JButton homepage;

    static {
        Font font = new Font("Verdana", Font.PLAIN, 15);
        UIManager.put("TextField.font", font);
    }

    public ReturnCar() {
        setTitle("Return Car Page");
        setSize(3840, 2160);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        try {
            BufferedImage backgroundImage = ImageIO.read(getClass().getResource("/Image/ReturnCar.png"));
            setContentPane(new ImagePanel(backgroundImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        carNameField = new JTextField();
        brandField = new JTextField();
        pickupDateField = new JTextField();
        returnDateField = new JTextField();
        priceField = new JTextField();
        chargesField = new JTextField();
        phoneField = new JTextField();
        customerNameField = new JTextField();
        surnameField = new JTextField();
        idCardNoField = new JTextField();
        homepage = new JButton();
        updateButton = new JButton("Update");
        logoutButton = new JButton();
        logoutButton.setOpaque(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setBorderPainted(false);
        ImageIcon logoutIcon = new ImageIcon(getClass().getResource("/Image/logout.png"));
        Image scaledLogoutIcon = logoutIcon.getImage().getScaledInstance(158, 100, Image.SCALE_SMOOTH);
        logoutButton.setIcon(new ImageIcon(scaledLogoutIcon));

        updateButton.setOpaque(false);
        updateButton.setContentAreaFilled(false);
        updateButton.setBorderPainted(false);
        updateButton.setForeground(Color.WHITE);

        ImageIcon updateIcon = new ImageIcon(getClass().getResource("/Image/Update.png"));
        Image scaledUpdateIcon = updateIcon.getImage().getScaledInstance(168, 70, Image.SCALE_SMOOTH);
        updateButton.setIcon(new ImageIcon(scaledUpdateIcon));
        
        
        homepage.setOpaque(false);
        homepage.setContentAreaFilled(false);
        homepage.setBorderPainted(false);
        ImageIcon homepageIcon = new ImageIcon(getClass().getResource("/Image/Homepage.png"));
        Image scaledhomeIcon = homepageIcon.getImage().getScaledInstance(110,40, Image.SCALE_SMOOTH);
        homepage.setIcon(new ImageIcon(scaledhomeIcon));

        searchField = new JTextField();

        setLayout(null);

        int componentWidth = 230;
        int componentHeight = 27;

        carNameField.setBounds(720, 135, componentWidth, componentHeight);
        brandField.setBounds(1023, 135, componentWidth, componentHeight);
        pickupDateField.setBounds(720, 217, componentWidth, componentHeight);
        returnDateField.setBounds(1023, 217, componentWidth, componentHeight);
        priceField.setBounds(720, 307, componentWidth, componentHeight);
        chargesField.setBounds(1023, 307, componentWidth, componentHeight);
        phoneField.setBounds(1023, 490, componentWidth, componentHeight);
        customerNameField.setBounds(720, 397, componentWidth, componentHeight);
        surnameField.setBounds(1023, 397, componentWidth, componentHeight);
        idCardNoField.setBounds(720, 490, componentWidth, componentHeight);

        updateButton.setBounds(911, 560, 160, 59);
        logoutButton.setBounds(3, 12, 130, 59);
          homepage.setBounds(114,16,100,30);

        searchField.setBounds(1050, 32, 150, 30);

        add(carNameField);
        add(brandField);
        add(pickupDateField);
        add(returnDateField);
        add(priceField);
        add(chargesField);
        add(phoneField);
        add(customerNameField);
        add(surnameField);
        add(idCardNoField);

        add(updateButton);
        add(logoutButton);
        add(searchField);
        add(homepage);

        updateButton.addActionListener(this);
        logoutButton.addActionListener(this);
         homepage.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            // Handle update button click
            // Perform logic to update car information
            JOptionPane.showMessageDialog(this, "Car Information Updated Successfully");
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


