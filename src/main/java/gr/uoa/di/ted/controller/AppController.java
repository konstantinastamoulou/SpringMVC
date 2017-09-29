package gr.uoa.di.ted.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.taglibs.standard.resources.Resources;
import org.hibernate.validator.internal.util.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import gr.uoa.di.ted.model.Appartment;
import gr.uoa.di.ted.model.Availability;
import gr.uoa.di.ted.model.FileBucket;
import gr.uoa.di.ted.model.FileUpload;
import gr.uoa.di.ted.model.User;
import gr.uoa.di.ted.model.UserProfile;
import gr.uoa.di.ted.model.UserProfileType;
import gr.uoa.di.ted.service.AppartmentService;
import gr.uoa.di.ted.service.AvailabilityService;
import gr.uoa.di.ted.service.FileUploadService;
import gr.uoa.di.ted.service.UserProfileService;
import gr.uoa.di.ted.service.UserService;
import gr.uoa.di.ted.util.FileValidator;



@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserProfileService userProfileService;
	
	@Autowired
	FileUploadService fileUploadService;
	
	@Autowired
	AppartmentService appartmentService;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	FileValidator fileValidator;

	@Autowired
    AvailabilityService availabilityService;
     
    @InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
       binder.setValidator(fileValidator);
    }
	
	/**
	 * This method will list all existing users.
	 */
	@RequestMapping(value = {"/list" }, method = RequestMethod.GET)
	public String listUsers(ModelMap model) {

		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "userslist";
	}
	
	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "index";
	}

	/**
	 * This method will provide the medium to add a new user.
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("edit", false);
		return "registration";
	}

	/**
	 * This method will be called on form submission, handling POST request for
	 * saving user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!userService.isUserUsernameUnique(user.getId(), user.getUsername())){
			FieldError ssoError =new FieldError("user","username",messageSource.getMessage("non.unique.username", new String[]{user.getUsername()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}
		
		user.setStatus(true);

		Iterator<UserProfile> it = user.getUserProfiles().iterator();
		while(it.hasNext())
		{
			UserProfile up=it.next();
			if(up.getType().equals(UserProfileType.OWNER))
			{
				model.addAttribute("await_approval", "Please await for approval for the role of OWNER");
				user.setStatus(false);
			}
		}
		
		userService.saveUser(user);

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		//return "success";
		return "registrationsuccess";
	}


	/**
	 * This method will provide the medium to update an existing user.
	 */
	@RequestMapping(value = { "/edit-user/{username}" }, method = RequestMethod.GET)
	public String editUser(@PathVariable String username, ModelMap model) {
		User user = userService.findByUsername(username);
		model.addAttribute("user", user);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/**
	 * This method will be called on form submission, handling POST request for
	 * updating user in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-user/{username}" }, method = RequestMethod.POST)
	public String updateUser(@Valid User user, BindingResult result,
			ModelMap model, @PathVariable String username) {

		if (result.hasErrors()) {
			return "registration";
		}

		model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
		
		Iterator<UserProfile> it = user.getUserProfiles().iterator();
		while(it.hasNext())
		{
			UserProfile up=it.next();
			if(up.getType().equals(UserProfileType.OWNER))
			{
				model.addAttribute("await_approval", "Please await for approval for the role of OWNER");
				user.setStatus(false);
			}
		}

		userService.updateUser(user);
		return "registrationsuccess";
	}

	
	/**
	 * This method will delete an user by it's SSOID value.
	 */
	@RequestMapping(value = { "/delete-user/{username}" }, method = RequestMethod.GET)
	public String deleteUser(@PathVariable String username) {
		userService.deleteUserByUsername(username);
		return "redirect:/list";
	}
	

	/**
	 * This method will provide UserProfile list to views
	 */
	@ModelAttribute("roles")
	public List<UserProfile> initializeProfiles() {
		return userProfileService.findAll();
	}

	
	@RequestMapping(value = { "/add-document/{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);
 
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
 
        List<FileUpload> docs = fileUploadService.findByEntityIdAndEntityType(user.getId(), "user");
        model.addAttribute("documents", docs);
         
        return "managedocuments";
    }
 
    @RequestMapping(value = { "/delete-document/{userId}/{docId}" }, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int userId, @PathVariable int docId) {
        fileUploadService.deleteById(docId);
        return "redirect:/add-document/"+userId;
    }
 
    @RequestMapping(value = { "/download-document/{userId}/{docId}" }, method = RequestMethod.GET)
	public String downloadDocument(@PathVariable int userId, @PathVariable int docId, HttpServletResponse response) throws IOException {
		FileUpload document = fileUploadService.findById(docId);
		response.setContentType(document.getMime_type());
        response.setContentLength(document.getData().length);
        response.setHeader("Content-Disposition","attachment; filename=\"" + document.getFilename() +"\"");
 
        FileCopyUtils.copy(document.getData(), response.getOutputStream());
 
 		return "redirect:/add-document/"+userId;
	}
    
    @RequestMapping(value = { "/add-document/{userId}" }, method = RequestMethod.POST)
    public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int userId) throws IOException{
         
        if (result.hasErrors()) {
            System.out.println("validation errors");
            User user = userService.findById(userId);
            model.addAttribute("user", user);
 
            List<FileUpload> docs = fileUploadService.findByEntityIdAndEntityType(user.getId(), "user");
            model.addAttribute("documents", docs);
             
            return "managedocuments";
        } else {
             
            System.out.println("Fetching file");
             
            User user = userService.findById(userId);
            model.addAttribute("user", user);

            System.out.println(fileBucket.getDescription());
            System.out.println(fileBucket.getFile());
            saveDocument(fileBucket, user);
 
            return "redirect:/add-document/"+userId;
        }
    }
    
	@RequestMapping(value = { "/get-document/{docid}" }, method = RequestMethod.GET)
	public void fetchDoc(@PathVariable int docid, HttpServletResponse response) throws IOException {
		
		FileUpload doc=fileUploadService.findById(docid);
		
		response.setContentType(doc.getMime_type());
		response.getOutputStream().write(doc.getData());
	}
    
    private void saveDocument(FileBucket fileBucket, User user) throws IOException{
         
        FileUpload document = new FileUpload();
         
        MultipartFile multipartFile = fileBucket.getFile();
        
        document.setData(multipartFile.getBytes());
        document.setFilename(multipartFile.getOriginalFilename());
        document.setDescription(fileBucket.getDescription());
        document.setEntity_id(user.getId());
        document.setMime_type(multipartFile.getContentType());
        document.setEntity_type("user");
        
        fileUploadService.saveFileUpload(document);
               
        /*
         * TODO:
         * 	think about how to impl. due to lack of id
         * 	think about possibility of populating a list on the fly for each entity (MVC-aware technique?)
         * */
//        document=fileUploadService.findByEntityId(user.getId());
//        user.setFile_upload(document);
//        userService.updateUser(user);
    }
	
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public String loginProcess(HttpServletRequest request, HttpServletResponse response,
    		  @ModelAttribute("luser") User user, ModelMap model) {
    	
    	System.out.println(user.getUsername());
    	
    	User logged_in_user = userService.validateUser(user);
    	if (null != logged_in_user) {
    		model.addAttribute("logged_user", logged_in_user);
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("logged_user", logged_in_user);
    		
    		return "index";
    	} 
    	else {
    		model.addAttribute("message", "Username or Password is wrong!!");
    		return "login";
    	}
    }

	@RequestMapping(value = { "/add-appartment" }, method = RequestMethod.GET)
	public String newAppartment(ModelMap model) {
		Appartment app = new Appartment();
		model.addAttribute("appartment", app);
		model.addAttribute("edit", false);
		return "addAppartment";
	}
	
	@RequestMapping(value = { "/edit-appartment/{appid}" }, method = RequestMethod.GET)
	public String editAppartment(ModelMap model, @PathVariable int appid) {
		Appartment app = appartmentService.findById(appid);
		model.addAttribute("appartment", app);
		model.addAttribute("edit", true);
		return "addAppartment";
	}
	
	@RequestMapping(value = { "/edit-appartment/{appid}" }, method = RequestMethod.POST)
	public String updateUser(@Valid Appartment appartment, BindingResult result,
			ModelMap model, @PathVariable String appid) {

		if (result.hasErrors()) {
			return "addAppartment";
		}
		
		appartmentService.updateAppartment(appartment);
		model.addAttribute("success", "Appartment updated successfully");
		return "registrationsuccess";
	}
	
	@RequestMapping(value = { "/add-appartment" }, method = RequestMethod.POST)
	public String saveAppartment(HttpServletRequest request, @Valid Appartment app, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "addAppartment";
		}

		HttpSession session = request.getSession();
		app.setOwner(userService.findById(((User)session.getAttribute("logged_user")).getId()));
		appartmentService.save(app);

		//model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
		//return "success";
		return "index";
	}
	
	@RequestMapping(value = { "/my-appartments" }, method = RequestMethod.GET)
	public String myAppartments(HttpServletRequest request, ModelMap model) {
		
		List<Appartment> app_list=appartmentService.findAllOfOwner(((User)request.getSession().getAttribute("logged_user")).getId(), ((User)request.getSession().getAttribute("logged_user")));
		model.addAttribute("appartments", app_list);
		return "appartmentList";
	}

	@RequestMapping(value = { "/delete-appartment/{appid}" }, method = RequestMethod.GET)
	public String deleteAppartment(@PathVariable String appid) {

		appartmentService.deleteById(Integer.valueOf(appid));
		return "redirect:/my-appartments";
	}
	
	@RequestMapping(value = { "/add-availability/{appid}" }, method = RequestMethod.GET)
	public String addAvailability(@PathVariable int appid, ModelMap model) {
		Appartment app = appartmentService.findById(appid);
		model.addAttribute("appartment", app);
		
		Availability n_availability = new Availability();
		model.addAttribute("newavailability", n_availability);
		
		List<Availability> avs = availabilityService.getAvailabilityForAppartment(app);
		model.addAttribute("availability", avs);
		
		return "manageavailability";
	}
	
	
	@RequestMapping(value = { "/add-availability/{appid}" }, method = RequestMethod.POST)
    public String uploadAvailability(@Valid Availability newavailability, BindingResult result, ModelMap model, @PathVariable int appid) {

        Appartment app = appartmentService.findById(appid);
        model.addAttribute("appartment", app);

        newavailability.setAppartment(app);
		availabilityService.save(newavailability);
         
        return "redirect:/add-availability/"+appid;
    }
 
}




















