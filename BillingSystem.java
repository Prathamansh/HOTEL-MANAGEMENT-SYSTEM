package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BillingSystem extends JFrame {

    private static BillingSystem instance;

    private Connection connection;
    private PreparedStatement statement;

    private BillingSystem() {}

    public static BillingSystem getInstance() {
        if (instance == null) {
            instance = new BillingSystem();
        }
        return instance;
    }

    public void displayBillingSystemInterface() {
        try {
            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0, 0, 1000, 800);
            panel.setBackground(new Color(3, 45, 48));
            add(panel);

            JLabel label = new JLabel("Billing System Interface");
            label.setBounds(250, 20, 300, 30);
            label.setFont(new Font("Tahoma", Font.PLAIN, 20));
            label.setForeground(Color.WHITE);
            panel.add(label);

            JLabel customerInfoLabel = new JLabel("Customer Information:");
            customerInfoLabel.setBounds(50, 70, 150, 20);
            customerInfoLabel.setForeground(Color.WHITE);
            panel.add(customerInfoLabel);

            JTextArea customerInfoTextArea = new JTextArea();
            customerInfoTextArea.setBounds(50, 100, 300, 100);
            customerInfoTextArea.setEditable(false);
            panel.add(customerInfoTextArea);

            JLabel roomInfoLabel = new JLabel("Room Information:");
            roomInfoLabel.setBounds(50, 220, 150, 20);
            roomInfoLabel.setForeground(Color.WHITE);
            panel.add(roomInfoLabel);

            JTextArea roomInfoTextArea = new JTextArea();
            roomInfoTextArea.setBounds(50, 250, 300, 100);
            roomInfoTextArea.setEditable(false);
            panel.add(roomInfoTextArea);

            JLabel additionalChargesLabel = new JLabel("Additional Charges:");
            additionalChargesLabel.setBounds(50, 370, 150, 20);
            additionalChargesLabel.setForeground(Color.WHITE);
            panel.add(additionalChargesLabel);

            JTextField additionalChargesField = new JTextField();
            additionalChargesField.setBounds(50, 400, 150, 25);
            panel.add(additionalChargesField);

            JLabel totalAmountLabel = new JLabel("Total Amount:");
            totalAmountLabel.setBounds(50, 440, 150, 20);
            totalAmountLabel.setForeground(Color.WHITE);
            panel.add(totalAmountLabel);

            JButton calculateTotalButton = new JButton("Calculate Total");
            calculateTotalButton.setBounds(220, 400, 130, 25);
            panel.add(calculateTotalButton);
            calculateTotalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        double additionalCharges = Double.parseDouble(additionalChargesField.getText());
                        double totalAmount = additionalCharges;
                        totalAmountLabel.setText("Total Amount: $" + totalAmount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number for additional charges.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            JButton backButton = new JButton("Back");
            backButton.setBounds(50, 560, 100, 30);
            backButton.setBackground(Color.BLACK);
            backButton.setForeground(Color.WHITE);
            panel.add(backButton);
            backButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                }
            });

            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            setSize(750, 640);
            setVisible(true);

            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelMS", "root", "shreyan723");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BillingSystem.getInstance().displayBillingSystemInterface();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

