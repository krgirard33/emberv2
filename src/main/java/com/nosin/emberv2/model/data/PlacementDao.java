package com.nosin.emberv2.model.data;

import com.nosin.emberv2.model.Placement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface PlacementDao extends CrudRepository<Placement, Integer> {
}
