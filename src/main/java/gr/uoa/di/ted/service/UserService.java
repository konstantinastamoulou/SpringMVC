package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.User;


public interface UserService {
	
	User findById(int id);
	
	User findByUsername(String username);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserByUsername(String username);

	List<User> findAllUsers(); 
	
	boolean isUserUsernameUnique(Integer id, String username);
	
	User validateUser(User user);

}