package gr.uoa.di.ted.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.Availability;


@Repository("availabilityDao")
public class AvailabilityDaoImpl extends AbstractDao<Integer, Availability> implements AvailabilityDao{

	public Availability findById(int id) {
		return (Availability)getByKey(id);
	}

	public void save(Availability availability) {
		persist(availability);		
	}
	
	@SuppressWarnings("unchecked")
	public List<Availability> getAvailabilityForAppartment(Appartment app){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("appartment", app));
		return (List<Availability>)crit.list();
	}
}
