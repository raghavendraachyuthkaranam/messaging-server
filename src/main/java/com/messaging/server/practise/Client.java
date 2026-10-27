package com.messaging.server.practise;

import com.messaging.server.model.User;
import java.time.LocalDate;

public class Client {

    public static void main(String[] args) {

        // Create first user
        User user1 = new User(
                1L,
                "raghavendra",
                "Raghavendra",
                LocalDate.of(1994, 5, 11),
                "+919876543210"
        );

        // Print user details
        System.out.println("User ID: " + user1.getId());
        System.out.println("Username: " + user1.getUsername());
        System.out.println("Display Name: " + user1.getDisplayName());
        System.out.println("DOB: " + user1.getDateOfBirth());
        System.out.println("Mobile Number: " + user1.getMobileNumber());

        // Update display name using setter
        user1.setDisplayName("Raghavendra Achyuth");

        System.out.println("Updated Name: " + user1.getDisplayName());
    }
}