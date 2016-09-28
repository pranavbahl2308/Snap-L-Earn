package com.Snap_L_Earn.spring.Service;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponseBean;

@Component
public interface WorkshopService {

	public WorkshopResponseBean fetchUserWorkshops(int userId);

	public WorkshopResponseBean fetchWorkshops();

	public SignUpResponse addUserWorkshop(int userId, String workshopId);

}
