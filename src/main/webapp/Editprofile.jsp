<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<title>Edit Profile</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.poptrox.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/init.js"></script>
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body onload=savedetails()>
	
	<script>
	function saveButton(){
		var userId=<%=(request.getSession().getAttribute("userId"))%>
			var updateUserRequestBean={
					manufacturer:$('#manufacturer').val(),
					modelno:$('#modelno').val(),
					name:$('#name').val(),
					age:$('#age').val(),
					email:$('#email').val(),
					street:$('#street').val(),
					city:$('#city').val(),
					state:$('#state').val(),
					zip:$('#zip').val(),
					password:$('#password').val(),
			};
			$.ajax({
				type:'POST',
				url: '/Snap-L-Earn/updateUserDetails/'+userId,
				data: JSON.stringify(updateUserRequestBean),
				contentType: 'application/json',
				dataType: 'json',
				success:function(data){
					alert('Your Details have been saved');
				}
				
				
			});
	}
	</script>
	<script>
	function savedetails(){
		var userId=<%=(request.getSession().getAttribute("userId"))%>
		$.ajax({
			type:'GET',
			url: '/Snap-L-Earn/fetchUserDetails/'+userId,
			contentType: 'application/json',
			dataType: 'json',
			success:function(data){
				var manufacturer=document.getElementById("manufacturer");
				manufacturer.value=data.manufacturer;
				var modelno=document.getElementById("modelno");
				modelno.value=data.modelno;
				var name=document.getElementById("name");
				name.value=data.name;
				var age=document.getElementById("age");
				age.value=data.age;
				var email=document.getElementById("email");
				email.value=data.email;
				var street=document.getElementById("street");
				street.value=data.street;
				var city=document.getElementById("city");
				city.value=data.city;
				var state=document.getElementById("state");
				state.value=data.state;
				var zip=document.getElementById("zip");
				zip.value=data.zip;
				
			}
			
		});
	}
	
	</script>
	    <table>
    <tr>
    <td>
    <a href="UserProfile.jsp">Home</a>
    </td>
    <td>
    <ul>
    <li><a href="Workshop.jsp">Workshops</a>
    	<ul>
    		<li><a href="Workshop.jsp">Available</a></li>
    		<li><a href="En_Workshop.jsp">Enrolled</a></li>
    	</ul> 
    </li>
    </ul>
    </td>
    <td>
    <ul>
    <li><a href="Contests.jsp">Contests</a>
    	<ul>
    		<li><a href="Workshop.jsp">Available</a></li>
    		<li><a href="En_Workshop.jsp">Enrolled</a></li>
    	</ul>
    </li>
    </ul>
    </td>
    <td>
    <a href="Editprofile.jsp">Edit Profile</a>
    </td>
    <td>
    <a href="index.jsp">Logout</a>
    </td>
    </tr>
    </table>
			<article class="container box style3">
				<form method="post" action="signUp">
					<div class="row 50%">
					<table>
					<tr>
						<td><div class="6u">Manufacturer</td>
						<td><div class="6u"><input type="text" class="text" name="manufacturer" id="manufacturer" value='${data.manufacturer}' /></td></div>
					</tr>
					<tr>
						<td><div class="6u">Model Number</td>	
						<td><div class="6u"><input type="text" class="text" name="modelno" id="modelno" value='${data.modelno}' /></div>
						
					</tr>
					<tr>
						<td><div class="6u">Name</td>
						<td><div class="6u"><input type="text" class="text" name="name" id="name" value='${data.name}' /></div>
					</tr>
					<tr>	
						<td><div class="6u">Age</td>
						<td><div class="6u"><input type="text" class="text" name="age" id="age" value='${data.age}' /></div>
					</tr>
					<tr>
						<td><div class="6u">Email</td>
						<td><div class="6u"><input type="text" class="text" name="email" id="email" value='${data.email}' /></div>
					</tr>
					<tr>
						<td><div class="6u">Street</td>
						<td><div class="6u"><input type="text" class="text" name="street" id="street" value='${data.street}' /></div>
					</tr>
					<tr>
						<td><div class="6u">City</td>
						<td><div class="6u"><input type="text" class="text" name="city" id="city" value='${data.city}' /></div>
					</tr>
					<tr>
						<td><div class="6u">State</td>
						<td><div class="6u"><input type="text" class="text" name="state" id="state" value='${data.state}' /></div>
					</tr>	
						<tr>
						<td><div class="6u">Zip</td>
						<td><div class="6u"><input type="text" class="text" name="zip" id="zip" value='${data.zip}' /></div>
					</tr>	
					<tr>
					<td><div class="6u">Password</td>
					<td><div class="6u"><input type="password" class="text" name="password" id="password" placeholder="Password" /></div>
					</tr>
					</table>
					<div class= "6u"><input type="button" value="Save Details" id="savebtn" onclick=saveButton()></div>
					
					
					</div>
					
				</form>
			</article>
			<section id="footer">
      <ul class="icons">
        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a><br>
        </li>
        <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a><br>
        </li>
        <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a><br>
        </li>
        <li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a><br>
        </li>
        <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a><br>
        </li>
        <li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a><br>
        </li>
      </ul>
      <div class="copyright">
        <ul class="menu">
			<li>&copy;Snap-L-Earn. All rights reserved.</li>
        </ul>
      </div>
    </section>
		</body>
		</html>