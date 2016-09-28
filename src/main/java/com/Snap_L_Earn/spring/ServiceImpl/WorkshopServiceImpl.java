package com.Snap_L_Earn.spring.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponseBean;
import com.Snap_L_Earn.spring.Service.WorkshopService;
@Component
public class WorkshopServiceImpl implements WorkshopService {

	@Autowired
	private PhotoDao photoDao;
	
	public WorkshopResponseBean fetchUserWorkshops(int userId) {
		return photoDao.fetchUserWorkshops(userId);
	}

	public WorkshopResponseBean fetchWorkshops() {
		return photoDao.fetchUserWorkshops(-1);
	}

	public SignUpResponse addUserWorkshop(int userId, String workshopId) {
		String status= photoDao.addUserWorkshop(userId,workshopId);
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setStatus(status);
		return signUpResponse;
	}

}
