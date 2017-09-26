package gr.uoa.di.ted.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gr.uoa.di.ted.model.User;
import gr.uoa.di.ted.service.RoleService;

@Controller
@RequestMapping
public class UIController {

	private RoleService roleService;

	@Autowired(required=true)
	@Qualifier(value="roleService")
	public void setRoleService(RoleService rs){
		this.roleService = rs;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("user", new User());
		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listSignUpRoles", this.roleService.listSignUpRoles());
		return "signup";
	}
	
//	@Autowired
//	private ConversionService conversionService;
//	@InitBinder
//	protected void initBinder(ServletRequestDataBinder binder) {
//		binder.setConversionService(conversionService);
//	}

}
