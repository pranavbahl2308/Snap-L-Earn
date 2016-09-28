package com.Snap_L_Earn.spring.DAOImpl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.Snap_L_Earn.spring.DAO.PhotoDao;
import com.Snap_L_Earn.spring.RequestBeans.LoginRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.SignUpRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.UpdateUserRequestBean;
import com.Snap_L_Earn.spring.RequestBeans.UploadFileRequest;
import com.Snap_L_Earn.spring.ResponseBeans.ContestResponse;
import com.Snap_L_Earn.spring.ResponseBeans.ContestResponseBean;
import com.Snap_L_Earn.spring.ResponseBeans.PhotoDetails;
import com.Snap_L_Earn.spring.ResponseBeans.SignUpResponse;
import com.Snap_L_Earn.spring.ResponseBeans.UserProfileResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponse;
import com.Snap_L_Earn.spring.ResponseBeans.WorkshopResponseBean;
import com.Snap_L_Earn.spring.controller.PhotoConfig;

@Component
public class PhotoDaoImpl implements PhotoDao {

	@Autowired
	PhotoConfig photoConfig;

	private Connection connection = null;

	public List<PhotoDetails> fetchAllPhotos(int userId) {
		PhotoDetails photoDetails =null;
		List<PhotoDetails> photoDetailsList = new ArrayList<PhotoDetails>();
		try {
			if(null == connection){
				connection= photoConfig.getDataSource().getConnection();
			}
			String query="Select * from Photograph P,photodesc PD WHERE P.PhotoID=PD.PhotoID and PD.UserId=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			System.out.println("before Query");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println("inside loop");
				photoDetails = new PhotoDetails();
				photoDetails.setPhotoId(resultSet.getString("PhotoID"));
				photoDetails.setExposureTime(resultSet.getInt("Exposure_Time"));
				photoDetails.setFocalLength(resultSet.getString("Focal_Length"));
				photoDetails.setIso(resultSet.getString("ISO"));
				photoDetails.setTitle(resultSet.getString("Title"));

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[10000];
				Blob blob = resultSet.getBlob("Photo");
				InputStream in =  blob.getBinaryStream(1,blob.length());
				System.out.println("id content" +in);
				int n = 0;
				while ((n=in.read(buf))>=0)
				{
					baos.write(buf, 0, n);

				}

				in.close();
				byte[] bytes = baos.toByteArray();
				System.out.println("bytes" +bytes);
				byte[] encodeBase64 = Base64.encodeBase64(buf);
				String base64Encoded = new String(encodeBase64, "UTF-8");

				System.out.println("Image:"+ base64Encoded);


				photoDetails.setPhoto(base64Encoded);
				photoDetailsList.add(photoDetails);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}	
		}
		return photoDetailsList;
	}



	public int addUser(SignUpRequestBean signUpRequestBean) {
		int userId = 0;
		try {
			if(null == connection){
				connection=photoConfig.getDataSource().getConnection();
			}
			String query="Insert into user(Name,Age,Email,Password,Street,City,State,Zip) values(?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, signUpRequestBean.getName());
			statement.setInt(2, Integer.parseInt(signUpRequestBean.getAge()));
			statement.setString(3, signUpRequestBean.getEmail());
			statement.setString(4, signUpRequestBean.getPassword());
			statement.setString(5, signUpRequestBean.getStreet());
			statement.setString(6, signUpRequestBean.getCity());
			statement.setString(7, signUpRequestBean.getState());
			statement.setString(8, signUpRequestBean.getZip());
			System.out.println("before Query");
			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				System.out.println("throwing");
				throw new Exception("Creating user failed, no rows affected.");
			} else{
				ResultSet generatedKey = statement.getGeneratedKeys();
				if(generatedKey.next()){
					userId = generatedKey.getInt(1);
				}
				String cameraQuery="Insert into cameradesc(UserID,Manufacturer,Model_Number) values(?,?,?)";
				PreparedStatement cameraStatement = connection.prepareStatement(cameraQuery);
				cameraStatement.setInt(1, userId);
				cameraStatement.setString(2, signUpRequestBean.getManufacturer());
				cameraStatement.setString(3, signUpRequestBean.getModelno());
				int cameraRows = cameraStatement.executeUpdate();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception "+e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println("exception2"+e2.getMessage());
			}	
		}
		return userId;
	}



	public int login(LoginRequestBean loginRequestBean) {
		int userId = 0;
		try {
			if(null == connection){
				connection=photoConfig.getDataSource().getConnection();
			}
			String query="Select UserID from user where Email=? and Password=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, loginRequestBean.getEmail());
			statement.setString(2, loginRequestBean.getPassword());
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()){
				userId = resultset.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception "+e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println("exception2"+e2.getMessage());
			}	
		}
		return userId;
	}



	public UserProfileResponse fetchUserDetails(int userId) {
		UserProfileResponse userProfileResponse = new UserProfileResponse();
		try {
			if(null == connection){
				connection=photoConfig.getDataSource().getConnection();
			}
			String query="Select * from user U,CameraDesc CD where U.UserID=CD.UserID AND U.UserID=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				userProfileResponse.setName(resultSet.getString("Name"));
				userProfileResponse.setAge(resultSet.getString("Age"));
				userProfileResponse.setCity(resultSet.getString("City"));
				userProfileResponse.setManufacturer(resultSet.getString("Manufacturer"));
				userProfileResponse.setModelno(resultSet.getString("Model_Number"));
				userProfileResponse.setEmail(resultSet.getString("Email"));
				userProfileResponse.setState(resultSet.getString("State"));
				userProfileResponse.setStreet(resultSet.getString("Street"));
				userProfileResponse.setZip(resultSet.getString("Zip"));

			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception "+e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println("exception2"+e2.getMessage());
			}	
		}
		return userProfileResponse;
	}



	public int updateUserDetails(
			UpdateUserRequestBean updateUserRequestBean,int userId) {
		int cameraAffectedRows =0;
		try {
			if(null == connection){
				connection=photoConfig.getDataSource().getConnection();
			}
			String query="Update user set Name=?, Email=?, Street=?, City=?, State=?, Zip=?, Password=?,Age=? WHERE UserID=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, updateUserRequestBean.getName());
			statement.setString(2, updateUserRequestBean.getEmail());
			statement.setString(3, updateUserRequestBean.getStreet());
			statement.setString(4, updateUserRequestBean.getCity());
			statement.setString(5, updateUserRequestBean.getState());
			statement.setString(6, updateUserRequestBean.getZip());
			statement.setString(7, updateUserRequestBean.getPassword());
			statement.setString(8, updateUserRequestBean.getAge());
			statement.setInt(9, userId);
			int affectedRows = statement.executeUpdate();
			if(affectedRows>0){
				String camerQuery = "Update cameradesc set Manufacturer=? ,Model_Number=? WHERE UserId=?";
				PreparedStatement cameraStatement = connection.prepareStatement(camerQuery);
				cameraStatement.setString(1, updateUserRequestBean.getManufacturer());
				cameraStatement.setString(2, updateUserRequestBean.getModelno());
				cameraStatement.setInt(3, userId);
				cameraAffectedRows = cameraStatement.executeUpdate();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception "+e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println("exception2"+e2.getMessage());
			}	
		}
		return cameraAffectedRows;
	}



	public WorkshopResponseBean fetchUserWorkshops(int userId) {
		WorkshopResponseBean workshopResponseBean = null;
		WorkshopResponse workshopResponse =null;
		List<WorkshopResponse> workshopResponses = new ArrayList<WorkshopResponse>();
		try {
			if(null == connection){
				connection= photoConfig.getDataSource().getConnection();
			}
			PreparedStatement statement =null;
			if(userId >0){
				String query="Select * from workshop W,user_workshop U WHERE U.WorkshopID=W.WorkshopID and U.UserId=?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, userId);
			} else{
				String query="Select * from workshop";
				statement = connection.prepareStatement(query);
			}
			System.out.println("before Query");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println("inside loop");

				workshopResponse = new WorkshopResponse();
				workshopResponse.setDesc(resultSet.getString("Workshop_Desc"));
				workshopResponse.setDoe(resultSet.getDate("DOE"));
				workshopResponse.setName(resultSet.getString("Workshop_Name"));
				workshopResponse.setOrganizer(resultSet.getString("Organizer"));
				workshopResponse.setPrice(resultSet.getFloat("Price"));
				workshopResponse.setId(resultSet.getString("WorkshopID"));

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[10000];
				Blob blob = resultSet.getBlob("Image");
				InputStream in =  blob.getBinaryStream(1,blob.length());
				System.out.println("id content" +in);
				int n = 0;
				while ((n=in.read(buf))>=0)
				{
					baos.write(buf, 0, n);

				}

				in.close();
				byte[] bytes = baos.toByteArray();
				System.out.println("bytes" +bytes);
				byte[] encodeBase64 = Base64.encodeBase64(buf);
				String base64Encoded = new String(encodeBase64, "UTF-8");

				System.out.println("Image:"+ base64Encoded);

				workshopResponse.setImage(base64Encoded);

				workshopResponses.add(workshopResponse);
			}
			if(!CollectionUtils.isEmpty(workshopResponses)){
				workshopResponseBean = new WorkshopResponseBean();
				workshopResponseBean.setWorkshopResponses(workshopResponses);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}	
		}		
		return workshopResponseBean;
	}



	public ContestResponseBean fetchUserContests(int userId) {
		ContestResponseBean contestResponseBean = null;
		ContestResponse contestResponse =null;
		List<ContestResponse> contestResponses = new ArrayList<ContestResponse>();
		try {
			if(null == connection){
				connection= photoConfig.getDataSource().getConnection();
			}
			PreparedStatement statement =null;
			if(userId >0){
				String query="Select * from contest C,user_contest U WHERE U.ContestID=C.ContestID and U.UserId=?";
				statement = connection.prepareStatement(query);
				statement.setInt(1, userId);
			} else{
				String query="Select * from contest";
				statement = connection.prepareStatement(query);
			}
			System.out.println("before Query");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println("inside loop");

				contestResponse = new ContestResponse();
				contestResponse.setDesc(resultSet.getString("Contest_Desc"));
				contestResponse.setLdos(resultSet.getDate("LDOS"));
				contestResponse.setName(resultSet.getString("Contest_Name"));
				contestResponse.setRules(resultSet.getString("Contest_Rules"));
				contestResponse.setPrice(resultSet.getFloat("Price"));
				contestResponse.setWinner(resultSet.getString("Winner"));
				contestResponse.setId(resultSet.getString("ContestID"));

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] buf = new byte[10000];
				Blob blob = resultSet.getBlob("Image");
				InputStream in =  blob.getBinaryStream(1,blob.length());
				System.out.println("id content" +in);
				int n = 0;
				while ((n=in.read(buf))>=0)
				{
					baos.write(buf, 0, n);

				}

				in.close();
				byte[] bytes = baos.toByteArray();
				System.out.println("bytes" +bytes);
				byte[] encodeBase64 = Base64.encodeBase64(buf);
				String base64Encoded = new String(encodeBase64, "UTF-8");

				System.out.println("Image:"+ base64Encoded);

				contestResponse.setImage(base64Encoded);

				contestResponses.add(contestResponse);
			}
			if(!CollectionUtils.isEmpty(contestResponses)){
				contestResponseBean = new ContestResponseBean();
				contestResponseBean.setContestResponses(contestResponses);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}	
		}		
		return contestResponseBean;	
	}



	public String addUserWorkshop(int userId, String workshopId) {
		String status="FAILURE";
		try {
			if(null == connection){
				connection= photoConfig.getDataSource().getConnection();
			}
				String query="Select * from user_workshop WHERE WorkshopID=? and UserId=?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, workshopId);
				statement.setInt(2, userId);
				ResultSet resultSet = statement.executeQuery();
				if(!resultSet.next()){
					String insertQuery = "Insert into user_workshop values(?,?)";
					PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
					insertStatement.setString(2, workshopId);
					insertStatement.setInt(1, userId);
					int affectedRows = insertStatement.executeUpdate();
					if(affectedRows>0){
						status="SUCCESS";
					}
				}
		}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} finally{
				try {
					//connection.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}	
			}	
		return status;
	}



	public String addUserContest(int userId, String contestId) {
		String status="FAILURE";
		try {
			if(null == connection){
				connection= photoConfig.getDataSource().getConnection();
			}
				String query="Select * from user_contest WHERE ContestID=? and UserId=?";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, contestId);
				statement.setInt(2, userId);
				ResultSet resultSet = statement.executeQuery();
				if(!resultSet.next()){
					String insertQuery = "Insert into user_contest values(?,?)";
					PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
					insertStatement.setString(2, contestId);
					insertStatement.setInt(1, userId);
					int affectedRows = insertStatement.executeUpdate();
					if(affectedRows>0){
						status="SUCCESS";
					}
				}
		}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			} finally{
				try {
					//connection.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}	
			}	
		return status;
	}



	public String uploadPhoto(UploadFileRequest uploadFileRequest, Blob blob) {
		String status = "FAILURE";
		try {
			if(null == connection){
				connection=photoConfig.getDataSource().getConnection();
			}
			String query="Insert into photograph(PhotoID,Photo,Exposure_Time,ISO,Focal_Length,Title) values(?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, "P1004");
			statement.setBlob(2, blob);
			statement.setString(3, uploadFileRequest.getExposureTime());
			statement.setString(4, uploadFileRequest.getIso());
			statement.setString(5, uploadFileRequest.getFocalLength());
			statement.setString(6, uploadFileRequest.getTitle());
			System.out.println("before Query");
			int affectedRows = statement.executeUpdate();

			if (affectedRows == 0) {
				System.out.println("throwing");
				throw new Exception("Uploading photo failed, no rows affected.");
			}else{
				status="SUCCESS";
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception "+e.getMessage());
		} finally{
			try {
				//connection.close();
			} catch (Exception e2) {
				System.out.println("exception2"+e2.getMessage());
			}	
		}
		return status;
	}
	}

