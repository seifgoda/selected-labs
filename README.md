Hotel Reservation System Documentation
Project Overview
The Hotel Reservation System is a desktop application designed for booking hotel rooms, managing customer profiles, and handling reservations. The project incorporates five design patterns: Singleton, Factory, Decorator, Observer, and Command. It also includes a graphical user interface (GUI) implemented using Java Swing.

Design Patterns Used
1. Singleton Pattern
Purpose: Ensures a class has only one instance and provides a global point of access to it.
Implementation:
ReservationManager: Manages the list of reservations and ensures only one instance exists across the application.
PaymentProcessor: Processes customer payments as a single shared instance.
Reason: Centralizes reservation management and payment processing, ensuring consistency and reducing resource usage.
2. Factory Pattern
Purpose: Creates objects without specifying their concrete classes.
Implementation:
RoomFactory: Creates room objects (e.g., StandardRoom, DeluxeRoom, SuiteRoom) based on user input.
CustomerFactory: Generates customer profiles (e.g., Regular, VIP) dynamically.
Reason: Simplifies object creation and enforces a modular and extendable design.
3. Decorator Pattern
Purpose: Dynamically adds behavior or responsibilities to an object.
Implementation:
RoomDecorator: Adds additional features to room reservations.
Examples: BreakfastDecorator, LateCheckoutDecorator.
Reason: Allows flexible extension of room features without modifying existing classes.
4. Observer Pattern
Purpose: Establishes a one-to-many dependency between objects, ensuring that when one object changes, its dependents are notified.
Implementation:
ReservationObserver: Observes changes in the reservation list.
ReservationManager notifies all observers when a new reservation is added.
Reason: Ensures seamless updates to dependent components when reservations are modified.
5. Command Pattern
Purpose: Encapsulates a request as an object, allowing parameterization of clients with different requests and delayed execution.
Implementation:
AddReservationCommand: Encapsulates the action of adding a reservation.
Reason: Decouples the request from its execution, allowing flexibility in how and when actions are performed.
Graphical User Interface (GUI)
The GUI is implemented using Java Swing and provides an interactive way for users to make reservations.

Features:
Room Selection:
Dropdown menu for choosing room types: Standard, Deluxe, or Suite.
Customer Details:
Text field for entering the customer’s name.
Dropdown menu for selecting customer type (Regular or VIP).
Reservation Button:
Triggers reservation creation and displays confirmation.
Output Display:
Text area to list reserved rooms and customer details.
How to Use:
Launch the application.
Select a room type.
Enter the customer name and type.
Click "Reserve Room" to complete the booking.
View reservation details in the output area.
Code Structure
Classes
ReservationManager:

Implements the Singleton pattern.
Manages reservations and notifies observers.
PaymentProcessor:

Implements the Singleton pattern.
Handles payment processing.
Room and Subclasses:

Abstract Room class with concrete implementations (StandardRoom, DeluxeRoom, SuiteRoom).
Created using the Factory pattern.
Customer and Factory:

Represents customer profiles.
Created using the Factory pattern.
RoomDecorator:

Base class for adding extra features to rooms.
Examples: BreakfastDecorator, LateCheckoutDecorator.
AddReservationCommand:

Implements the Command pattern for adding reservations.
ReservationObserver:

Interface for observing reservation changes.
GUI Implementation:

Encapsulated in the HotelReservationSystem class.
Example Scenarios
Adding a Reservation:

A user selects "Deluxe Room", enters "John Doe" as the customer, and chooses "VIP".
A new reservation is created and displayed in the output area.
Decorating a Room:

A Deluxe Room is decorated with "Breakfast" and "Late Checkout" options.
Total price is updated dynamically.
Notification to Observers:

Observers are notified whenever a new reservation is added.
Conclusion
This Hotel Reservation System demonstrates a modular and extensible architecture leveraging design patterns. The GUI enhances user interaction, while the patterns ensure a robust and scalable solution.
