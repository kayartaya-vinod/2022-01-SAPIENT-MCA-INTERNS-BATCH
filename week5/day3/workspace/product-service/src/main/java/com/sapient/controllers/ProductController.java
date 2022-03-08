package com.sapient.controllers;

import com.sapient.dao.ProductDao;
import com.sapient.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductDao dao;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestHeader(name = "Authorization", required = false) String authorization) {

        Map<String, Object> map = new HashMap<>();
        map.put("status", 401);

        if (authorization == null) {
            map.put("message", "Authorization header is missing");
            return ResponseEntity.status(401).body(map);
        }
        // Authorization: JWT token
        String[] parts = authorization.split(" ");
        if (!parts[0].equals("JWT")) {
            map.put("message", "Authorization header is not JWT");
            return ResponseEntity.status(401).body(map);
        }

        try {
            Map<String, Object> data = jwtUtil.verify(parts[1]);
            map.put("userId", data.get("userId"));
            map.put("name", data.get("name"));
        } catch (Exception e) {
            map.put("message", "JWT is not valid");
            return ResponseEntity.status(401).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findAll());

        return ResponseEntity.ok(map);
    }
}
