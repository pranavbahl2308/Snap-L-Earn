package com.Snap_L_Earn.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponseBean;
import com.Snap_L_Earn.spring.Service.WorkshopService;

@Controller
public class WorkshopController {

	@Autowired
	private WorkshopService workshopService;
	
	@RequestMapping(value="/fetchUserWorkshop/{userId}")
	@ResponseBody
	public WorkshopResponseBean fetchUserWorkshops(HttpServletRequest httpServletRequest,@PathVariable int userId){
		return workshopService.fetchUserWorkshops(userId);
	}
	
	@RequestMapping(value="/fetchWorkshop")
	@ResponseBody
	public WorkshopResponseBean fetchWorkshops(HttpServletRequest httpServletRequest){
		return workshopService.fetchWorkshops();
	}
	
	@RequestMapping(value="/addUserWorkshop/{userId}/{workshopId}")
	@ResponseBody
	public SignUpResponse addUserWorkshop(HttpServletRequest httpServletRequest,@PathVariable int userId,@PathVariable String workshopId){
		return workshopService.addUserWorkshop(userId,workshopId);
	}
}
