<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <title>Sign up</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.scrolly.min.js"></script>
    <script src="js/jquery.poptrox.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/init.js"></script> <noscript>
			<link rel="stylesheet" href="css/skel.css">
			<link rel="stylesheet" href="css/style.css">
		</noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
  </head>
  <!-- Signup --> <body>
  <div id="login"><a href="index.jsp">Home</a></div>
    <article class="container box style3">
      <form id="signupform" method="post" action="/Success.jsp">
        <div class="row 50%">
          <div class="6u"><input class="text" name="name" placeholder="Name" type="text" id="name"></div>
          <div class="6u"><input class="text" name="email" placeholder="Email" type="text" id="email"></div>
          <div class="6u"><input class="text" name="password" placeholder="Password" type="password" id="password"></div>
          <div class="6u"><input class="text" name="repassword" placeholder="Re-type Password" type="password"></div>
          <div class="6u"><input class="text" name="age" placeholder="Age" type="text" id="age"></div>
          <div class="6u"><input class="text" name="street" placeholder="Street" type="text" id="street"></div>
          <div class="6u"><input class="text" name="city" placeholder="City" type="text" id="city"></div>
          <div class="6u"><input class="text" name="state" placeholder="State" type="text" id="state"></div>
          <div class="6u"><input class="text" name="zip" placeholder="Zip Code" type="text" id="zip"></div>
          <div class="6u"><input class="text" name="manufacturer" placeholder="Camera Manufacturer" type="text" id="manufacturer"></div>
          <div class="6u"><input class="text" name="modelno" placeholder="Camera Model Number" type="text" id="modelno"></div>
          <div class="12u">
            <ul class="actions">
              <li><input value="Sign up" type="button" id="signup"></li>
            </ul>
          </div>
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
