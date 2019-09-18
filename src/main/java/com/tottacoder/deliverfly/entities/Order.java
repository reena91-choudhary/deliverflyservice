package com.tottacoder.deliverfly.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "pigeonId")
	private Pigeon deliveryPigeon;
	
	@Column(name = "deliveryPinCode", updatable = false, nullable = false)
	private String deliveryPinCode;
	
	@Column(name = "pickUpPinCode", updatable = false, nullable = false)
	private String pickUpPinCode;
	
	@Column(name = "packageType", updatable = false, nullable = false)
	private String packageType;
	
	public Order(Pigeon deliveryPigeon, String deliveryPinCode, String pickUpPinCode, String packageType) {
		super();
		this.deliveryPigeon = deliveryPigeon;
		this.deliveryPinCode = deliveryPinCode;
		this.pickUpPinCode = pickUpPinCode;
		this.packageType = packageType;
	}

	//TO-DO : do we always need a default cntr? 
	public Order() {
		
	}
	
	public long getId() {
		return id;
	}

	public Pigeon getDeliveryPigeon() {
		return deliveryPigeon;
	}

	public String getDeliveryPinCode() {
		return deliveryPinCode;
	}

	public String getPickUpPinCode() {
		return pickUpPinCode;
	}

	public String getPackageType() {
		return packageType;
	}

}
