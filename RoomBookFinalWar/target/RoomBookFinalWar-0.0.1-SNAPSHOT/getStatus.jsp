<%@ page import="com.psl.entity.* "%>
<%@ page import="com.psl.dao.* "%>
<%@ page import="java.util.* "%>
<%@ page import="java.text.* "%>
<%@ page import="java.util.*"%>

<%
RoomDao roomDao=new RoomDao();
StatusDao statusDao=new StatusDao();
BookingDao bookingDao=new BookingDao();

String location=request.getParameter("location");
//String startDate=request.getParameter("startDate");

//String endDate=request.getParameter("endDate");
String roomType=request.getParameter("roomType");
Map<Date,StatusValue> map=new HashMap<Date, StatusValue>();
List<Map<Date, StatusValue>> mapList=new ArrayList<Map<Date,StatusValue>>();
List<Room> roomList=roomDao.getRoomByLocation(location);
SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");

try {
	/* Date sDate=format.parse(startDate);
	Date eDate=format.parse(endDate); */
	Date sDate=new Date();
	Date eDate=new Date();

	for (Room room : roomList) {
		System.out.println("Room:"+room);
	mapList.add(statusDao.getStatus(room.getRoomID(), sDate, eDate));
	}
	
	
	

} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	



//code to send data to REPORTS.HTML



