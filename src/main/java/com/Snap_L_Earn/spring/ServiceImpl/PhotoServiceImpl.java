package com.Snap_L_Earn.spring.ServiceImpl;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.RequestBeans.UploadFileRequest;
import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;
import com.Snap_L_Earn.spring.Service.PhotoService;

@Component
public class PhotoServiceImpl implements PhotoService {

	@Autowired
	private PhotoDao photoDao;
	
	public List<PhotoDetails> fetchAllPhotos(int userId) {
		return photoDao.fetchAllPhotos(userId);
	}

	public String uploadPhoto(UploadFileRequest uploadFileRequest, Blob blob) {
		return photoDao.uploadPhoto(uploadFileRequest,blob);
	}

}
