<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<meta charset="utf-8">
<title>Signup - Room Booking Calendar</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/font-awesome.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/pages/signin.css" rel="stylesheet" type="text/css">

<!-- <script type="text/javascript" src="jquery-1.7.2.min.js"></script>
<script type="text/javascript"> -->
<link rel="stylesheet" type="text/css" href="sweet-alert.css">
<script src="js/sweet-alert.min.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	/* alert("inside function"); */
	if(<%=request.getAttribute("inserted")%>==false)
	{sweetAlertInitialize();
	 sweetAlert("Oops...!", "UserName already exists..!!Please enter another UserName");
	 	//alert("UserName already exists..!!Please enter another UserName"); 
/* 	 	alert("firstname:"+name);   */
	$("#firstname").val('<%=request.getAttribute("firstname")%>');
		$("#lastname").val('<%=request.getAttribute("lastname")%>');
	
	}
	
});

</script>

</head>
<body>


	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">
			<div class="left">
				<img alt="" src="PSLLogo.jpg" width="70px" height="70px">

			</div>
			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="adminUser.jsp"> Room Booking Calendar </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class=""><a href="adminUser.jsp" class=""> <i
								class="icon-chevron-left"></i> Back to Homepage
						</a></li>
					</ul>

				</div>
				<!--/.nav-collapse -->

			</div>
			<!-- /container -->
			<div class="right">
				<img alt="" src="kc-logo-header (1).png" width="70px" height="70px">
			</div>

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->



	<div class="account-container register">

		<div class="content clearfix">

			<form action="UserController" method="post">

				<h1>Add User</h1>

				<div class="login-fields">

					<p>Create User Account</p>

					<!-- 	<div class="field">
					
					<input type="text" id="userid" name="userid" value="" placeholder="User ID" class="login" required="required" />
				</div> -->


					<div class="field">

						<input type="text" id="firstname" name="firstname" value=""
							placeholder="First Name" class="login" required />
					</div>
					<!-- /field -->

					<div class="field">

						<input type="text" id="lastname" name="lastname" value=""
							placeholder="Last Name" class="login" required="required" />
					</div>
					<!-- /field -->


					<!-- 	<div class="field">
					
					<input type="text" id="designation" name="designation" value="" placeholder="Designation" class="login" required="required"/>
				</div> 
				 -->

					<div class="field">
						<label for="email">Username:</label> <input type="text"
							id="username" name="username" value="" placeholder="Username"
							class="login" required="required" /><span id="available"
							hidden="true">@@@@@@@@@@@@</span>
					</div>
					<!-- /field -->

					<div class="field">
						<label for="password">Password:</label> <input type="password"
							id="password" name="password" value="" placeholder="Password"
							class="login" required="required" />
					</div>
					<!-- /field -->

					<!-- /field -->

					<div class="field">
						User Type: <span></span><select name="usertype">
							<option>Administrator</option>
							<option>Application</option>

						</select>
					</div>




				</div>
				<!-- /login-fields -->

				<div class="login-actions">


					<button class="button btn btn-primary btn-large">Register</button>

				</div>
				<!-- .actions -->

			</form>

		</div>
		<!-- /content -->

	</div>
	<!-- /account-container -->


	<!-- Text Under Box -->


	<!-- <script src="js/jquery-1.7.2.min.js"></script> -->
	<!-- <script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>
 -->



</body>
</html>