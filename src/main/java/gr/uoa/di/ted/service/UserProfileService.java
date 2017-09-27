package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
