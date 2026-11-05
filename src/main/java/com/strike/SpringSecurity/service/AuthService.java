package com.strike.SpringSecurity.service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.strike.SpringSecurity.dto.LoginRequestDto;
import com.strike.SpringSecurity.dto.LoginResponseDto;
import com.strike.SpringSecurity.dto.RegisterRequestDto;
import com.strike.SpringSecurity.dto.RegisterResponseDto;
import com.strike.SpringSecurity.model.User;
import com.strike.SpringSecurity.repository.UserRepository;

@Service 
public class AuthService {

    private UserRepository registerRepository;

    private PasswordEncoder passwordEncoder;

    private AuthenticationManager authenticationManager;
    
    public AuthService(UserRepository registerRepository, 
                        PasswordEncoder passwordEncoder, 
                        AuthenticationManager authenticationManager){
        this.registerRepository = registerRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public RegisterResponseDto register(RegisterRequestDto registerRequestDto){
            User user = new User();

            user.setUsername(registerRequestDto.getUsername());

            String encodedPassword = passwordEncoder.encode(registerRequestDto.getPassword());

            user.setPassword(encodedPassword);

            registerRepository.save(user);

            RegisterResponseDto response = new RegisterResponseDto();

            response.setUsername(user.getUsername());
            response.setMessage("User Registered");

            return response;

    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto){

        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequestDto.getUsername(), 
                loginRequestDto.getPassword()
                )
        );

        LoginResponseDto response = new LoginResponseDto();

        response.setUsername(authentication.getName());
        response.setMessage("Login Success");

        return response;

    }

    
    
}
