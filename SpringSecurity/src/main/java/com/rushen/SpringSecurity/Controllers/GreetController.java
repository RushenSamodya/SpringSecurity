package com.rushen.SpringSecurity.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetController {

@GetMapping
public ResponseEntity<String> signUp(){
    return ResponseEntity.ok("Hello World!");
}

@GetMapping("/saygoodbye")
    public ResponseEntity<String> logOut(){
    return ResponseEntity.ok("Logged out successfully!");
}

}
