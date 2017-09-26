package gr.uoa.di.ted.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import gr.uoa.di.ted.model.Role;
import gr.uoa.di.ted.model.User;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> listSignUpRoles() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> rolesList = session.createQuery("from Role").list();
		int index=0;
		int to_remove=-1;
		for(Role r : rolesList){
			logger.info("role List::"+r);
			
			if(r.getName().equals("administrator"))
				to_remove=index;
			index++;
		}
		if(to_remove!=-1)
			rolesList.remove(to_remove);
		return rolesList;
	}

	@Override
	public Role getRoleById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Role r = (Role) session.load(Role.class, new Integer(id));
		logger.info("Role loaded successfully, Role details="+r);
		return r;
	}
	
	@Override
	public void addRole(Role r) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(r);
		logger.info("role saved successfully, role Details="+r);
	}
	
	
	
}
