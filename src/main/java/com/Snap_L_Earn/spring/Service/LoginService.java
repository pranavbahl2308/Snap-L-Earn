package com.Snap_L_Earn.spring.Service;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;

@Component
public interface LoginService {

	public SignUpResponse addUser(SignUpRequestBean requestBean);
	
	public SignUpResponse login(LoginRequestBean loginRequestBean);

}
