package gr.uoa.di.ted.converter;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import gr.uoa.di.ted.model.Role;
import gr.uoa.di.ted.service.RoleService;

@Component
public class Id2Role implements Converter<Object, Role> {
    
	private RoleService roleService;

	public Id2Role(RoleService roleService){
		System.out.println("I was constructed");
		this.roleService=roleService;
		System.out.println(roleService.getRoleById(1));
	}

	public Id2Role(){
	}

//	@Override
//	public Set<Role> convert(Object id) {
//		
//		Set<Role> role_set = new HashSet<Role>();		
//		System.out.println("DSDASDSDDS");
//		role_set.add(roleService.getRoleById(Integer.parseInt((String)id)));
//		return role_set;		
//    }
	
	@Override
	public Role convert(Object id) {
		System.out.println("DSDASDSDDS");
		return roleService.getRoleById(Integer.parseInt((String)id));		
    }
	
}
