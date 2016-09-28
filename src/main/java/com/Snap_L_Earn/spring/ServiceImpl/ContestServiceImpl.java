package com.Snap_L_Earn.spring.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.ResponseBeans.ContestResponseBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.Service.ContestService;

@Component
public class ContestServiceImpl implements ContestService {

	@Autowired
	private PhotoDao photoDao;
	
	public ContestResponseBean fetchUserContests(int userId) {
		return photoDao.fetchUserContests(userId);
	}

	public ContestResponseBean fetchContests() {
		return photoDao.fetchUserContests(-1);
	}

	public SignUpResponse addUserContest(int userId, String contestId) {
		String status = photoDao.addUserContest(userId, contestId);
		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setStatus(status);
		return signUpResponse;
	}

}
