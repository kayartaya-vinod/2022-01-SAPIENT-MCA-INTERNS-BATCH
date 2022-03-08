package com.sapient.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${secret.key.for.jwt}")
    String secretKey;

    public String createToken(String userId, String name) throws Exception {
        Algorithm algorithm= Algorithm.HMAC256(secretKey);
        String token = JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("name", name)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis()+(15*60*1000)))
                .sign(algorithm);

        return token;
    }

    public Map<String, Object> verify(String token) throws Exception{
        Algorithm algorithm= Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);

        Map<String, Object> map = new HashMap<>();
        map.put("userId", decodedJWT.getSubject());
        map.put("name", decodedJWT.getClaim("name").asString());
        return map;
    }

}
