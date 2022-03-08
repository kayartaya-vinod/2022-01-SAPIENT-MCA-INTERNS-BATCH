package com.sapient.dao;

import com.sapient.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, Integer> {
    public Optional<User> findByEmail(String email);
}
