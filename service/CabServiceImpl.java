package com.abc.CabBookingApplication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.CabBookingApplication.Repository.CabRepository;
import com.abc.CabBookingApplication.entity.Cab;
import com.abc.CabBookingApplication.exception.ResourceNotFoundException;

@Service
public class CabServiceImpl implements CabService{
	@Autowired
	private CabRepository cabRepository;

	@Override
	public Cab insertCab(Cab cab) {
		
		Cab insertCab = cabRepository.save(cab);
		return insertCab;
	}

	@Override
	public Cab updateCab(Cab cab) {
		
		Cab updateCab = getCabById(cab.getCabId());
		updateCab = cabRepository.save(cab);
		return updateCab;
	}

	@Override
	public void deleteCab(int cabId) {
		Cab cab = getCabById(cabId);
		cabRepository.delete(cab);
		
	}

	@Override
	public List<Cab> viewCabsOfType(String carType) {
		List<Cab> optionalCab = cabRepository.findByType(carType);
		if (optionalCab.isEmpty())
			throw new ResourceNotFoundException("Cab Not found with type : " + carType);
		
		return optionalCab;
	}

	@Override
	public int countCabsOfType(String carType) {
		int count=cabRepository.findByType(carType).size();
		return count;
	}
	
	@Override
	public Cab getCabById(int cabId) {
		Optional<Cab> optionalCab = cabRepository.findById(cabId);
		if (optionalCab.isEmpty())
			throw new ResourceNotFoundException("Cab Not found with id : " + cabId);
		Cab cab = optionalCab.get();
		return cab;
	}
}
