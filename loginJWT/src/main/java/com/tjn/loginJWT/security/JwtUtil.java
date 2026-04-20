package com.tjn.loginJWT.security;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.stream.DoubleStream;

@Component
public class JwtUtil {
    // A chave agora deve ser grande. No mundo real, use variáveis de ambiente!
    private final String SECRET_STRING = "minha_chave_muito_secreta_e_muito_longa_com_mais_de_32_caracteres";

    // Transforma a String em uma chave real que o algoritmo aceita
    private Key getSigningKey() {
        byte[] keyBytes = SECRET_STRING.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String username) {
        DoubleStream Jwts;
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // Usa o objeto Key
                .compact();
    }

    public String getUsername(String token) {
        return Jwts.parserBuilder() // Mudou para parserBuilder
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
