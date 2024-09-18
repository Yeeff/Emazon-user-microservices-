package com.app.emazon_user_microservices.infraestructure.input.controller;

import com.app.emazon_user_microservices.domain.api.IUserServicePort;
import com.app.emazon_user_microservices.infraestructure.input.dto.AddUserRequest;
import com.app.emazon_user_microservices.infraestructure.input.mapper.IUserRequestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private IUserRequestMapper userRequestMapper;
    private IUserServicePort userServicePort;

    public AuthController(IUserRequestMapper userRequestMapper, IUserServicePort userServicePort) {
        this.userRequestMapper = userRequestMapper;
        this.userServicePort = userServicePort;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid
            @RequestBody AddUserRequest addUserRequest
            ) {

        userServicePort.addUser(
                userRequestMapper.addRequestToUserModel(addUserRequest)
        );

        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
