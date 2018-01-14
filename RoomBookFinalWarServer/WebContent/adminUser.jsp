<%@ page import="com.psl.entity.* "%>
<%@ page import="com.psl.dao.* "%>
<%@ page import="java.util.* "%>
<%@ page import="java.text.* "%>
<%@ page import="java.util.*"%>
<%@ page session="true"%>
<%

//get UserName to verify 
String userName= (String) session.getAttribute("firstname");
String type=(String) session.getAttribute("usertype");
if(userName!=null && type.equalsIgnoreCase("administrator"))
{

//user is valid

}
else
{

//return here as user is invalid
response.sendRedirect("login.html");

}

%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Reports - Room Booking Calendar</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-responsive.min.css" rel="stylesheet">

<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600"
	rel="stylesheet">
<link href="css/font-awesome.css" rel="stylesheet">

<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="sweet-alert.css">
<script src="js/sweet-alert.min.js"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>

<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<!-- <script type="text/javascript" src="jquery-1.11.1.js"></script> -->
<link href="css/pages/reports.css" rel="stylesheet">

<script type="text/javascript" src="js/freezeHeader.js"></script>
<style type="text/css">
.CSSTableGenerator {
	margin: 0px;
	padding: 0px;
	width: 100%;
	border: 1px solid #000000;
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright: 0px;
	-webkit-border-bottom-right-radius: 0px;
	border-bottom-right-radius: 0px;
}

.CSSTableGenerator table tr:first-child th:first-child {
	-moz-border-radius-topleft: 0px;
	-webkit-border-top-left-radius: 0px;
	border-top-left-radius: 0px;
}

.CSSTableGenerator table tr:first-child th:last-child {
	-moz-border-radius-topright: 0px;
	-webkit-border-top-right-radius: 0px;
	border-top-right-radius: 0px;
}

.CSSTableGenerator tr:last-child th:first-child {
	-moz-border-radius-bottomleft: 0px;
	-webkit-border-bottom-left-radius: 0px;
	border-bottom-left-radius: 0px;
}

.CSSTableGenerator tr:hover td {
	
}
/*  .CSSTableGenerator tr:nth-child(odd){ background-color:#ffaa56; }
.CSSTableGenerator tr:nth-child(even)    { background-color:#ffffff;
} */
.CSSTableGenerator td, th {
	vertical-align: middle;
	border: 1px solid #000000;
	border-width: 0px 1px 1px 0px;
	text-align: left;
	padding: 14px;
	font-size: 10px;
	font-family: Arial;
	font-weight: normal;
	color: #000000;
}

.CSSTableGenerator tr:last-child td {
	border-width: 0px 1px 0px 0px;
}

.CSSTableGenerator tr td:last-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:last-child td:last-child {
	border-width: 0px 0px 0px 0px;
}

