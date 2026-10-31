package com.messaging.server.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Past;


public class UserRegistrationRequest {

    /*
    private String username;
    private String displayName;
    private LocalDate dateOfBirth;
    private String mobileNumber;
     */

    // replacing above data members with validations
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 30,
            message = "Username must contain 3 to 30 characters")
    private String username;

    @NotBlank(message = "Display name is required")
    @Size(max = 100,
            message = "Display name cannot exceed 100 characters")
    private String displayName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Mobile number is required")
    @Pattern(
            regexp = "^\\+?[1-9]\\d{7,14}$",
            message = "Enter a valid international mobile number"
    )
    private String mobileNumber;


    // Required for JSON deserialization
    public UserRegistrationRequest() {
    }

    // Parameterized constructor
    public UserRegistrationRequest(
            String username,
            String displayName,
            LocalDate dateOfBirth,
            String mobileNumber) {

        this.username = username;
        this.displayName = displayName;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
