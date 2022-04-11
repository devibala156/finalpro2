package com.abc.CabBookingApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cab_table")
public class Cab{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cab_id")
	private int cabId;
	
	@Column(name="car_type")
	private String carType;
	
	@Column(name="per_km_rate")
	private float perKmRate;
	
	//Getters and setters
	public int getCabId() {
		return cabId;
	}
	public void setCabId(int cabId) {
		this.cabId = cabId;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public float getPerKmRate() {
		return perKmRate;
	}
	public void setPerKmRate(float perKmRate) {
		this.perKmRate = perKmRate;
	}
}
