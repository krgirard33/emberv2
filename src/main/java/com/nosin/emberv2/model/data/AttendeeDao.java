package com.nosin.emberv2.model.data;

import com.nosin.emberv2.model.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;


@Repository
@Transactional
public interface AttendeeDao extends CrudRepository<Attendee, Integer> {

}