List<Training> trainingList=new ArrayList<Training>();
Map<Room, List<Long>> roomTrainingMap=new HashMap<Room, List<Long>>();
for (Room room : roomList) {
	//Edit with  bokingDao 
	roomTrainingMap.put(room, bookingDao.getTrainingIDList(room.getRoomID()));
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
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<!-- <script type="text/javascript" src="jquery-1.11.1.js"></script> -->
<link href="css/pages/reports.css" rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->



<script type="text/javascript">
	  					$(function() {
	  					    
	  						$("#datepicker1").datepicker();
	  						$("#datepicker2").datepicker();
	  						
	  						$("#go").click(function(){
	  							alert(<%=roomList.size()%>);
	  							$("#statusTable").append();
	  							
	  							
	  						});
	  						getLocation();
	  					  });
	  					
	  					function getLocation()
	  					{/* 
	  						 $.ajax({
	  							 
	  							 url:"demo_test.txt",
	  							 success:function(result){
	  						    		$("#div1").html(result);}
	  						 }
	  						 ); */
	  						alert("In get Location");
	  						$.ajax(
	  						{
	  							type:"POST",
	  									url:"GetLocation",
	  									
	  									dataType:"JSON" ,
	  									 
	  									success:function(data)
	  									{
	  										
	  										for(var i=0;i<data.length;i++)
	  											{
	  											alert(data[i]);
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
	  				
	  					
									  					   
	  					   //We get both data1 and data2 from the array
	  					   /* $("h3#name").text(data1["name"]); 
	  					   $("span#level").text(data1["level"]); 
	  					   $("span#college").text(data2["college"]); 
	  					   $("span#department").text(data2["department"]) ;*/
	  					
	  					
	  					</script>

</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="index.html"> Room Booking Calendar </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="icon-user"></i> Log Out <b
								class="caret"></b>
						</a> <!-- <ul class="dropdown-menu">
							<li><a href="javascript:;">Settings</a></li>
							<li><a href="javascript:;">Help</a></li>
						</ul> --></li>

						<!-- <li class="dropdown">						
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<i class="icon-user"></i> 
							EGrappler.com
							<b class="caret"></b>
						</a>
						
						<ul class="dropdown-menu">
							<li><a href="javascript:;">Profile</a></li>
							<li><a href="javascript:;">Logout</a></li>
						</ul>						
					</li> -->
					</ul>

					<!-- 	<form class="navbar-search pull-right">
					<input type="text" class="search-query" placeholder="Search">
				</form> -->

				</div>
				<!--/.nav-collapse -->

			</div>
			<!-- /container -->

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->





	<div class="subnavbar">

		<div class="subnavbar-inner">

			<div class="container">

				<ul class="mainnav">

					<li><a href="applicationUser.jsp"> <i
							class="icon-dashboard"></i> <span>Dashboard</span>
					</a></li>



					<li class="active"><a href="reports.html"> <i
							class="icon-list-alt"></i> <span>Reports</span>
					</a></li>

					<li><a href="guidely.html"> <i class="icon-facetime-video"></i>
							<span>App Tour</span>
					</a></li>


					<li><a href="charts.html"> <i class="icon-bar-chart"></i>
							<span>Charts</span>
					</a></li>


					<li><a href="shortcodes.html"> <i class="icon-code"></i> <span>Shortcodes</span>
					</a></li>

					<li class="dropdown"><a href="javascript:;"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="icon-long-arrow-down"></i> <span>Drops</span> <b
							class="caret"></b>
					</a>

						<ul class="dropdown-menu">
							<li><a href="icons.html">Icons</a></li>
							<li><a href="faq.html">FAQ</a></li>
							<li><a href="pricing.html">Pricing Plans</a></li>
							<li><a href="login.html">Login</a></li>
							<li><a href="signup.html">Signup</a></li>
							<li><a href="error.html">404</a></li>
						</ul></li>

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
							<i class="icon-user"></i>
							<h3>&nbsp; Select Location</h3>
							<select id="locationSelect">
							</select>
							<h3>Start Date</h3>
							<input type="text" id="datepicker1">
							<h3>End Date</h3>
							<input type="text" id="datepicker2"> <input type="submit"
								id="go">
							<!-- <button id="go">Go</button> -->

						</div>

						<div class="info-box">
							<div class="row-fluid stats-box">
								<table id="statusTable" style="">


								</table>



							</div>
						</div>


					</div>

				</div>
			</div>

			<!-- /row -->

			<!--  <div class="row">
	      	
	      	<div class="span6">
	      		
	      		<div class="widget">
						
					<div class="widget-header">
						<i class="icon-star"></i>
						<h3>Some Stats</h3>
					</div> /widget-header
					
					<div class="widget-content">
						<canvas id="pie-chart" class="chart-holder" height="250" width="538"></canvas>
					</div> /widget-content
						
				</div> /widget
				
	      		
	      		
	      		
		    </div>  -->
			<!-- /span6
	      	
	      	
	      	<div class="span6">
	      		
	      		<div class="widget">
							
					<div class="widget-header">
						<i class="icon-list-alt"></i>
						<h3>Another Chart</h3>
					</div> /widget-header
					
					<div class="widget-content">
						<canvas id="bar-chart" class="chart-holder" height="250" width="538"></canvas>
					</div> /widget-content
				
				</div> /widget
									
		      </div>  -->
			<!-- /span6
	      	
	      </div> -->
			<!-- /row -->







		</div>
		<!-- /container -->

	</div>
	<!-- /main-inner -->

	</div>
	<!-- /main -->



	<!-- 
 <div class="extra">

	<div class="extra-inner">

		<div class="container">

			<div class="row">
                    <div class="span3">
                        <h4>
                            About Free Admin Template</h4>
                        <ul>
                            <li><a href="javascript:;">EGrappler.com</a></li>
                            <li><a href="javascript:;">Web Development Resources</a></li>
                            <li><a href="javascript:;">Responsive HTML5 Portfolio Templates</a></li>
                            <li><a href="javascript:;">Free Resources and Scripts</a></li>
                        </ul>
                    </div>
                    /span3
                    <div class="span3">
                        <h4>
                            Support</h4>
                        <ul>
                            <li><a href="javascript:;">Frequently Asked Questions</a></li>
                            <li><a href="javascript:;">Ask a Question</a></li>
                            <li><a href="javascript:;">Video Tutorial</a></li>
                            <li><a href="javascript:;">Feedback</a></li>
                        </ul>
                    </div>
                    /span3
                    <div class="span3">
                        <h4>
                            Something Legal</h4>
                        <ul>
                            <li><a href="javascript:;">Read License</a></li>
                            <li><a href="javascript:;">Terms of Use</a></li>
                            <li><a href="javascript:;">Privacy Policy</a></li>
                        </ul>
                    </div>
                    /span3
                    <div class="span3">
                        <h4>
                            Open Source jQuery Plugins</h4>
                        <ul>
                            <li><a href="http://www.egrappler.com">Open Source jQuery Plugins</a></li>
                            <li><a href="http://www.egrappler.com;">HTML5 Responsive Tempaltes</a></li>
                            <li><a href="http://www.egrappler.com;">Free Contact Form Plugin</a></li>
                            <li><a href="http://www.egrappler.com;">Flat UI PSD</a></li>
                        </ul>
                    </div>
                    /span3
                </div> /row

		</div> /container

	</div> /extra-inner

</div> /extra

 -->
	<!--   
    
 <div class="footer"> 
	
	<div class="footer-inner">
		
		<div class="container">
			
			<div class="row">
				
    			<div class="span12">
    				&copy; 2013 <a href="http://www.egrappler.com/">Bootstrap Responsive Admin Template</a>.
    			</div> /span12
    			
    		</div> <!-- /row
    		
		</div> /container
		
	</div> /footer-inner
	
</div> /footer
 
 -->
	<!-- <script src="js/jquery-1.7.2.min.js"></script> -->
	<script src="js/excanvas.min.js"></script>
	<script src="js/chart.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js"></script>
	<script src="js/base.js"></script>
	<!-- <script>

    var pieData = [
				{
				    value: 30,
				    color: "#F38630"
				},
				{
				    value: 50,
				    color: "#E0E4CC"
				},
				{
				    value: 100,
				    color: "#69D2E7"
				}

			];

    var myPie = new Chart(document.getElementById("pie-chart").getContext("2d")).Pie(pieData);

    var barChartData = {
        labels: ["January", "February", "March", "April", "May", "June", "July"],
        datasets: [
				{
				    fillColor: "rgba(220,220,220,0.5)",
				    strokeColor: "rgba(220,220,220,1)",
				    data: [65, 59, 90, 81, 56, 55, 40]
				},
				{
				    fillColor: "rgba(151,187,205,0.5)",
				    strokeColor: "rgba(151,187,205,1)",
				    data: [28, 48, 40, 19, 96, 27, 100]
				}
			]

    }

    var myLine = new Chart(document.getElementById("bar-chart").getContext("2d")).Bar(barChartData);
	var myLine = new Chart(document.getElementById("bar-chart1").getContext("2d")).Bar(barChartData);
	var myLine = new Chart(document.getElementById("bar-chart2").getContext("2d")).Bar(barChartData);
	var myLine = new Chart(document.getElementById("bar-chart3").getContext("2d")).Bar(barChartData);
	
	</script> -->


</body>

</html>






<%
	
							/* function drawTable(data)
							{
								for(var i=0;i<data.length;i++)
									drawRow(data[i]);
								
							}
							function drawRow(rowData) {
							    var row = $("<tr />")
							    $("#locationSelect").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
							    row.append($("<td>" + rowData.id + "</td>"));
							    row.append($("<td>" + rowData.firstName + "</td>"));
							    row.append($("<td>" + rowData.lastName + "</td>"));
							}
	  							 */
							
/* 							function drawTable(data) {
							    for (var i = 0; i < data.length; i++) {
							        drawRow(data[i]);
							    }
							}

							function drawRow(rowData) {
							    var row = $("<tr />")
							    $("#personDataTable").append(row); //this will append tr element to table... keep its reference for a while since we will add cels into it
							    row.append($("<td>" + rowData.id + "</td>"));
							    row.append($("<td>" + rowData.firstName + "</td>"));
							    row.append($("<td>" + rowData.lastName + "</td>"));
							} 
	  						
	  						
	  						//$("#locationSelect").append("<option>Hinjewadi</option>");
	  					}
	*/
	  					
	  					 %>