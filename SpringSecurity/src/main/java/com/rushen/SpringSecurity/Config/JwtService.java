package com.rushen.SpringSecurity.Config;

import com.auth0.jwt.interfaces.Claim;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String SECRET_KEY = "d2ffb8731436d2b925fcacb5cb110f2c56964f0b08afd016eaee5c09224f03d2";
    public String extractUserName(String token) {
        return null;
    }

    private Key getSignInKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claim extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    //Next Start 1:01:00

}