.CSSTableGenerator tr:first-child th {
	background: -o-linear-gradient(bottom, #e3e3e3 5%, #e9e9e9 100%);
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #e3e3e3
		), color-stop(1, #e9e9e9));
	background: -moz-linear-gradient(center top, #e3e3e3 5%, #e9e9e9 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#e3e3e3",
		endColorstr="#e9e9e9");
	background: -o-linear-gradient(top, #e3e3e3, e9e9e9);
	background-color: #e3e3e3;
	border: 0px solid #000000;
	text-align: center;
	border-width: 0px 0px 1px 1px;
	font-size: 14px;
	font-family: Arial;
	font-weight: bold;
	color: #000;
}

.CSSTableGenerator tr:first-child th:first-child {
	border-width: 0px 0px 1px 0px;
}

.CSSTableGenerator tr:first-child th:last-child {
	border-width: 0px 0px 1px 1px;
}

.c0 {
	background-color: green;
}

.c1 {
	background-color: red;
}

.c2 {
	background-color: orange;
}
</style>


<script type="text/javascript">
	  					$(function() {
	  						
	  						
	  						
	  						//$(".CSSTableGenerator td").tooltip();   
	  						$("#popover").popover({ trigger: "hover" });
	  						$("#statusTable TD").click(function(){
	  							//alert("td selected");
	  							$(this).css("background-color","red");	
	  						});
	  						
	  					    
	  						$("#datepicker1,#datepicker2").datepicker(
	  						{
	  							dateFormat:'yy-m-dd'
	  						}		
	  									
	  						
	  						);
	  						
	  						$("#book").click(function(){
	  							$.get("book1.jsp");
	  						});
	  						$("#view").click(function(){
	  							//alert('hi');
	  							$.get("viewbooking.jsp");
	  						});
 	  						
	  						
	  						getLocation();
	  					  });
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					
	  					function getLocation()
	  					{
	  						//alert("In get Location");
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
	  											$("#locationSelect").append("<option>"+data[i]+"</option>");
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
				</a> <a class="brand" href="adminUser.jsp"> Room Booking Calendar
				</a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class="dropdown"><a href="#"><i class="icon-user"></i>
								<%=session.getAttribute("firstname")%> </a></li>


						<li><a href="signout.jsp"> <i class="icon-cog"></i>
								Sign Out

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





	<div class="subnavbar">

		<div class="subnavbar-inner">

			<div class="container">

				<ul class="mainnav">





					<li class="active"><a href="adminUser.jsp"> <i
							class="icon-dashboard"></i> <span>DashBoard</span>
					</a></li>
					<li><a href="addroom.jsp"> <i class="icon-credit-card"></i>

							<span>Add New Room</span>
					</a></li>
					<li><a href="addUser.jsp"> <i class="icon-user"></i> <span>Add
								User</span>
					</a></li>

					<li><a href="addlocation.jsp"> <i class=" icon-home"></i>
							<span>Add Location</span>
					</a></li>









				</ul>

			</div>
			<!-- /container -->

		</div>
		<!-- /subnavbar-inner -->

	</div>
	<!-- /subnavbar -->



	<div class="main">

		<div class="main-inner">

			<div class="container">

				<div class="row">

					<div class="span12">
						<div class="widget-header">
							<!-- <i class="icon-user"></i> -->
							<h3>Location</h3>
							<select id="locationSelect">
							</select>
							<h3>Start Date</h3>

							<input type="text" id="datepicker1">
							<h3>End Date</h3>
							<input type="text" id="datepicker2">

							<!-- <input type="checkbox" id="lab" checked="checked">
	  					Lab<input type="checkbox" id="softskill" checked="checked">
	  					Softskill -->
							<input type="submit" id="go"
								class="button btn btn-primary btn-large">
							<!-- <button id="go">Go</button> -->

						</div>




						<script type="text/javascript">
	  		$(function() {
	  			
	  			
	  			if(<%=session.getAttribute("bookvalue")%>==true)
		  			{sweetAlertInitialize();
		  			 sweetAlert("Done...!", "Room booked Successfully!");
		  			 	//alert("UserName already exists..!!Please enter another UserName"); 
		  			 	<%
		  			session.setAttribute("bookvalue","false");
		  			 	%>
		  		/* 	 	alert("firstname:"+name);   */
		  			
		  			
		  			}
	  			
	  			
	  			
	  			
	  			
	  			
	  			
	  			//alert("Inside second ready");
	  			$("#go").click(function(){
						 
						//alert("Go clicked");
						var startDate=$("#datepicker1").val();
						var endDate=$("#datepicker2").val();;
						var roomType;
						if ($('#lab').is(":checked") && $('#lab').is(":checked"))
						{
						  roomType="both";
						}
						else if ($('#lab').is(":checked") )
						{
						  roomType="lab";
						}
						else if ($('#softskill').is(":checked"))
						{
							 roomType="softskill";
						}
						else
							{
							 roomType="both";
							}
						
						//alert($("#locationSelect").val());
							var loc = $("#locationSelect").val();
							var  roomlist;
							
						
							
							
							
							
							
							
							
							
							
							
							
							
				  			 $.ajax(
								{
										type:"GET",
										url:"ajaxtable.jsp",
										datatype:"json",
										//data:{loc:$("#locationSelect").val()},
										data:{loc:loc,sDate:startDate,eDate:endDate,type:roomType},
										
										 
										success:function(data)
										{
											
											//$('#tablediv#1234').html(data).freezeHeader({'height':'300px'});
												$('#tablediv').html(data);			
												//$('#1234 tbody').css({"width":"100%","height":"400px","overflow":"auto", "margin":"0 auto" }); */
											
											
									},
									error:function(data,status,error)
									{
										alert(data[1]);
										alert("Error occured in ajax"+error+":"+status);
									}
								
							});
				  			
				  			 
				  		
				  			
				  			 
				  			 
				  			 
				  			 
				  			 
				  			 
				  			 
			 
		        	
		        }); 
					
	  			
	  		});
	  		</script>


						<div class="info-box">
							<!-- <div class="row-fluid stats-box"  > -->
							<!--  <div id="tbhead" style="width:100%;height:250px;overflow:auto;margin:0 auto;"></div> -->
							<!-- <div id="tablediv" style="width:100%;height:250px;overflow:auto;margin:0 auto;"></div> -->
							<div id="tablediv"
								style="width: 100%; height: 750px; margin: 0 auto; overflow: auto;">



								<!-- </div>     -->
							</div>
							<table>
								<tr>
									<td><font color="Red">*Please check room
											availability on DashBoard before proceeding to Book Room</font></td>
									<td width="50px" height="5px" class="c0"></td>
									<td>Available</td>
									<td width="50px" height="5px" class="c2"></td>
									<td>Partial</td>
									<td width="50px" height="5px" class="c1"></td>
									<td>Fully Booked</td>
								</tr>
							</table>
							<div class="widget-header">

								<button class="button btn btn-primary btn-large"
									onClick="window.location='book1.jsp';" id="book">Book
									Room</button>
								<a href="recurrenceForm.jsp"
									class="button btn btn-primary btn-large">Recurrence </a> <a
									href="viewbooking.jsp" target="_parent"><button
										class="button btn btn-primary btn-large" id="view">View
										My Bookings</button></a> <a href="viewbookingall.jsp" target="_parent"><button
										class="button btn btn-primary btn-large" id="view">View
										All Bookings</button></a>
							</div>
						</div>
					</div>


				</div>

				<!--  </div>
         </div>      
	      	 -->










			</div>
			<!-- /container -->

		</div>
		<!-- /main-inner -->

	</div>
	<!-- /main -->



	<!-- <script src="js/jquery-1.7.2.min.js"></script> -->
	<script src="js/excanvas.min.js"></script>
	<script src="js/chart.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/base.js"></script>


</body>

</html>


