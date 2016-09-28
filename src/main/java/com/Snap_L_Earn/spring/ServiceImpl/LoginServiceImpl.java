package com.Snap_L_Earn.spring.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.Service.LoginService;
import com.Snap_L_Earn.spring.Service.PhotoService;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PhotoDao photoDao;
	
	public SignUpResponse addUser(SignUpRequestBean signUpRequestBean) {
		int userId=photoDao.addUser(signUpRequestBean);
		SignUpResponse signUpResponse= new SignUpResponse();
		signUpResponse.setStatus("SUCCESS");
		signUpResponse.setUserId(userId);
		return signUpResponse;
	}

	public SignUpResponse login(LoginRequestBean loginRequestBean) {
		int userId=photoDao.login(loginRequestBean);
		SignUpResponse signUpResponse= new SignUpResponse();
		if(userId >0){
		signUpResponse.setStatus("SUCCESS");
		} else{
			signUpResponse.setStatus("FAILURE");
		}
		signUpResponse.setUserId(userId);
		return signUpResponse;
	}

}
