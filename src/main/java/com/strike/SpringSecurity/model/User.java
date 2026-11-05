package com.strike.SpringSecurity.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@NoArgsConstructor 
@Table (name = "users")
public class User{

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true, unique = true)
    private String username;
    
    @Column (nullable = true)
    private String password;

    @ManyToMany 
    @JoinTable  (
        name = "user_role",
        joinColumns  = @JoinColumn (name = "user_id"),
        inverseJoinColumns  = @JoinColumn (name= "role_id")

    )
    private Set<Role> role = new HashSet<>();

}