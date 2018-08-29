package com.nosin.emberv2.model.data;

import com.nosin.emberv2.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketDao extends CrudRepository<Ticket, Integer> {
}
