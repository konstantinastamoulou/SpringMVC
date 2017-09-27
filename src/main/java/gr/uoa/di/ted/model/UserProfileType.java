package gr.uoa.di.ted.model;

public enum UserProfileType {
	USER("USER"),
	DBA("DBA"),
	OWNER("OWNER"),
	RENTER("RENTER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
