<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.poptrox.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script>

function upload(){
	
	 var title = $('#title');
	 var exposureTime = $('#exposureTime');
	 var iso = $('#iso');
	 var focalLength = $('#focalLength');
     var image =  document.getElementById('image').files[0];
        console.log('called signup');
        
        var formData = new FormData();

        formData.append("title", "");
        formData.append("accountnum", 123456);
        
        
        
        
		var uploadFileRequest={
				title: title.val(),
				exposureTime: exposureTime.val(),
				iso:iso.val(),
				focalLength:focalLength.val(),
				image: image,
		}
		console.log(uploadFileRequest);
		$.ajax({
			type: 'POST',
			url: '/Snap-L-Earn/uploadPhoto',
			data: JSON.stringify(uploadFileRequest),
			dataType: 'json',
			success: function(signUpResponse){
				var uid=signUpResponse.userId;
				var status=signUpResponse.status;
				if(status=="SUCCESS"){
				window.location="http://localhost:8080/Snap-L-Earn/UserProfile.jsp";
				}
				else
					{
						$('#msg').text("Please enter valid details.");
					}
					
			},
			error: function(){
				alert("Error");
			},
			failure: function()
			{
				alert("Failure");
			}
		});         

}

</script>


</head>
<body>
<form id="form1">    

    <label for="sampleText">Please enter a title</label>

    <input id="title" name="title" type="text" /> <br/>
    
    <label for="Exposure Time">Exposure Time</label>

    <input id="exposureTime" name="exposureTime" type="text" /> <br/>
    
    <label for="iso">ISO</label>

    <input id="iso" name="iso" type="text" /> <br/>
    
    <label for="focalLength">Focal Length</label>

    <input id="focalLength" name="focalLength" type="text" /> <br/>
    
    <label for="image">Please select a file

    <input id="image" name="image" type="file" /> <br/>

    <input id="uploadBtn" type="button" value="Ajax Submit" onclick="upload()"></input>

</form>


</body>
</html>