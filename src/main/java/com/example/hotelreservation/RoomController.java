
package com.example.hotelreservation;

import com.example.hotelreservation.payment.PaymentProcessor;
import com.example.hotelreservation.payment.PaymentProcessorFactory;
import com.example.hotelreservation.customer.CustomerProfile;
import com.example.hotelreservation.customer.CustomerProfileFactory;

public class RoomController {
    public void bookRoom(String paymentType, String customerType, double amount) {
        // Create a customer profile
        CustomerProfile customer = CustomerProfileFactory.createCustomerProfile(customerType);
        System.out.println("Booking room for " + customer.getProfileType());

        // Process payment
        PaymentProcessor paymentProcessor = PaymentProcessorFactory.getPaymentProcessor(paymentType);
        if (paymentProcessor.processPayment(amount)) {
            System.out.println("Payment successful! Room booked.");
        } else {
            System.out.println("Payment failed. Please try again.");
        }
    }
}
