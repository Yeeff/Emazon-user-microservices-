package com.app.emazon_user_microservices.infraestructure.input.dto;

import com.app.emazon_user_microservices.domain.utils.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.Email;

import java.time.LocalDate;
@Getter
@Setter
public class AddUserRequest {

    @NotBlank(message = "First name is required")
    private String name;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Identification document is required")
    @Pattern(regexp = "\\d+", message = "Document must contain only numbers")
    private String identificationNumber;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Phone number must be between 10 to 13 digits and can contain the symbol +")
    private String phoneNumber;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotNull(message = "Role is required")
    private RoleEnum role;
}
