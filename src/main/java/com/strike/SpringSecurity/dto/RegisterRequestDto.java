package com.strike.SpringSecurity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter 
@Setter 
@NoArgsConstructor 
public class RegisterRequestDto {

    

    private String username;

    private String password;
}
