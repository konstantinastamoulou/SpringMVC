package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.Availability;

public interface AvailabilityService {

	Availability findById(int id);
	
	void save(Availability availability);
	
	List<Availability> getAvailabilityForAppartment(Appartment app);
}
