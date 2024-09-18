package com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.entity;

import com.app.emazon_user_microservices.domain.utils.RoleEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "user")
public class UserEntity  {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String lastName;
    private String identificationNumber;
    private String phoneNumber;
    private LocalDate birthDate;
    private String email;
    private String password;
    private RoleEnum role;
}
