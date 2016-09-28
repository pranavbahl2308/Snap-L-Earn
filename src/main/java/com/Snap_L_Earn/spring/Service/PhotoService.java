package com.Snap_L_Earn.spring.Service;

import java.sql.Blob;
import java.util.List;

import org.springframework.stereotype.Component;

import com.Snap_L_Earn.spring.RequestBeans.UploadFileRequest;
import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;

@Component
public interface PhotoService {
public List<PhotoDetails> fetchAllPhotos(int userId);

public String uploadPhoto(UploadFileRequest uploadFileRequest, Blob blob);
}
