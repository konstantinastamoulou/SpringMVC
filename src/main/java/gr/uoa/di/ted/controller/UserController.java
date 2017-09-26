package gr.uoa.di.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.uoa.di.ted.model.User;
import gr.uoa.di.ted.service.RoleService;
import gr.uoa.di.ted.service.UserService;

@Controller
@RequestMapping
public class UserController {

	private UserService userService;
	private RoleService roleService;

	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService us){
		this.userService = us;
	}
	
	@Autowired(required=true)
	@Qualifier(value="roleService")
	public void setRoleService(RoleService rs){
		this.roleService = rs;
	}
		
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		model.addAttribute("listRoles", this.roleService.listRoles());
		return "user";
	}
	
//	@Autowired
//	private ConversionService conversionService;
//	@InitBinder
//	protected void initBinder(ServletRequestDataBinder binder) {
//		binder.setConversionService(conversionService);
//	}
	
	//For add and update User both
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User u, BindingResult bindingResult){

		System.out.println("TEST");
		System.out.println("User:"+u.getRoles().size());
		
		if(u.getId() == 0){
			//new User, add it
			this.userService.addUser(u);
		}else{
			//existing User, call update
			this.userService.updateUser(u);
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/user/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
		
        this.userService.removeUser(id);
        return "redirect:/users";
    }
 
    @RequestMapping("/user/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
		model.addAttribute("listRoles", this.roleService.listRoles());
        return "user";
    }
	
}
