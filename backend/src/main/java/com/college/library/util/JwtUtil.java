package com.college.library.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
    private final String Secret="Change here with ur secretKey its used for sigining the token";
    private final long exp=1000*60*20;
    private final Key secretKey= Keys.hmacShaKeyFor(Secret.getBytes(StandardCharsets.UTF_8));
    public String generateToken(String email){
        return Jwts.builder()
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+exp))
                .signWith(secretKey,SignatureAlgorithm.HS256)
                .setSubject(email)
                .compact();

    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public boolean validateJwtToken(String token)
    {
        try{
           extractEmail(token);
            return true;
        }
        catch(JwtException j){
            return false;
        }
    }
}
