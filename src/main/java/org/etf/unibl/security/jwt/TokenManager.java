package org.etf.unibl.security.jwt;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.etf.unibl.models.CustomUserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims; import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class TokenManager implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7008375124389347049L; public static final long TOKEN_VALIDITY = 10 * 60 * 60;
    @Value("${secret}")
    private String jwtSecret;
    @Value("${expiration}")
    private String expiration;

    public String generateJwtToken(CustomUserDetails userDetails) {
        return Jwts.builder()
                .setId(userDetails.getUser().getId().toString())
                .setSubject(userDetails.getUsername())
                .claim("role", userDetails.getRole().toString())
                .setExpiration(new Date(System.currentTimeMillis() + Integer.parseInt(expiration)))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();

    }
    public Boolean validateJwtToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        Boolean isTokenExpired = claims.getExpiration().before(new Date());
        return (username.equals(userDetails.getUsername()) && !isTokenExpired);
    }
    public String getUsernameFromToken(String token) {
        final Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}