package com.app.emazon_user_microservices.domain.model;


import com.app.emazon_user_microservices.infraestructure.adapters.mysqlConfig.model.RoleEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private Long id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private RoleEnum role;
    private String idDocument;
}