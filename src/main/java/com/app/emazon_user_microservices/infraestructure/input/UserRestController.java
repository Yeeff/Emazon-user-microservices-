package com.app.emazon_user_microservices.infraestructure.input;

import com.app.emazon_user_microservices.domain.User.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/User")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/Form")
    public ResponseEntity<Map<String,String>> saveUser(){ return ResponseEntity.ok(userService.getForm());}


}
