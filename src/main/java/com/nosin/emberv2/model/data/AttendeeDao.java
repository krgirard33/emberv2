package com.nosin.emberv2.model.data;

import com.nosin.emberv2.model.Attendee;
import com.nosin.emberv2.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public interface AttendeeDao extends CrudRepository<Attendee, Integer> {

}
