package com.sapient.controllers;

import com.sapient.dao.ShipperDao;
import com.sapient.entity.Shipper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    ShipperDao dao;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAll(){
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS a").format(new Date()));
        map.put("content", this.dao.findAll());
        return ResponseEntity.ok(map);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getById(@PathVariable Integer id){
        Optional<Shipper> result = dao.findById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS a").format(new Date()));

        if(result.isEmpty()){
            map.put("message", "No data found for shipper id: " + id);
            map.put("status", 404);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
        }
        map.put("status", 200);
        map.put("content", result.get());
        return ResponseEntity.ok(map);
    }
}
