package dev.przetrwaj.przetrwajapi.config;

import dev.przetrwaj.przetrwajapi.exception.JwtAuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "54d9150eb5f48f5ca965f4f4fd3cf478d091296d449e595cbcbfc87649f76104";
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
    }
    public<T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }
    private boolean checkTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
    public boolean checkTokenValid(String token, UserDetails userDetails) throws JwtAuthenticationException {
        String username = extractUsername(token);
        if (checkTokenExpired(token)) {
            throw new JwtAuthenticationException("Token is expired");
        }
        if (username == null) {
            throw new JwtAuthenticationException("Username not provided");
        }
        return username.equals(userDetails.getUsername());
    }
}
