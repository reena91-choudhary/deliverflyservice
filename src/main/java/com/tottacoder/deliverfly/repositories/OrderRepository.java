package com.tottacoder.deliverfly.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tottacoder.deliverfly.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
