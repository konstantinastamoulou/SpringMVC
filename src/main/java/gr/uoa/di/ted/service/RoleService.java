package gr.uoa.di.ted.service;

import java.util.List;

import gr.uoa.di.ted.model.Role;
import gr.uoa.di.ted.model.User;

public interface RoleService {

	public List<Role> listRoles();
	public List<Role> listSignUpRoles();
	public Role getRoleById(int id);
	public void addRole(Role r);

}
