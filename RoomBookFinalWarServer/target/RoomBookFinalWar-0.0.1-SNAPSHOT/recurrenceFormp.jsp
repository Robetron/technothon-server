<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

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
<link rel="stylesheet" type="text/css" href="sweet-alert.css">
<script src="js/sweet-alert.min.js"></script>


<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	/* $("#start").datepicker();
	$("#end").datepicker(); */
	//$("#occurrences").attr("disabled", "disabled");
	Date.prototype.toDateInputValue = (function() {
	    var local = new Date(this);
	    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
	    return local.toJSON().slice(0,10);
	});
	  if(<%=request.getAttribute("booked")%>==false)
		{
		  sweetAlertInitialize();
			 sweetAlert("Oops...!", "Timing & dates are clashing.\nCheck the dashboard for status and availability");
		 	/* alert("Booking cannot be done..!!\nTiming & dates are clashing.\nCheck the dashboard for status"); */ 
	
				
		}  
	  $('#start').prop("min",new Date().toDateInputValue());	
	 
	 /* $("#endBy").click(function(){
		 if($('#endBy').is(':checked')) {
			 alert("Radio ON");
			 $("#end").attr("readonly", "false");
			 
		 }else
			 {
			 alert("Radio OFF");
			 $("#end").attr("readonly", "true");
			 }
		 
		 
	 }); */
	 
	 $("#fullDay").click(function() {
			
			if($(this).is(':checked'))
			{
	//			alert("inside checked");
						 $("[name=stime]").val("09:00");  // checked
						$("[name=stime]").attr("readonly", "true");
						$("[name=etime]").val("18:00");  // checked
						$("[name=etime]").attr("readonly", "true");
						//$("#checkbox1").attr("disabled", "disabled");
			}
		else
			{
		//	alert("inside UNchecked");
			$("[name=stime]").removeAttr("readonly");
			$("[name=etime]").removeAttr("readonly");
			}
			});
			
			if($("#fullDay").is(':checked'))
			{
			//alert("Is checked function");
						 
						$("[name=stime]").attr("readonly", "true");
						$("[name=stime]").val("09:00");  // checked
						
						$("[name=etime]").attr("readonly", "true");
						$("[name=etime]").val("18:00");  // checked
						
						//$("#checkbox1").attr("disabled", "disabled");
			}
		else
			{
			$("[name=stime]").removeAttr("readonly");
			$("[name=etime]").removeAttr("readonly");
			}
//end of code for fuulday
	 
	 
	 
	 $(":radio").click(function () {
		 
	// alert("Inside Radio click");
		    var inputValue = $(this).val();
		    
		    if(inputValue!="End by")
		    	{
		    //	alert("input"+inputValue);
		    	
		    	$("#end").attr("disabled", "disabled");
		    	}
		    else if(inputValue=="End after"){
		    	
		    	$("#occurrences").removeAttr("disabled");
		    }
		    else
		    	{
		  //  	alert("input"+inputValue);
		    	$("#end").removeAttr("disabled");;
		    	
		    	}
	 });
	 
		//alert("Inside onload");
	 //Check date and time ranges conditions
	 $("#start").blur(function (){
//			alert($("#start_date").val());
			$("#end").prop("min",$("#start").val());
//			alert($("#end_date"));
		});

	 $("#starttime").blur(function(){
		//	alert($("[name=start_time]").val());
			var temp=$("#starttime").val();
	//		alert(temp);
			$("#endtime").prop("min",temp);
			//alert($("[name=end_time]"));
	 });
	 
	 
	 
	/*  
	 //fullday checkbox code
			
				
				$("#fullDay").click(function() {
	
				if($(this).is(':checked'))
				{
		//			alert("inside checked");
							 $("#starttime").val("09:00");  // checked
							$("#starttime").attr("readonly", "true");
							$("#endtime]").val("18:00");  // checked
							$("#endtime").attr("readonly", "true");
							//$("#checkbox1").attr("disabled", "disabled");
				}
			else
				{
			//	alert("inside UNchecked");
				$("[name=start_time]").removeAttr("readonly");
				$("[name=end_time]").removeAttr("readonly");
				}
				});
				
				if($("#fullDay").is(':checked'))
				{
				//alert("Is checked function");
							 
							$("[name=start_time]").attr("readonly", "true");
							$("[name=start_time]").val("09:00");  // checked
							
							$("[name=end_time]").attr("readonly", "true");
							$("[name=end_time]").val("18:00");  // checked
							
							//$("#checkbox1").attr("disabled", "disabled");
				}
			else
				{
				$("[name=start_time]").removeAttr("readonly");
				$("[name=end_time]").removeAttr("readonly");
				}
 */
	
	
	getLocation();
	$('select#location').change(function(event) {
		//alert($(this).val());
        var loc = $(this).val();
        /* $.getJSON('display_room.jsp',{selectlocation: $(this).val(), ajax: 'true'}, function() {
         alert('hi');
        var select1 = $('select#roomid');
       // select1.find('option').remove();
          $.each(response, function(index, value) {
          $('<option>').val(value).text(value).appendTo(select1);
      });
        }); */
        
    
        
   $.ajax(
					{
						type:"GET",
								url:"display_room.jsp",
								
								data:{loc:$(this).val()},
								
							
								 
								success:function(data)
								{
									//alert('hi');
									$('#roomid').html(data);
								
									
									
									/* for(var i=0;i<data.length;i++)
										{
										alert(data[i]);
										$("#roomid").append("<option>"+data[i]+"</option>");
										} */
									
					 	},
							error:function(data,status,error)
							{
								alert(data[1]);
								alert("Error occured in ajax"+error+":"+status);
							}
						
					});

        });
    

}); 

