package com.nosin.emberv2.model.data;

import com.nosin.emberv2.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VehicleDao extends CrudRepository<Vehicle, Integer> {
}
