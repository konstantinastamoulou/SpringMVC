package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
