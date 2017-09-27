package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.User;


public interface UserDao {

	User findById(int id);
	
	User findByUsername(String username);
	
	void save(User user);
	
	void deleteByUsername(String username);
	
	List<User> findAllUsers();

}

