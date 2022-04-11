package com.abc.CabBookingApplication.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="driver_table")
public class Driver extends AbstractUser{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driverId;
	
	@OneToMany(mappedBy="driver",cascade = CascadeType.PERSIST)
	List<TripBooking> trips = new ArrayList<>();
	
	@Column(name="driver_licence_no")
	private String licenceNo;
	
	@Column(name="driver_rating")
	private float rating;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cab_id", referencedColumnName = "cab_id")
	private Cab cab;
	
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getLicenceNo() {
		return licenceNo;
	}
	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}

}
