# selected-labs
Hotel Reservation System Documentation

Overview

This project implements a simple Hotel Reservation System using Java, following a modular and extensible architecture. Key functionalities include room booking, customer profile management, and payment processing.

Features

Room Booking:

Book rooms for customers based on their profile type.

Handles payment processing seamlessly.

Payment Processing:

Supports multiple payment methods (e.g., Credit Card, PayPal).

Uses a factory pattern for dynamic payment processor selection.

Customer Profile Management:

Different customer profiles are supported:

Regular Customer

VIP Customer

Corporate Customer

Customer profiles are created using the factory pattern.

File Structure

Java Files

HotelReservationSystemWeb.java: Entry point for the application.

Room.java: Represents room details.

RoomRepository.java: Manages room data.

RoomController.java: Controls room booking logic.

Payment Processing

PaymentProcessor: Interface for payment processing.

CreditCardPayment: Implementation for credit card payments.

PayPalPayment: Implementation for PayPal payments.

PaymentProcessorFactory: Factory to create payment processors dynamically.

Customer Profiles

CustomerProfile: Interface for customer profiles.

RegularCustomer: Represents a regular customer.

VIPCustomer: Represents a VIP customer.

CorporateCustomer: Represents a corporate customer.

CustomerProfileFactory: Factory to create customer profiles dynamically.

Resources

application.properties: Configuration file for the application.

index.html: Front-end template.

How to Use

1. Booking a Room

Create a customer profile using CustomerProfileFactory.

Select a payment method using PaymentProcessorFactory.

Call bookRoom in RoomController to complete the booking.

Example:

RoomController controller = new RoomController();
controller.bookRoom("creditcard", "vip", 200.00);

2. Extending Payment Methods

To add a new payment method:

Create a new class implementing PaymentProcessor.

Add a case in PaymentProcessorFactory to handle the new type.

Example:

public class MobileWalletPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Mobile Wallet payment of $" + amount);
        return true;
    }
}

3. Adding New Customer Profiles

To add a new customer profile:

Create a new class implementing CustomerProfile.

Add a case in CustomerProfileFactory to handle the new type.

Example:

public class PremiumCustomer implements CustomerProfile {
    @Override
    public String getProfileType() {
        return "Premium Customer";
    }
}

Dependencies

Java 8 or higher

Spring Boot (if using the back-end logic)

Future Enhancements

Add additional payment gateways (e.g., Stripe, Google Pay).

Integrate a database for persistent room and customer data.

Develop a user-friendly front-end interface.

Implement email notifications for booking confirmations.

