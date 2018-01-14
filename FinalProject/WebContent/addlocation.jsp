<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<title>AddRoom - Room Booking Calendar</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet"
	type="text/css" />

<link href="css/font-awesome.css" rel="stylesheet">
<link href="mycss.css" rel="stylesheet">
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">

<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/pages/signin.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sweet-alert.css">
<script src="js/sweet-alert.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* alert("inside function"); */
	if(<%=request.getAttribute("inserted")%>==false)
	{
		 sweetAlertInitialize();
		 sweetAlert("Oops...!", "Location already exists..!!Please enter another Location");
	/* 	alert("Location already exists..!!Please enter another Location"); */
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
			<form action="AddLocationController" method="post">
				<h1>Add Location</h1>
				<div class="login-fields">
					<div class="field">
						<label for="roomname">Location Name:</label> <input type="text"
							name=locationName value="" placeholder="Location Name"
							class="login" required="required" />
					</div>
				</div>
				<div class="login-actions">
					<button class="button btn btn-primary btn-large">Add</button>
				</div>
				<!-- .actions -->

			</form>

		</div>
		<!-- /content -->

	</div>
	<!-- /account-container -->

</body>
</html>