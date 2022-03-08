package com.sapient.dao;

import com.sapient.entity.Shipper;
import org.springframework.data.repository.CrudRepository;

public interface ShipperDao extends CrudRepository<Shipper, Integer> {
}
