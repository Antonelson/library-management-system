package com.college.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
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
