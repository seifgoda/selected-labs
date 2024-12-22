
package com.example.hotelreservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelReservationSystemWeb {
    public static void main(String[] args) {
        SpringApplication.run(HotelReservationSystemWeb.class, args);
    }
}

// Singleton Pattern for Reservation Manager
class ReservationManager {
    private static ReservationManager instance;
    private List<String> reservations;

    private ReservationManager() {
        reservations = new ArrayList<>();
    }

    public static synchronized ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

    public void addReservation(String reservation) {
        reservations.add(reservation);
    }

    public List<String> getReservations() {
        return reservations;
    }
}

// Singleton Pattern for Payment Processor
class PaymentProcessor {
    private static PaymentProcessor instance;

    private PaymentProcessor() {}

    public static synchronized PaymentProcessor getInstance() {
        if (instance == null) {
            instance = new PaymentProcessor();
        }
        return instance;
    }

    public void processPayment(String details) {
        // Payment processing logic here
        System.out.println("Payment processed: " + details);
    }
}

// Entity for Room
@Entity
class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int roomNumber;
    private String roomType;
    private boolean available;

    public Room() {}

    public Room(int roomNumber, String roomType, boolean available) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// Factory Pattern for Room Types
class RoomFactory {
    public static Room createRoom(int roomNumber, String roomType) {
        return new Room(roomNumber, roomType, true);
    }
}

// Repository for Room
interface RoomRepository extends JpaRepository<Room, Long> {}

// Controller
@Controller
class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Room> rooms = roomRepository.findAll();
        model.addAttribute("rooms", rooms);
        return "index";
    }

    @PostMapping("/addRoom")
    public String addRoom(@RequestParam int roomNumber, @RequestParam String roomType) {
        Room room = RoomFactory.createRoom(roomNumber, roomType);
        roomRepository.save(room);
        return "redirect:/";
    }

    @PostMapping("/bookRoom")
    public String bookRoom(@RequestParam Long roomId) {
        Room room = roomRepository.findById(roomId).orElse(null);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            roomRepository.save(room);
            ReservationManager.getInstance().addReservation("Room " + room.getRoomNumber() + " booked.");
        }
        return "redirect:/";
    }
}
