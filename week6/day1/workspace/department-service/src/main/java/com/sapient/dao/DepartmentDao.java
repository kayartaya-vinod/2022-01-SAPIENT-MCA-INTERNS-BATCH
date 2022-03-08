package com.sapient.dao;

import com.sapient.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentDao extends MongoRepository<Department, Integer> {
}
