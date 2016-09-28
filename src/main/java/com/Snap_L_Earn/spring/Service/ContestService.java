package com.Snap_L_Earn.spring.Service;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.ResponseBeans.ContestResponseBean;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;

@Component
public interface ContestService {

	public ContestResponseBean fetchUserContests(int userId);

	public ContestResponseBean fetchContests();

	public SignUpResponse addUserContest(int userId, String contestId);

}
