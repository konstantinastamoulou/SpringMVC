package gr.uoa.di.ted.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.UserDAO;
import gr.uoa.di.ted.model.User;


@Service
public class UserServiceImpl implements UserService{

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Override
	@Transactional
	public void updateUser(User u) {
		this.userDAO.updateUser(u);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(int id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

}
