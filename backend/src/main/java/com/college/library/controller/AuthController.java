package com.college.library.controller;

import com.college.library.entity.Userd;
import com.college.library.repository.UserRepo;
import com.college.library.service.UserService;
import com.college.library.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserRepo ur;
    private final UserService us;
    private final PasswordEncoder ps;
    private final JwtUtil jwtutil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Map<String,String> body)
    {
        String email =body.get("email");
        String password =ps.encode(body.get("password"));

        if(ur.findByEmail(email).isPresent())
        {
            return new ResponseEntity<>("Email Already Exist", HttpStatus.CONFLICT);
        }
        us.createUser(Userd.builder().email(email).password(password).build());
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String,String> body)
    {
        String email =body.get("email");
        String password =body.get("password");

        var userOptional=ur.findByEmail(email);
        if(userOptional.isEmpty())
        {
            return new ResponseEntity<>("USER NOT REGISTER",HttpStatus.UNAUTHORIZED);
        }
        Userd user=userOptional.get();
        if(!ps.matches(password,user.getPassword()))
        {
            return new ResponseEntity<>("Invalid USer",HttpStatus.UNAUTHORIZED);
        }
        String token=jwtutil.generateToken(email);
        return ResponseEntity.ok(Map.of("token",token));
    }
}
