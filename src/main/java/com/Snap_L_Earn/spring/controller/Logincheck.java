package com.Snap_L_Earn.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;


@Controller
public class Logincheck {
	
	@RequestMapping(value="/Logincheck" ,headers={"Content-Type=application/json"} , method=RequestMethod.POST)
	@ResponseBody
    public PhotoDetails fetchPhoto(@RequestBody String data){
		System.out.println("In Photos" + data);
		System.out.println("Back again");
		PhotoDetails photoDetails = new PhotoDetails();
		photoDetails.setExposureTime(21);
		photoDetails.setFocalLength("23");
		photoDetails.setIso("12");
		photoDetails.setPhotoId("qw213");
		return photoDetails;
		
    }

}

