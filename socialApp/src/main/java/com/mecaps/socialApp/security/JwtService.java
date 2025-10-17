package com.mecaps.socialApp.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;


@Service
public class JwtService {

    private final static long ACCESS_TOKEN_EXP = 1000 * 60 + 60; // 1 huors
    private final static String SECRET_KEY = "123645789qwertyuopklsamnfgt@5gtr";

    public SecretKey getSecreteKey(){
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }


    public String generateAccessToken(String email, String role){
        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXP))
                .signWith(getSecreteKey())
                .compact();
    }



}
