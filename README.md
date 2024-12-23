Hotel Reservation System Documentation
Overview
The Hotel Reservation System is a GUI-based application designed to simulate the process of reserving rooms at a hotel. The system utilizes several design patterns to enhance flexibility, maintainability, and scalability. The design patterns included are Singleton, Factory, Strategy, State, and Template Method.

Design Patterns
1. Singleton Pattern
The Singleton Pattern ensures that there is only one instance of the ReservationManager and PaymentProcessor throughout the application. These instances manage the core functionalities related to reservations and payments.

ReservationManager: Manages the state of the current reservation and ensures that only one instance of the manager exists.
PaymentProcessor: Manages the payment process and ensures that only one instance handles all payment processing.
2. Factory Pattern
The Factory Pattern is used to create objects of Room and Customer based on the type provided by the user. This allows flexibility in adding more room types or customer profiles without modifying the core logic of the system.

RoomFactory: Creates instances of different room types (StandardRoom, DeluxeRoom, Suite) based on user selection.
CustomerFactory: Creates instances of different customer profiles (RegularCustomer, VIPCustomer, CorporateCustomer) based on user selection.
3. Strategy Pattern
The Strategy Pattern defines different payment strategies that can be selected dynamically. The user can choose to pay with different methods (e.g., Credit Card or PayPal) without changing the core logic of the system.

PaymentStrategy: Interface for different payment strategies.
CreditCardPayment and PayPalPayment: Concrete strategies for processing payments through credit cards or PayPal.
4. State Pattern
The State Pattern is used to manage the various states of a reservation (e.g., Reserved, Checked-In, Checked-Out). This allows the system to handle state transitions such as checking in and checking out.

ReservationState: Manages the state of a reservation and allows transitions between different states (e.g., from Reserved to Checked-In).
5. Template Method Pattern
The Template Method Pattern defines the skeleton of the payment processing algorithm. Concrete subclasses (e.g., CreditCardPaymentProcessor, PayPalPaymentProcessor) implement specific steps of the algorithm.

PaymentProcessorTemplate: Abstract class that defines the structure for processing payments.
CreditCardPaymentProcessor and PayPalPaymentProcessor: Concrete implementations that fill in the details of the payment process for specific payment methods.
Core Classes
1. ReservationManager
Purpose: Manages the state of the reservation and ensures that only one instance exists.
Methods:
setState(String state): Sets the current reservation state.
getState(): Returns the current reservation state.
makeReservation(String roomType, String customerType): Logs a reservation with the room type and customer type.
2. PaymentProcessor
Purpose: Manages the payment process using the Template Method Pattern.
Methods:
processPayment(double amount): Calls the different stages of the payment process.
collectPaymentDetails(): Collects payment details (abstracted for subclasses).
validatePaymentDetails(): Validates the payment details.
chargePayment(double amount): Charges the payment.
sendConfirmation(): Sends a confirmation of payment.
3. Room and Customer
Purpose: Represents room and customer objects, with specific types like StandardRoom, DeluxeRoom, and Suite for rooms, and RegularCustomer, VIPCustomer, and CorporateCustomer for customers.
Methods:
getType(): Returns the type of room or customer.
4. PaymentStrategy
Purpose: Interface for defining different payment methods.
Methods:
pay(double amount): Executes the payment process for a given amount.
5. ReservationState
Purpose: Tracks the current state of a reservation.
Methods:
setState(String state): Sets the reservation state.
getState(): Returns the current state.
checkIn(): Transitions from Reserved to Checked-In.
checkOut(): Transitions from Checked-In to Checked-Out.
6. PaymentProcessorTemplate
Purpose: Abstract class defining the template for processing payments.
Methods:
processTransaction(double amount): Defines the skeleton of the payment process.
collectDetails(): Placeholder for collecting payment details (to be implemented in subclasses).
validateDetails(): Placeholder for validating payment details (to be implemented in subclasses).
completeTransaction(double amount): Placeholder for completing the transaction (to be implemented in subclasses).
7. Concrete Payment Processors
CreditCardPaymentProcessor and PayPalPaymentProcessor: Provide specific implementations for collecting details, validating details, and completing transactions for Credit Card and PayPal payments, respectively.
GUI
The GUI is built using Swing and allows the user to:

Select a room type (Standard, Deluxe, Suite).
Enter their name.
Select a customer type (Regular, VIP, Corporate).
Reserve a room by clicking the Reserve Room button.
The GUI also displays the reservation details and the processed payment. The payment is handled through the selected payment strategy (Credit Card or PayPal).

Flow of the System
User Interaction:

The user selects a room type and customer type, enters their name, and clicks the Reserve Room button.
The system creates the appropriate Room and Customer objects using the Factory Pattern.
The ReservationManager singleton instance is used to log the reservation.
Payment Processing:

Based on the selected room type, the system calculates the room price.
The payment is processed using the Strategy Pattern (either Credit Card or PayPal).
The payment details are collected, validated, and the payment is completed using the Template Method Pattern.
Reservation State Management:

The reservation state can be transitioned using the State Pattern. For example, a reservation can be checked in or checked out, updating its state from Reserved to Checked-In or from Checked-In to Checked-Out.
Example Usage
Reserving a Room
Select a Room Type (e.g., "Standard").
Enter Customer Name (e.g., "John Doe").
Select Customer Type (e.g., "VIP").
Click Reserve Room.
The system reserves the room and processes the payment (e.g., Credit Card or PayPal).
The reservation and payment details are displayed in the output area.
Conclusion
This Hotel Reservation System showcases the power of several design patterns such as Singleton, Factory, Strategy, State, and Template Method. These patterns make the system more flexible, easier to extend, and maintain. The GUI allows users to interact with the system, manage reservations, and process payments efficiently.
