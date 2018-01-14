<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AddRoom - Room Booking Calendar</title>
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
$(function() {
/* 	alert("in function"); */
	getLocation();
/* 	alert("after get location"); */
 	if(<%=request.getAttribute("check")%>==false)
	{
 		sweetAlertInitialize();
		 sweetAlert("Oops...!", "Room already exists..!!Please enter another Room");
	 	//alert("Room already exists..!!Please enter another Room"); 
	} 
	
});


function getLocation(){
		$.ajax(
		{
			type:"POST",
					url:"GetLocation",
					
					dataType:"JSON" ,
					 
					success:function(data)
					{
						
						for(
								var i=0;i<data.length;i++)
							{
							//alert(data[i]);
							$("#selectLocation").append("<option>"+data[i]+"</option>");
							}
						
				},
				error:function(data,status,error)
				{
					alert(data[1]);
					alert("Error occured in ajax"+error+":"+status);
				}
			
		});
		

		
	}



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

			<form action="RoomController" method="post">

				<h1>Add Room</h1>

				<div class="login-fields">



					<div class="field">
						<label for="roomname">Room Name:</label> <input type="text"
							name="roomname" value="" placeholder="Room Name" class="login"
							required="required" />
					</div>

					<div class="field">
						<label for="lastname">Capacity:</label> <input type="number"
							id="capacity" name="capacity" value="" placeholder="Capacity"
							class="login" required="required" />
					</div>




				</div>
				<!-- /field -->

				<!-- /field -->

				<div class="field selectbox">

					Room Type &nbsp; : &nbsp; <select name="roomtype">
						<option>Lab</option>
						<option>Soft Skill</option>
						<option>Assessment</option>
					</select>


				</div>
				<!-- /login-fields -->



				<div class="field selectbox">

					Location &nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <select
						name="location" id="selectLocation">

					</select>
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


	<!-- Text Under Box -->


	<!-- <script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script> -->


</body>
</html>