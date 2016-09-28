package com.Snap_L_Earn.spring.DAO;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.UpdateUserRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.UploadFileRequest;
import com.Snap_L_Earn.spring.ResponseBeans.ContestResponseBean;
import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.UserProfileResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponseBean;

@Component
public interface PhotoDao {
	public List<PhotoDetails> fetchAllPhotos(int userId);
	
	public int addUser(SignUpRequestBean signUpRequestBean);
	
	public int login(LoginRequestBean loginRequestBean);

	public UserProfileResponse fetchUserDetails(int userId);

	public int updateUserDetails(UpdateUserRequestBean updateUserRequestBean,int userId);

	public WorkshopResponseBean fetchUserWorkshops(int userId);

	public ContestResponseBean fetchUserContests(int userId);

	public String addUserWorkshop(int userId, String workshopId);

	public String addUserContest(int userId, String contestId);

	public String uploadPhoto(UploadFileRequest uploadFileRequest, Blob blob);

}
