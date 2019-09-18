package com.tottacoder.deliverfly.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tottacoder.deliverfly.entities.Pigeon;
import com.tottacoder.deliverfly.entities.data.PigeonAvailabilityStatus;

@Repository
public interface PigeonRepository extends CrudRepository<Pigeon, Long>{

	List<Pigeon> findByStatus(PigeonAvailabilityStatus status);
}
