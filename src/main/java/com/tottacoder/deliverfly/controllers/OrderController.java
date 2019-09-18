package com.tottacoder.deliverfly.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tottacoder.deliverfly.entities.Order;
import com.tottacoder.deliverfly.entities.Pigeon;
import com.tottacoder.deliverfly.entities.data.PigeonAvailabilityStatus;
import com.tottacoder.deliverfly.exceptions.InvalidPigeonException;
import com.tottacoder.deliverfly.exceptions.InvalidRequestException;
import com.tottacoder.deliverfly.repositories.OrderRepository;
import com.tottacoder.deliverfly.repositories.PigeonRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	private final PigeonRepository pigeonRepository;
	private final OrderRepository orderRepository;

	public OrderController(PigeonRepository pigeonRepository, OrderRepository orderRepository) {
		super();
		this.pigeonRepository = pigeonRepository;
		this.orderRepository = orderRepository;
	}

	@GetMapping("/orders")
    public List<Order> getOrders() {
        return (List<Order>) orderRepository.findAll();
    }
	
	@GetMapping("/order")
    public Order getOrder(Long orderId) {
        return (Order) orderRepository.findOne(orderId);
    }
	
	@PostMapping("/order")
    public Long addOrder(@RequestBody Order order) {
		
		 validateRequest(order);
		 Pigeon dbPigeon = pigeonRepository.findOne(order.getDeliveryPigeon().getId());
		 if(dbPigeon == null) {
			 throw new InvalidPigeonException(String.format("Pigeon with Id %d not found", order.getDeliveryPigeon().getId()));
		 }
		 if(dbPigeon.getStatus() != PigeonAvailabilityStatus.AVAILABLE) {
			 throw new InvalidPigeonException(String.format("Pigeon with Id %d not available", order.getDeliveryPigeon().getId()));
		 }
		 dbPigeon.setStatus(PigeonAvailabilityStatus.BOOKED); 
		 pigeonRepository.save(dbPigeon);
		 orderRepository.save(order);
		 return order.getId();
    }
	
	private void validateRequest(final Order order) {
		if(order.getDeliveryPigeon() == null) {
			throw new InvalidPigeonException(String.format("Pigeon not set"));
		}
		if(order.getDeliveryPinCode() == null) {
			throw new InvalidRequestException("DeliveryPinCode cannot be null");
		}
		if(order.getDeliveryPinCode().length() > 1000) {
			throw new InvalidRequestException("DeliveryPinCode length cannot be more than 1000");
		}
		if(order.getPickUpPinCode().length() > 1000) {
			throw new InvalidRequestException("PickUpPinCode length cannot be more than 1000");
		}
		if(order.getPackageType().length() > 1000) {
			throw new InvalidRequestException("PackageType length cannot be more than 1000");
		}
	}
}
