package com.jonathan;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid() {
        for (int i = 0; i < 10; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * test generating JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "jonathan")//signature algorithm, and key
                .setClaims(claims)//self-define: payload part of jwt
                .setExpiration(new Date(System.currentTimeMillis()+ 1000 * 3600))//set expiration as 1 hour
                .compact();
        System.out.println(jwt);
    }

    /**
     * test parsing JWT
     */
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("jonathan")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcxMzU2NDQ5MH0.QHiYvkZOesZBX0AqwhqjzgFVkVzcKIgoZTeU-3lQdJE")
                .getBody();
        System.out.println(claims);

    }

}
