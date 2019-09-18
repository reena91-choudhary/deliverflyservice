package com.tottacoder.deliverfly.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tottacoder.deliverfly.entities.Pigeon;
import com.tottacoder.deliverfly.entities.data.PigeonAvailabilityStatus;
import com.tottacoder.deliverfly.repositories.PigeonRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PigeonController {
	
	private final PigeonRepository pigeonRepository;
	
	public PigeonController(PigeonRepository pigeonRepository) {
		this.pigeonRepository = pigeonRepository;
	}
	
	@GetMapping("/availablePigeons")
    public List<Pigeon> getPigeons() {
		List<Pigeon> allPigeons = (List<Pigeon>) pigeonRepository.findByStatus(PigeonAvailabilityStatus.AVAILABLE);
		List<Pigeon> atMaxFiveItems = new ArrayList<>();
		for(int i=0;i<allPigeons.size() && i < 5 ;  i++) {
			atMaxFiveItems.add(allPigeons.get(i));
		}
        return atMaxFiveItems;
    }

}
