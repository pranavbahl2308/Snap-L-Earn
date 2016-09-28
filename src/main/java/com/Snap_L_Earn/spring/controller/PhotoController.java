package com.Snap_L_Earn.spring.controller;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Snap_L_Earn.spring.RequestBeans.UploadFileRequest;
import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.Service.PhotoService;

@Controller
public class PhotoController 
{
	@Autowired
	private PhotoService photoService;
	
	@RequestMapping(value="/fetchPhoto/{userId}" , method=RequestMethod.GET)
	@ResponseBody
    public List<PhotoDetails> fetchPhoto(@PathVariable int userId){
		List<PhotoDetails> details = photoService.fetchAllPhotos(userId);
		return details;
		
    }
	
	@RequestMapping(value="/uploadPhoto" , method=RequestMethod.POST)
	@ResponseBody
    public SignUpResponse uploadPhoto(@RequestBody UploadFileRequest uploadFileRequest){
		SignUpResponse signUpResponse = new SignUpResponse();
		System.out.println("File:"+ uploadFileRequest.getImage().getName());
		System.out.println("CCOntent type:"+uploadFileRequest.getImage().getContentType());
		try{
			Blob blob = Hibernate.createBlob(uploadFileRequest.getImage().getInputStream());
			String status = photoService.uploadPhoto(uploadFileRequest,blob);
			signUpResponse.setStatus(status);
		}catch(IOException exception){
			System.out.println(exception.getMessage());
		}
		return signUpResponse;
		
    }
}
