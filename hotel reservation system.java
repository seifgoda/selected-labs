package hotel.reservation.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Singleton Pattern for Reservation Manager
class ReservationManager {
    private static ReservationManager instance;
    private String currentState;

    private ReservationManager() {
        currentState = "Reserved"; // Default state
    }

    public static ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    // Set the reservation state
    public void setState(String state) {
        this.currentState = state;
    }

    public String getState() {
        return currentState;
    }

    public void makeReservation(String roomType, String customerType) {
        System.out.println("Reservation made: " + roomType + " for " + customerType + " customer.");
    }
}

// Singleton Pattern for Payment Processor
class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {}

    public static PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    // Template Method Pattern: Define skeleton of payment process
    public void processPayment(double amount) {
        collectPaymentDetails();
        validatePaymentDetails();
        chargePayment(amount);
        sendConfirmation();
    }

    protected void collectPaymentDetails() {
        System.out.println("Collecting payment details...");
    }

    protected void validatePaymentDetails() {
        System.out.println("Validating payment details...");
    }

    protected void chargePayment(double amount) {
        System.out.println("Charging $" + amount + "...");
    }

    protected void sendConfirmation() {
        System.out.println("Sending payment confirmation...");
    }
}

// Factory Pattern for Room Types
interface Room {
    String getType();
}

class StandardRoom implements Room {
    @Override
    public String getType() {
        return "Standard Room";
    }
}

class DeluxeRoom implements Room {
    @Override
    public String getType() {
        return "Deluxe Room";
    }
}

class Suite implements Room {
    @Override
    public String getType() {
        return "Suite";
    }
}

class RoomFactory {
    public static Room createRoom(String type) {
        switch (type.toLowerCase()) {
            case "standard":
                return new StandardRoom();
            case "deluxe":
                return new DeluxeRoom();
            case "suite":
                return new Suite();
            default:
                throw new IllegalArgumentException("Invalid room type: " + type);
        }
    }
}

// Factory Pattern for Customer Profiles
interface Customer {
    String getType();
}

class RegularCustomer implements Customer {
    @Override
    public String getType() {
        return "Regular Customer";
    }
}

class VIPCustomer implements Customer {
    @Override
    public String getType() {
        return "VIP Customer";
    }
}

class CorporateCustomer implements Customer {
    @Override
    public String getType() {
        return "Corporate Customer";
    }
}

class CustomerFactory {
    public static Customer createCustomer(String type) {
        switch (type.toLowerCase()) {
            case "regular":
                return new RegularCustomer();
            case "vip":
                return new VIPCustomer();
            case "corporate":
                return new CorporateCustomer();
            default:
                throw new IllegalArgumentException("Invalid customer type: " + type);
        }
    }
}

// Strategy Pattern: Define different payment strategies
interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing Credit Card Payment of $" + amount);
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal Payment of $" + amount);
    }
}

// State Pattern: Manage reservation state
class ReservationState {
    private String state;

    public ReservationState() {
        this.state = "Reserved";
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }

    public void checkIn() {
        if ("Reserved".equals(state)) {
            setState("Checked-In");
            System.out.println("Reservation state changed to Checked-In.");
        } else {
            System.out.println("Cannot check-in, reservation is in state: " + state);
        }
    }

    public void checkOut() {
        if ("Checked-In".equals(state)) {
            setState("Checked-Out");
            System.out.println("Reservation state changed to Checked-Out.");
        } else {
            System.out.println("Cannot check-out, reservation is in state: " + state);
        }
    }
}

// Template Method Pattern for Payment Process
abstract class PaymentProcessorTemplate {
    public final void processTransaction(double amount) {
        collectDetails();
        validateDetails();
        completeTransaction(amount);
        sendConfirmation();
    }

    protected abstract void collectDetails();
    protected abstract void validateDetails();
    protected abstract void completeTransaction(double amount);

    private void sendConfirmation() {
        System.out.println("Sending confirmation...");
    }
}

// Concrete Template for CreditCard Payment
class CreditCardPaymentProcessor extends PaymentProcessorTemplate {
    @Override
    protected void collectDetails() {
        System.out.println("Collecting credit card details...");
    }

    @Override
    protected void validateDetails() {
        System.out.println("Validating credit card...");
    }

    @Override
    protected void completeTransaction(double amount) {
        System.out.println("Charging $" + amount + " to credit card...");
    }
}

// Concrete Template for PayPal Payment
class PayPalPaymentProcessor extends PaymentProcessorTemplate {
    @Override
    protected void collectDetails() {
        System.out.println("Collecting PayPal details...");
    }

    @Override
    protected void validateDetails() {
        System.out.println("Validating PayPal account...");
    }

    @Override
    protected void completeTransaction(double amount) {
        System.out.println("Charging $" + amount + " via PayPal...");
    }
}

// Main Class with GUI
public class HotelReservationSystem {
    public static void main(String[] args) {
        // Create the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hotel Reservation System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 400);

            JPanel panel = new JPanel(new GridLayout(0, 1));

            // Room Type Selection
            JLabel roomLabel = new JLabel("Select Room Type:");
            JComboBox<String> roomBox = new JComboBox<>(new String[]{"Standard", "Deluxe", "Suite"});

            // Customer Name Input
            JLabel customerLabel = new JLabel("Customer Name:");
            JTextField customerField = new JTextField();

            // Customer Type Selection
            JLabel customerTypeLabel = new JLabel("Customer Type:");
            JComboBox<String> customerTypeBox = new JComboBox<>(new String[]{"Regular", "VIP", "Corporate"});

            // Reserve Button
            JButton reserveButton = new JButton("Reserve Room");

            // Output Display Area
            JTextArea outputArea = new JTextArea(10, 30);
            outputArea.setEditable(false);

            // ReservationManager Singleton Instance
            ReservationManager reservationManager = ReservationManager.getInstance();
            PaymentProcessor paymentProcessor = PaymentProcessor.getInstance();

            // Payment Strategy (Strategy Pattern)
            PaymentStrategy paymentStrategy = new CreditCardPayment();  // or use PayPalPayment()

            // Reserve Button ActionListener
            reserveButton.addActionListener(e -> {
                String roomType = (String) roomBox.getSelectedItem();
                String customerName = customerField.getText();
                String customerType = (String) customerTypeBox.getSelectedItem();

                if (customerName.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a customer name.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Create Room and Customer
                Room room = RoomFactory.createRoom(roomType);
                Customer customer = CustomerFactory.createCustomer(customerType);

                // Make Reservation
                reservationManager.makeReservation(room.getType(), customer.getType());
                outputArea.append("Reserved: " + room.getType() + " for " + customer.getType() + "\n");

                // Process Payment
                double amount = 0;
                switch (roomType.toLowerCase()) {
                    case "standard":
                        amount = 100.0;
                        break;
                    case "deluxe":
                        amount = 200.0;
                        break;
                    case "suite":
                        amount = 300.0;
                        break;
                }

                // Using Strategy Pattern to make payment
                paymentStrategy.pay(amount);

                outputArea.append("Payment of $" + amount + " processed.\n");
            });

            // Adding Components to Panel
            panel.add(roomLabel);
            panel.add(roomBox);
            panel.add(customerLabel);
            panel.add(customerField);
            panel.add(customerTypeLabel);
            panel.add(customerTypeBox);
            panel.add(reserveButton);
            panel.add(new JScrollPane(outputArea));

            // Adding Panel to Frame
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}