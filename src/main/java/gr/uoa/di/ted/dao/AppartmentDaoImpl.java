package gr.uoa.di.ted.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.User;

@Repository("appartmentDao")
public class AppartmentDaoImpl extends AbstractDao<Integer, Appartment> implements AppartmentDao{

	public Appartment findById(int id){
		return (Appartment)getByKey(id);
	}
	
	public void save(Appartment appartment){
		persist(appartment);
	}
	
	public void deleteById(int id){
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Appartment app = (Appartment)crit.uniqueResult();
		delete(app);
	}

	public List<Appartment> findAllOfOwner(int id, User user){	
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("owner", user));
		return (List<Appartment>)crit.list();
	}
}
