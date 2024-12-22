
package com.example.hotelreservation.payment;

public class PaymentProcessorFactory {
    public static PaymentProcessor getPaymentProcessor(String type) {
        return switch (type.toLowerCase()) {
            case "creditcard" -> new CreditCardPayment();
            case "paypal" -> new PayPalPayment();
            default -> throw new IllegalArgumentException("Unsupported payment type: " + type);
        };
    }
}
