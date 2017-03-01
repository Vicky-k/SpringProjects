package com.sdk.app.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdk.app.dao.ClassDao;
import com.sdk.app.model.UserInfo;

@Controller
@RequestMapping("/")
public class MainController {
	private static final Log LOGGER = LogFactory.getLog(MainController.class);
	
	public static String dbUrl;
	public static String dbDriver;
	public static String dbUserName;
	public static String dbPassword;
	public static String dbDialect;
	
	@Autowired
	ClassDao classDao;
	
	
	@RequestMapping(value ="/main" ,method=RequestMethod.GET)
	public String getMainLandingPage(){
		List<Object> data = classDao.getData(UserInfo.class);
		System.out.println(data.size());
		return "register";
	}
	@RequestMapping(value ="/register" ,method=RequestMethod.POST)
	public String getRegisterLandingPage(HttpServletRequest req, HttpServletResponse res){
		
		String firstname = req.getParameter("FirstName");
		String lastname= req.getParameter("LastName");
		String username= req.getParameter("UserName");
		String email= req.getParameter("Email");
		String password= req.getParameter("password");
	
		UserInfo userinfo = new UserInfo();
		userinfo.setFirstname(firstname);
		userinfo.setLastname(lastname);
		userinfo.setUsername(username);
		userinfo.setEmail(email);
		userinfo.setPassword(password);
		
		classDao.register(userinfo);
		
		List<Object> data = classDao.getData(UserInfo.class);
		System.out.println(data.size());
		return "login";
	}
	@PostConstruct
	public void init(){
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream("C:/Users/vikas/Desktop/SDKAppProject/SDKAppProject/sdkapp.properties");
			// load a properties file
			prop.load(input);
			
			dbDriver = prop.getProperty("sdk.database.driver");
			dbUrl = prop.getProperty("sdk.database.url");
			dbUserName = prop.getProperty("sdk.database.username");
			dbPassword = prop.getProperty("sdk.database.password");
			dbDialect = prop.getProperty("sdk.database.dialect");
		}catch(Exception e){
			LOGGER.error("Exception Occured While reading the Properties"+e);
			e.printStackTrace();
		}
	}

}
