<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
	Overflow by HTML5 UP	html5up.net | @n33co	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)-->
<html>
  <head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <title>Snap-L-Earn</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.scrolly.min.js"></script>
    <script src="js/jquery.poptrox.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/init.js"></script> <noscript>
			<link rel="stylesheet" href="css/skel.css">
			<link rel="stylesheet" href="css/style.css">
			
		</noscript>
		<style>
#yourBtn{
	-webkit-appearance: none;
			position: relative;
			display: inline-block;
			border: 0;
			background: #35b88f;
			color: #fff;
			text-shadow: 0 0 0.5px rgba(255,255,255,0.25);
			cursor: pointer;
			text-decoration: none;
			outline: 0;
			padding: 1em 3em 1em 3em;
			text-align: center;
			border-radius: 3em;
			font-weight: 400;
			-moz-transition: background-color 0.35s ease-in-out, color 0.35s ease-in-out;
			-webkit-transition: background-color 0.35s ease-in-out, color 0.35s ease-in-out;
			-o-transition: background-color 0.35s ease-in-out, color 0.35s ease-in-out;
			-ms-transition: background-color 0.35s ease-in-out, color 0.35s ease-in-out;
			transition: background-color 0.35s ease-in-out, color 0.35s ease-in-out;
  }
</style>
<script type="text/javascript">
 function getFile(){
   document.getElementById("upfile").click();
 }
 function sub(obj){
    var file = obj.value;
    var fileName = file.split("\\");
    document.getElementById("yourBtn").innerHTML = fileName[fileName.length-1];
    document.myForm.submit();
    event.preventDefault();
  }

	function fetchphotos(){
		  var $photos=$('#photos');
		  var userId=<%=(request.getSession().getAttribute("userId"))%>
		  var name='Pranav';
		  $.ajax({
				type:'GET',
				url: '/Snap-L-Earn/fetchPhoto/'+userId,
				contentType: 'application/json',
				dataType: 'json',
				success:function(photos){
					$.each(photos, function(i, data){
						$photos.append('<article id="first" class="box style1"><img src="data:image/jpeg;base64,'+data.photo+'" style="width:250px;height:250px" align="left" /><div class="inner"><header><h2>'+data.title+'<br /></h2></header><p>Focal Length : '+data.focalLength+'&nbsp;Exposure Time : '+data.exposureTime+'&nbsp;ISO : '+data.iso+'</p></article>');
					});
				}
				});
	}
  </script>
    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
  </head>
  <body onload="fetchphotos()">
  
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
    		<li><a href="Contests.jsp">Available</a></li>
    		<li><a href="En_Contest.jsp">Enrolled</a></li>
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
    
    <!-- Portfolio -->
    <article id="first" class="container box style2">
      <header>
        <h2>Gallery</h2>
      </header>
        <div id="photos">
     
          </div>

			<form action="#type your action here" method="POST" enctype="multipart/form-data" name="myForm">
<div id="yourBtn" onclick="getFile()">Upload a File</div>
<!-- this is your file input tag, so i hide it!-->
<!-- i used the onchange event to fire the form submission-->
<div style='height: 0px;width: 0px; overflow:hidden;'><input id="upfile" type="file" value="upload" onchange="sub(this)"/></div>
    <!-- Generic -->
    <!--
			<article class="container box style3">				<header>					<h2>Generic Box</h2>					<p>Just a generic box. Nothing to see here.</p>				</header>				<section>					<header>						<h3>Paragraph</h3>						<p>This is a subtitle</p>					</header>					<p>Phasellus nisl nisl, varius id <sup>porttitor sed pellentesque</sup> ac orci. Pellentesque					habitant <strong>strong</strong> tristique <b>bold</b> et netus <i>italic</i> malesuada <em>emphasized</em> ac turpis egestas. Morbi					leo suscipit ut. Praesent <sub>id turpis vitae</sub> turpis pretium ultricies. Vestibulum sit					amet risus elit.</p>				</section>				<section>					<header>						<h3>Blockquote</h3>					</header>					<blockquote>Fringilla nisl. Donec accumsan interdum nisi, quis tincidunt felis sagittis eget.					tempus euismod. Vestibulum ante ipsum primis in faucibus.</blockquote>				</section>				<section>					<header>						<h3>Divider</h3>					</header>					<p>Donec consectetur <a href="#">vestibulum dolor et pulvinar</a>. Etiam vel felis enim, at viverra					ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel. Praesent nec orci					facilisis leo magna. Cras sit amet urna eros, id egestas urna. Quisque aliquam					tempus euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices					posuere cubilia.</p>					<hr />					<p>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra					ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel. Praesent nec orci					facilisis leo magna. Cras sit amet urna eros, id egestas urna. Quisque aliquam					tempus euismod. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices					posuere cubilia.</p>				</section>				<section>					<header>						<h3>Unordered List</h3>					</header>					<ul class="default">						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>					</ul>				</section>				<section>					<header>						<h3>Ordered List</h3>					</header>					<ol class="default">						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>						<li>Donec consectetur vestibulum dolor et pulvinar. Etiam vel felis enim, at viverra ligula. Ut porttitor sagittis lorem, quis eleifend nisi ornare vel.</li>					</ol>				</section>				<section>					<header>						<h3>Table</h3>					</header>					<div class="table-wrapper">						<table class="default">							<thead>								<tr>									<th>ID</th>									<th>Name</th>									<th>Description</th>									<th>Price</th>								</tr>							</thead>							<tbody>								<tr>									<td>45815</td>									<td>Something</td>									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>									<td>29.99</td>								</tr>								<tr>									<td>24524</td>									<td>Nothing</td>									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>									<td>19.99</td>								</tr>								<tr>									<td>45815</td>									<td>Something</td>									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>									<td>29.99</td>								</tr>								<tr>									<td>24524</td>									<td>Nothing</td>									<td>Ut porttitor sagittis lorem quis nisi ornare.</td>									<td>19.99</td>								</tr>							</tbody>							<tfoot>								<tr>									<td colspan="3"></td>									<td>100.00</td>								</tr>							</tfoot>						</table>					</div>				</section>				<section>					<header>						<h3>Form</h3>					</header>					<form method="post" action="#">						<div class="row">							<div class="6u">								<input class="text" type="text" name="name" id="name" value="" placeholder="John Doe" />							</div>							<div class="6u">								<input class="text" type="text" name="email" id="email" value="" placeholder="johndoe@domain.tld" />							</div>						</div>						<div class="row">							<div class="12u">								<select name="department" id="department">									<option value="">Choose a department</option>									<option value="1">Manufacturing</option>									<option value="2">Administration</option>									<option value="3">Support</option>								</select>							</div>						</div>						<div class="row">							<div class="12u">								<input class="text" type="text" name="subject" id="subject" value="" placeholder="Enter your subject" />							</div>						</div>						<div class="row">							<div class="12u">								<textarea name="message" id="message" placeholder="Enter your message"></textarea>							</div>						</div>						<div class="row">							<div class="12u">								<ul class="actions">									<li><input type="submit" value="Submit" /></li>									<li><input type="reset" class="style3" value="Clear Form" /></li>								</ul>							</div>						</div>					</form>				</section>			</article>		-->
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
