<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta content="text/html; charset=utf-8" http-equiv="content-type">
    <title>Login</title>
    <meta name="description" content="">
    <meta name="keywords" content="">
    <!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.scrolly.min.js"></script>
    <script src="js/jquery.poptrox.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/login.js"></script>
    <script src="js/init.js"></script> <noscript>
			<link rel="stylesheet" href="css/skel.css">
			<link rel="stylesheet" href="css/style.css">
		</noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
  </head>
  <!-- Signup --> <body>
  <div id="login"><a href="index.jsp">Home</a></div>
    <article class="container box style3">
    <div id="msg"></div>
      <form method="post" action="#">
        <div class="row 50%">
          <div style="text-align: left;" class="6u"><input autocomplete="on" class="text"

              name="email" placeholder="Email" type="text" id="email"></div>
          <div class="6u"><input autocomplete="on" class="text" name="password"

              placeholder="Password" type="password" id="password"></div>
          <div class="12u">
            <ul class="actions">
              <li><input value="Login" type="button" id="loginsubmit"></li>
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
