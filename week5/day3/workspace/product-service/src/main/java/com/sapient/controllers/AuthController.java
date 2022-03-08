package com.sapient.controllers;

import com.sapient.dao.UserDao;
import com.sapient.entity.User;
import com.sapient.utils.JwtUtil;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    JwtUtil util;

    @Autowired
    UserDao userDao;

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody User user) throws Exception {

        Optional<User> result = userDao.findById(user.getEmail());
        Map<String, Object> map = new HashMap<>();

        if(result.isPresent()){
            User actualUser = result.get();
            if(actualUser.getIsActive() && BCrypt.checkpw(user.getPassword(), actualUser.getPassword())){
                map.put("token", util.createToken(user.getEmail(), user.getEmail()));
                map.put("status", 200);
                map.put("timestamp", System.currentTimeMillis());
                return ResponseEntity.ok(map);
            }
        }

        map.put("status", 401);
        map.put("message", "Invalid username/password or user not active");

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
    }

}
