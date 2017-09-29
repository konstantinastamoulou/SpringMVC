package gr.uoa.di.ted.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.UserDao;
import gr.uoa.di.ted.model.User;
import gr.uoa.di.ted.model.UserProfile;
import gr.uoa.di.ted.model.UserProfileType;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findByUsername(String username) {
		User user = dao.findByUsername(username);
		return user;
	}

	public void saveUser(User user) {
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setUsername(user.getUsername());
			entity.setPassword(user.getPassword());
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
			entity.setTelephone(user.getTelephone());
		}
	}

	
	public void deleteUserByUsername(String username) {
		dao.deleteByUsername(username);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserUsernameUnique(Integer id, String username) {
		User user = findByUsername(username);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
	public User validateUser(User user){
		return dao.validateUser(user);
	}
}
