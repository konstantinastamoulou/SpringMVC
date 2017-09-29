package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.User;

public interface AppartmentDao {

	Appartment findById(int id);
		
	void save(Appartment appartment);
	
	void deleteById(int id);

	List<Appartment> findAllOfOwner(int id, User user);
}
