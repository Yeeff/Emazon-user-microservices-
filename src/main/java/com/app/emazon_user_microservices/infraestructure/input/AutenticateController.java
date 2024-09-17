package com.app.emazon_user_microservices.infraestructure.input;

import com.app.emazon_user_microservices.domain.model.AuthenticationRequest;
import com.app.emazon_user_microservices.domain.model.RegisterRequest;
import com.app.emazon_user_microservices.domain.model.AuthenticationResponse;
import com.app.emazon_user_microservices.infraestructure.adapters.SecurityConfig.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AutenticateController {

    private final AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return  ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        return ResponseEntity.ok(service.register(registerRequest));
    }
}
