package com.Snap_L_Earn.spring.controller;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.Service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	private int userId;
	
	@RequestMapping(value="/Newsignup" ,headers={"Content-Type=application/json"} , method=RequestMethod.POST)
	@ResponseBody
    public SignUpResponse addNewUser(@RequestBody SignUpRequestBean newperson,HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("In Photos" + newperson.getAge());
		System.out.println("Back again");
		return loginService.addUser(newperson);
		
    }
	
	@RequestMapping(value="/login" ,headers={"Content-Type=application/json"} , method=RequestMethod.POST)
	@ResponseBody
    public SignUpResponse login(@RequestBody LoginRequestBean loginRequestBean,HttpServletRequest request) {
		System.out.println("In Login" + loginRequestBean.getPassword());
		System.out.println("Back again");
		SignUpResponse signUpResponse = loginService.login(loginRequestBean);
		userId = signUpResponse.getUserId();
		request.getSession().setAttribute("userId", userId);
		return signUpResponse;
    }

}
