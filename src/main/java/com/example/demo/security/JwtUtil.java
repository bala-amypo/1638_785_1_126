// package com.example.demo.security;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// import java.util.Date;

// public class JwtUtil {

//     private final String secretKey = "amyposupersecretkey";
//     private final long expirationMs = 3600000;

//     public String generateToken(Long id, String email, String role) {
//         return Jwts.builder()
//                 .claim("id", id)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(
//                         new Date(System.currentTimeMillis() + expirationMs)
//                 )
//                 .signWith(SignatureAlgorithm.HS256, secretKey)
//                 .compact();
//     }

//     public Claims validateToken(String token) {
//         return Jwts.parser()
//                 .setSigningKey(secretKey)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Base64;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(String username) {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        SecretKey key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
                .setSubject(username)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
}
