package gr.uoa.di.ted.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import gr.uoa.di.ted.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO{


	private static final Logger logger = LoggerFactory.getLogger(RoleDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> rolesList = session.createQuery("from Role").list();
		for(Role r : rolesList){
			logger.info("role List::"+r);
		}
		return rolesList;
	}
}
