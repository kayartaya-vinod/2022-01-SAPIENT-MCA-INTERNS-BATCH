package com.sapient.controllers;

import com.sapient.dao.ProductDao;
import com.sapient.vob.UserVob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductDao dao;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(
            @RequestAttribute(required = false, name = "user") UserVob userVob,
            @PathVariable Integer id){


        Map<String, Object> map = new HashMap<>();
        log.debug("userVob in ProductController.getOne() is {}", userVob);
        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }

        map.put("status", 200);
        map.put("content", dao.findById(id));

        return ResponseEntity.ok(map);
    }

    @GetMapping
    public ResponseEntity<Object> getAll(@RequestAttribute(required = false, name = "user") UserVob userVob) {

        Map<String, Object> map = new HashMap<>();

        if(userVob==null){
            map.put("message", "Please login to access this resource");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
        }
        map.put("status", 200);
        map.put("content", dao.findAll());

        return ResponseEntity.ok(map);
    }
}
