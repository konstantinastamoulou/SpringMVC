package gr.uoa.di.ted.dao;

import java.util.List;

import gr.uoa.di.ted.model.Role;
import gr.uoa.di.ted.model.User;

public interface RoleDAO {

	public List<Role> listRoles();
	public List<Role> listSignUpRoles();
	public Role getRoleById(int id);
	public void addRole(Role r);
	
}
