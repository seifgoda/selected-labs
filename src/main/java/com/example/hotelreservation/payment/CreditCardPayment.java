
package com.example.hotelreservation.payment;

public class CreditCardPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Logic for processing credit card payments
        System.out.println("Processing credit card payment of $" + amount);
        // Simulate success
        return true;
    }
}
