package gr.uoa.di.ted.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gr.uoa.di.ted.model.UserProfile;
import gr.uoa.di.ted.service.UserProfileService;

/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, UserProfile>{

	@Autowired
	UserProfileService userProfileService;

	/**
	 * Gets UserProfile by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UserProfile convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		UserProfile profile= userProfileService.findById(id);
		System.out.println("Profile : "+profile);
		return profile;
	}
	
}