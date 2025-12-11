package com.college.library.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor  
@AllArgsConstructor
public class Userd {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Email
    String email;
    String password;

}
