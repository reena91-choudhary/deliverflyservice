package com.tottacoder.deliverfly.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.tottacoder.deliverfly.entities.data.PigeonAvailabilityStatus;

@Entity
@Table(name = "Pigeon")
public class Pigeon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pigeonId", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "name", updatable = false, nullable = false)
	private final String name;
	
	@Column(name = "status", nullable = false)
	private PigeonAvailabilityStatus status;
	
	public Pigeon() {
		this.name = "";
	}

	public Pigeon(final String name, PigeonAvailabilityStatus status) {
		this.name = name;
		this.status = status;
	}
	
	public Pigeon(final String name)
	{
		this(name, PigeonAvailabilityStatus.AVAILABLE);
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public PigeonAvailabilityStatus getStatus() {
		return status;
	}
	
	public void setStatus(PigeonAvailabilityStatus status)
	{
		
		this.status = status;
	}

}
