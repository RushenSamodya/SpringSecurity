package com.rushen.SpringSecurity.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

@GetMapping("/user/login")
@PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<String> userLogin(){
        return ResponseEntity.ok("Hello User!");
}
@GetMapping("/admin/login")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String> AdminLogin(){
        return ResponseEntity.ok("Hello Admin!");
}

@GetMapping("/logout")
    public ResponseEntity<String> logOut(){
        return ResponseEntity.ok("Logged out successfully!");
}

}
