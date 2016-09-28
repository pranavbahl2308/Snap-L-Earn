package com.Snap_L_Earn.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.ResponseBeans.ContestResponseBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.Service.ContestService;

@Controller
public class ContestController {

	
	@Autowired
	private ContestService contestService;
	
	@RequestMapping(value="/fetchUserContest/{userId}")
	@ResponseBody
	public ContestResponseBean fetchUserContests(HttpServletRequest httpServletRequest,@PathVariable int userId){
		return contestService.fetchUserContests(userId);
	}
	
	@RequestMapping(value="/fetchcontest")
	@ResponseBody
	public ContestResponseBean fetchContests(HttpServletRequest httpServletRequest){
		return contestService.fetchContests();
	}
	
	@RequestMapping(value="/addUserContest/{userId}/{contestId}")
	@ResponseBody
	public SignUpResponse addUserContest(HttpServletRequest httpServletRequest,@PathVariable int userId,@PathVariable String contestId){
		return contestService.addUserContest(userId,contestId);
	}
}
