package com.strike.SpringSecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strike.SpringSecurity.dto.LoginRequestDto;
import com.strike.SpringSecurity.dto.LoginResponseDto;
import com.strike.SpringSecurity.dto.RegisterRequestDto;
import com.strike.SpringSecurity.dto.RegisterResponseDto;
import com.strike.SpringSecurity.service.AuthService;

import org.springframework.security.core.AuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController 
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }
    
    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterRequestDto registerRequestDto) {
        
        RegisterResponseDto response =  authService.register(registerRequestDto);

        return ResponseEntity.ok(response);
        
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
       try{
         LoginResponseDto response = authService.login(loginRequestDto);

        return ResponseEntity.ok(response);
       
    }
       catch(AuthenticationException e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or Password");
       }
    }

    
    

    @GetMapping("/csrf")
    public CsrfToken getToken(CsrfToken csrfToken) {
        return csrfToken;
    }
    
    
    
}