function getLocation()
{/* 
	 $.ajax({
		 
		 url:"demo_test.txt",
		 success:function(result){
	    		$("#div1").html(result);}
	 }
	 ); */
	//alert("In get Location");
	$.ajax(
	{
		type:"GET",
				url:"display_location.jsp",
				
				
				 
				success:function(data)
				{
					
					$('#location').html(data);
					
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
				</a> <a class="brand" href="index.html"> Room Booking Calendar </a>

				<div class="nav-collapse">
					<ul class="nav pull-right">

						<li class=""><a href="applicationUser.jsp" class=""> <i
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
			<form action="ReccurrenceController" method="post">
				<table>
					<tr>
						<td>Location Name</td>
						<td><select name="location" id="location">

						</select></td>
					</tr>
					<tr>
						<td><label for="roomid">Room Name </label></td>
						<td><select name="roomid" id="roomid">


						</select></td>
					</tr>
					<tr>
						<td><label for="training_type">Training Type</label></td>
						<td><select name="training_type">
								<option>ELTP</option>
								<option>RBT</option>
								<option>SLT</option>
						</select></td>
					</tr>
					<tr>
						<td><label for="training_name">Training Name </label></td>
						<td><input type="text" id="training_name"
							name="training_name" required></td>
					</tr>

					<tr>
						<td>
							<p>
								<b>Appointment time:</b>
							</p>
						</td>
					</tr>
					<tr>
						<td>Full Day Booking</td>
						<td><input type="checkbox" id="fullDay" checked="checked"></td>
					</tr>
					<tr>
						<td>
							<h3>StartTime</h3>
						</td>
						<td><input type="time" id="starttime" name="stime" required></td>
					</tr>
					<tr>
						<td><h3>EndTime</h3></td>
						<td><input type="time" id="endtime" name="etime" required></td>
					</tr>
				</table>
				<!-- 	<h3>Duration</h3>	<input type="text" id="duration"> -->
				<p>
				<h3>Recurrence pattern</h3>
				</p>
				<table id="recurrence">
					<tr>
						<td>

							<div class="recur">
								<table id="numOfRecur">
									<!-- 	  						<tr><td><b>Daily  </b></td><td><input type="radio" name="recur" value="Daily"></td></tr>
 -->
									<tr>
										<td><b>Weekly</b></td>
										<td><input type="radio" name="recur" value="Weekly"
											required></td>
									</tr>
									<tr>
										<td><b>Monthly</b></td>
										<td><input type="radio" name="recur" value="Monthly"
											required></td>
									</tr>
									<!-- 	  						<tr><td><b>Yearly  </b></td><td><input type="radio" name="recur" value="Yearly"></td></tr>	
 -->
								</table>
							</div>
						</td>


						<!-- <td>
	  							<div class="days">
	  							<table id="days">
	  								<tr><td><b>Monday</b></td><td><input type="checkbox" value="Monday" name="day" ></td></tr>
	  								<tr><td><b>Tuesday</b></td><td><input type="checkbox" value="Tuesday" name="day"></td></tr>
	  								<tr><td><b>Wednesday</b></td><td><input type="checkbox" value="Wednesday" name="day"></td></tr>
	  								<tr><td><b>Thursday</b></td><td><input type="checkbox" value="Thursday" name="day"></td></tr>
	  								<tr><td><b>Friday</b></td><td><input type="checkbox" value="Friday" name="day"></td></tr>
	  								<tr><td><b>Saturday</b></td><td><input type="checkbox" value="Saturday" name="day"></td></tr>
	  								<tr><td><b>Sunday</b></td><td><input type="checkbox" value="Sunday" name="day"></td></tr>
	  							</table>
	  							</div>
	  						</td> -->
					</tr>
				</table>

				<h3>Range of Recurrence</h3>
				<table>

					<tr>
						<td><b>Start : </b><input id="start" type="date"
							style="width: 120px" name="sdate" required></td>
					</tr>
					<tr>
						<td><input type="radio" name="range" value="No end date"
							required><b>No end date</b></td>
					</tr>
					<tr>
						<td><input type="radio" name="range" value="End after"
							required><b>End after : </b><input type="number"
							id="occurrences" style="width: 50px" name="count" min="1"
							value="1"> Occurrences</td>
					</tr>
					<tr>
						<td><input id="endBy" type="radio" name="range"
							value="End by" required><b>End by :</b><input type="date"
							id="end" style="width: 120px" name="edate"></td>
					</tr>

				</table>
				<button class="button btn btn-primary btn-large"
					style="float: center;" name="click" value="OK">OK</button>
				<a href="applicationUser.jsp"
					class="button btn btn-primary btn-large" style="float: center;">Cancel</a>

			</form>


		</div>
		<!-- /content -->

	</div>
	<!-- /account-container -->


	<!-- Text Under Box -->


	<script src="js/jquery-1.7.2.min.js"></script>
	<script src="js/bootstrap.js"></script>

	<script src="js/signin.js"></script>

</body>

</html>
