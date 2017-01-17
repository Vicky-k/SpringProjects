package login.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import login.model.User;




@Controller
@ComponentScan(basePackages = "login")
@RequestMapping("/")
public class AppController {
		
	
	
	 @RequestMapping(value = { "/" }, method = RequestMethod.GET)
	    public String firstPage(ModelMap model) {
		 	
		 
		 
		 
		 	
	        return "main";
	    }
	 @RequestMapping(value = { "/logg" }, method = RequestMethod.GET)
	    public String welcomePage(ModelMap model) {
		 	
		 
		 
		 
		 	User user = new User();
	        System.out.println("heloooooooooo");
	        model.addAttribute("user", user);
	        return "login";
	    }
	 
	 
	 @RequestMapping(value = { "/logg" }, method = RequestMethod.POST)
	    public String validateDetails(@Valid User user, BindingResult result,
	            ModelMap model) {
		 
		 System.out.println("heloooooooooo222");
	 String uname = user.getUsername();
	 
	 String pwd = user.getPassword();
	 
	 
	 if(uname.equals("xxx")&&pwd.equals("yyy")){
		 
		model.addAttribute("username", uname);
		
		 return "success";
	 }
	 else{
		 
		 model.addAttribute("failure", true);
	        return "login";
	 }
	    }
	 
	 
	 
	
}
