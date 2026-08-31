package com.neobank.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {
    private final SecretKey key;
    private final long jwtExpirationMs;
    private final long refreshExpirationMs;
    private final String issuer;

    public JwtTokenProvider(
            @Value("${neobank.security.jwt.secret}") String jwtSecret,
            @Value("${neobank.security.jwt.expiration-ms:86400000}") long jwtExpirationMs,
            @Value("${neobank.security.jwt.refresh-expiration-ms:604800000}") long refreshExpirationMs,
            @Value("${neobank.security.jwt.issuer:NeoBank-Auth}") String issuer) {
        this.key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        this.jwtExpirationMs = jwtExpirationMs;
        this.refreshExpirationMs = refreshExpirationMs;
        this.issuer = issuer;
    }

    public String generateAccessToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return generateAccessToken(userPrincipal.getId(), userPrincipal.getUsername(), userPrincipal.getEmail(),
                userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
    }

    public String generateAccessToken(UUID userId, String username, String email, List<String> roles) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationMs);

        return Jwts.builder()
                .subject(userId.toString())
                .claim("username", username)
                .claim("email", email)
                .claim("roles", roles)
                .issuer(issuer)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String generateRefreshToken(UUID userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + refreshExpirationMs);

        return Jwts.builder()
                .subject(userId.toString())
                .claim("type", "REFRESH")
                .issuer(issuer)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public String generateMfaSessionToken(UUID userId, String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + (5 * 60 * 1000));

        return Jwts.builder()
                .subject(userId.toString())
                .claim("email", email)
                .claim("type", "MFA_PENDING")
                .issuer(issuer)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact();
    }

    public UUID getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        return UUID.fromString(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(authToken);
            return true;
        } catch (Exception ex) {
            log.warn("Invalid JWT token: {}", ex.getMessage());
        }
        return false;
    }

    public long getExpirationDurationMs() {
        return jwtExpirationMs;
    }
}
