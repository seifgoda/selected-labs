
package com.example.hotelreservation.payment;

public class PayPalPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Logic for processing PayPal payments
        System.out.println("Processing PayPal payment of $" + amount);
        // Simulate success
        return true;
    }
}
