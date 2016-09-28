<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Overflow by HTML5 UP
	html5up.net | @n33co
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Contests</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/jquery.poptrox.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/init.js"></script>
<script>
		function fetchContests(){
			  var $contests=$('#contests');
			  var userId=<%=(request.getSession().getAttribute("userId"))%>
			  var name='Pranav';
			  $.ajax({
					type:'GET',
					url: '/Snap-L-Earn/fetchcontest',
					contentType: 'application/json',
					dataType: 'json',
					success:function(contests){
						$.each(contests.contestResponses, function(i, data){
							$contests.append('<article id="'+i+'" class="container box style1 right"><img src="data:image/jpeg;base64,'+data.image+'" style="width:350px;height:300px" align="left" /><div class="inner"><header><h2>'+data.name+'<br /></h2></header><br />'+data.desc+'<br />Price : '+data.price+'$<br />Last Day of Submission : '+data.ldos+'<div class="12u"><ul class="actions"><li><input id="'+data.id+'"type="button" value="Join" onclick="savedetails(this.id)" /></li></ul></div></div></article>');
						});
					}
					});
		}
		
		function savedetails(id){
			var userId=<%=(request.getSession().getAttribute("userId"))%>
			var joinContest={
					contestId:id,
					userId:userId
		}
			$.ajax({
				type:'GET',
				url: '/Snap-L-Earn/addUserContest/'+userId+'/'+id,
				contentType: 'application/json',
				dataType: 'json',
				success:function(data){
					if(data.status=="SUCCESS"){
						alert('Your have successfully been enrolled in the selected contest!');
				}
					if(data.status=="FAILURE"){
						alert('Your have already been enrolled in the selected contest!');
				}
				}
				
				
			});
		}
	
		</script>
<noscript>
	<link rel="stylesheet" href="css/skel.css" />
	<link rel="stylesheet" href="css/style.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>
<body onload="fetchContests()">
	<table>
		<tr>
			<td><a href="UserProfile.jsp">Home</a></td>
			<td>
				<ul>
					<li><a href="Workshop.jsp">Workshops</a>
						<ul>
							<li><a href="Workshop.jsp">Available</a></li>
							<li><a href="En_Workshop.jsp">Enrolled</a></li>
						</ul></li>
				</ul>
			</td>
			<td>
				<ul>
					<li><a href="Contests.jsp">Contests</a>
						<ul>
							<li><a href="Contests.jsp">Available</a></li>
							<li><a href="En_Contest.jsp">Enrolled</a></li>
						</ul></li>
				</ul>
			</td>
			<td><a href="Editprofile.jsp">Edit Profile</a></td>
			<td><a href="index.jsp">Logout</a></td>
		</tr>
	</table>
	<section id="header"> <header>
	<h1>Contests</h1>
	<p>
		<br> </br>
	</p>
	</header> <footer> <a href="#hidden"
		class="button style2 scrolly-middle">Checkout</a> </footer> </section>
	<div id="hidden"><p id="hiddenp"></p></div>
	<div id="contests"></div>

	<section id="footer">
	<ul class="icons">
		<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
		<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
		<li><a href="#" class="icon fa-google-plus"><span
				class="label">Google+</span></a></li>
		<li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
		<li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
		<li><a href="#" class="icon fa-linkedin"><span class="label">LinkedIn</span></a></li>
	</ul>
	<div class="copyright">
		<ul class="menu">
			<li>&copy; Snap-L-Earn. All rights reserved.</li>
		</ul>
	</div>
	</section>

</body>
</html>