package com.abc.CabBookingApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.CabBookingApplication.entity.Cab;
import com.abc.CabBookingApplication.service.CabService;

@RestController
@RequestMapping("/cab")
public class CabController {
	@Autowired
	private CabService cabService;
	
	@PostMapping("/insert")
	public ResponseEntity<Cab> insertCab(@RequestBody Cab cab) {
		Cab insertcab = cabService.insertCab(cab);
		ResponseEntity<Cab> responseEntity = null;
		responseEntity = new ResponseEntity<>(insertcab, HttpStatus.CREATED);
		return responseEntity;
	}

	
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCab(@RequestBody Cab cab) {
		ResponseEntity<Object> responseEntity = null;
		
			Cab updateCab = cabService.updateCab(cab);
			responseEntity = new ResponseEntity<>(updateCab, HttpStatus.OK);
		
		return responseEntity;

   }
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCabById(@PathVariable("id") int cabId) {
		ResponseEntity<Object> responseEntity = null;
		
			cabService.deleteCab(cabId);
			responseEntity = new ResponseEntity<>("Cab data deleted successfully", HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping("/type")
	public ResponseEntity<List<Cab>> getAllCabs(@RequestParam String type) {
		return new ResponseEntity<List<Cab>>(cabService.viewCabsOfType(type),HttpStatus.OK);
	}
	
	@GetMapping("/typeCount")
	public ResponseEntity<?> getCountOfCabsByType(@RequestParam String type) {
		return new ResponseEntity<Integer>(cabService.countCabsOfType(type),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCabById(@PathVariable("id") int cabId) {
		ResponseEntity<Object> responseEntity = null;
		
			Cab cab = cabService.getCabById(cabId);
			responseEntity = new ResponseEntity<>(cab, HttpStatus.OK);
		
		return responseEntity;
	}

}