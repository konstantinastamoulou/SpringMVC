package gr.uoa.di.ted.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.uoa.di.ted.dao.RoleDAO;
import gr.uoa.di.ted.model.Role;
import gr.uoa.di.ted.model.User;

@Service
public class RoleServiceImpl implements RoleService{

	private RoleDAO roleDAO;

	public RoleDAO getRoleDAO() {
		return roleDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}


	@Override
	@Transactional
	public List<Role> listRoles() {
		return this.roleDAO.listRoles();
	}

	@Override
	@Transactional
	public List<Role> listSignUpRoles() {
		return this.roleDAO.listSignUpRoles();
	}

	@Override
	@Transactional
	public Role getRoleById(int id) {
		return this.roleDAO.getRoleById(id);
	}

	@Override
	@Transactional
	public void addRole(Role r) {
		this.roleDAO.addRole(r);
	}
}
