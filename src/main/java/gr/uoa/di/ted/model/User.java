package gr.uoa.di.ted.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@NotEmpty
	@Column(name="password", nullable=false)
	private String password;
		
	@NotEmpty
	@Column(name="first_name", nullable=false)
	private String firstName;

	@NotEmpty
	@Column(name="last_name", nullable=false)
	private String lastName;

	@NotEmpty
	@Column(name="email", nullable=false)
	private String email;

	@NotEmpty
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_user_profile", 
             joinColumns = { @JoinColumn(name = "user_id") }, 
             inverseJoinColumns = { @JoinColumn(name = "user_profile_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + "]";
	}


	
}
