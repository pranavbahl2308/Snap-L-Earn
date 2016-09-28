package com.Snap_L_Earn.spring.Service;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.RequestBeans.UpdateUserRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.UserProfileResponse;

@Component
public interface UserProfileService {

	public UserProfileResponse fetchUserDetails(int userId);
	
	public SignUpResponse updateUserDetails(UpdateUserRequestBean updateUserRequestBean,int userId);
	
}
