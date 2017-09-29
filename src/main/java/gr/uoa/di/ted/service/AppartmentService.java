package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.User;

public interface AppartmentService {

	Appartment findById(int id);
	
	void save(Appartment appartment);
	
	void deleteById(int id);
	
	void updateAppartment(Appartment app);
	
	List<Appartment> findAllOfOwner(int id, User user);
}
