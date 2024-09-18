package com.app.emazon_user_microservices.domain.model;

import com.app.emazon_user_microservices.domain.utils.RoleEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

public class UserModel {
    private String name;
    private String lastName;
    private String identificationNumber;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private RoleEnum role;

    public UserModel(String name, String lastName, String identificationNumber, String phoneNumber, LocalDate birthDate, String email, String password, RoleEnum role) {
        if (!isValidDocument(identificationNumber)) {
            throw new IllegalArgumentException("Invalid document format, must contain only numbers.");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Invalid phone number, must contain 10-13 digits and can start with +.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        if (!isAdult(birthDate)) {
            throw new IllegalArgumentException("User must be an adult (18+ years old).");
        }
        if (!isValidRole(role)) {
            throw new IllegalArgumentException("Invalid role value.");
        }

        this.name = name;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    private boolean isValidDocument(String document) {
        return document.matches("\\d+");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^\\+?[0-9]{10,13}$");
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private boolean isAdult(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    private boolean isValidRole(RoleEnum role) {
        // Ensure the role is one of the accepted enum values
        return role != null && (role == RoleEnum.AUX_BODEGA || role == RoleEnum.ADMIN || role == RoleEnum.USER);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }
}
