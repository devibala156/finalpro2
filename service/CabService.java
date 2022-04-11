package com.abc.CabBookingApplication.service;

import java.util.List;

import com.abc.CabBookingApplication.entity.Cab;

public interface CabService {
	public Cab insertCab(Cab cab);
	public Cab updateCab(Cab cab);
	public void deleteCab(int cabId);
	public List<Cab> viewCabsOfType(String carType);
	public int countCabsOfType(String carType);
	public Cab getCabById(int cabId);
}
