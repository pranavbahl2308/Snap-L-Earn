package com.Snap_L_Earn.spring.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.RequestBeans.UpdateUserRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.UserProfileResponse;
import com.Snap_L_Earn.spring.Service.UserProfileService;

@Component
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	private PhotoDao photoDao;
	
	public UserProfileResponse fetchUserDetails(int userId) {
		return photoDao.fetchUserDetails(userId);
	}

	public SignUpResponse updateUserDetails(UpdateUserRequestBean updateUserRequestBean,int userId) {
		int rowCount= photoDao.updateUserDetails(updateUserRequestBean,userId);
		SignUpResponse signUpResponse = new SignUpResponse();
		if(rowCount > 0){
			signUpResponse.setStatus("SUCCESS");
		} else{
			signUpResponse.setStatus("FAILURE");
		}
		return signUpResponse;
	}

}
