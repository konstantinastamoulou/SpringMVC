package gr.uoa.di.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.AvailabilityDao;
import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.Availability;

@Service("availabilityService")
@Transactional
public class AvailabilityServiceImpl implements AvailabilityService {

	@Autowired
	AvailabilityDao dao;
	

	public Availability findById(int id){
		return dao.findById(id);
	}
	
	public void save(Availability availability){
		dao.save(availability);
	}
	
	public List<Availability> getAvailabilityForAppartment(Appartment app){
		return dao.getAvailabilityForAppartment(app);
	}
}
