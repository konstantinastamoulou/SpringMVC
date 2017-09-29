package gr.uoa.di.ted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.AppartmentDao;
import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.User;

@Service("appartmentService")
@Transactional
public class AppartmentServiceImpl implements AppartmentService{

	@Autowired
	AppartmentDao dao;
	
	public Appartment findById(int id){
		return dao.findById(id);
	}
	
	public void save(Appartment appartment){
		dao.save(appartment);
	}
	
	public void deleteById(int id){
		dao.deleteById(id);
	}

	public void updateAppartment(Appartment app) {
		Appartment entity = dao.findById(app.getId());
		if(entity!=null){
			
			entity.setDescription(app.getDescription());
			entity.setLatitude(app.getLatitude());
			entity.setLongitude(app.getLongitude());
			
			entity.setAccess_through_pt(app.getAccess_through_pt());
			entity.setAddress(app.getAddress());
			entity.setBase_rate(app.getBase_rate());
			entity.setBase_rate_no_renters(app.getBase_rate_no_renters());
			entity.setExtra_cost_per_renter(app.getExtra_cost_per_renter());
			entity.setGeneral_rules(app.getGeneral_rules());
			entity.setLiving_room(app.isLiving_room());
			entity.setMax_no_renters(app.getMax_no_renters());
			entity.setNo_baths(app.getNo_baths());
			entity.setNo_bedrooms(app.getNo_bedrooms());
			entity.setNo_beds(app.getNo_beds());
			entity.setSize(app.getSize());
			
		}
	}
	
	public List<Appartment> findAllOfOwner(int id, User user){
		return dao.findAllOfOwner(id, user);
	}

}
