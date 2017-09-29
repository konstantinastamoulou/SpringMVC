package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.Availability;
import gr.uoa.di.ted.model.Appartment;

public interface AvailabilityDao {

	Availability findById(int id);
	
	void save(Availability availability);

	List<Availability> getAvailabilityForAppartment(Appartment app);
}
