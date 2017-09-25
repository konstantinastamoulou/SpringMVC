package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.User;

public interface UserDAO {

	public void addUser(User p);
	public void updateUser(User p);
	public List<User> listUsers();
	public User getUserById(int id);
	public void removeUser(int id);
}
