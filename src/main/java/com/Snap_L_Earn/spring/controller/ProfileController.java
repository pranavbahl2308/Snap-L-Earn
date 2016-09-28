package com.Snap_L_Earn.spring.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.UpdateUserRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.UserProfileResponse;
import com.Snap_L_Earn.spring.Service.LoginService;
import com.Snap_L_Earn.spring.Service.UserProfileService;

@Controller
public class ProfileController {

	@Autowired
	private UserProfileService userProfileService;
	
	@RequestMapping(value="/fetchUserDetails/{userId}" ,headers={"Content-Type=application/json"} , method=RequestMethod.GET)
	@ResponseBody
    public UserProfileResponse fetchUserDetails(@PathVariable int userId,HttpServletRequest request) {
		return userProfileService.fetchUserDetails(userId);
		
    }
	
	@RequestMapping(value="/updateUserDetails/{userId}" ,headers={"Content-Type=application/json"} , method=RequestMethod.POST)
	@ResponseBody
    public SignUpResponse updateUserDetails(@RequestBody UpdateUserRequestBean updateUserRequestBean,@PathVariable int userId,HttpServletRequest request) {
		return userProfileService.updateUserDetails(updateUserRequestBean,userId);
    }
}
