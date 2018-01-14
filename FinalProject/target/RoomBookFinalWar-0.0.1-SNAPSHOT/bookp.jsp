<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  
 <head>
    <meta charset="utf-8">
    <title>Booking Form - Room Booking Calendar</title>

	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="apple-mobile-web-app-capable" content="yes"> 
    
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />

<link href="css/font-awesome.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet">
    
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/pages/book.css" rel="stylesheet" type="text/css">
 <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">

 $(document).ready(function () {

	 
 $.ajax(
				{
					type:"GET",
							url:"display_location.jsp",
							data:{loc:$(this).val()},
										
						
							 
							success:function(data)
							{
								//alert('huuuuui');
								$('#location').html(data);
						
								
								/* for(var i=0;i<data.length;i++)
									{
									alert(data[i]);
									$("#roomid").append("<option>"+data[i]+"</option>");
									} */
				 		
						},
						error:function(data,status,error)
						{
							//alert('hi');
							alert(data[1]);
							alert("Error occured in ajax"+error+":"+status);
						}
					
				}); 
	 
	 
	$('select#location').change(function(event) {
	//	alert($(this).val());
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
									alert('hi');
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

 

</script>


</head>

<body>
	
	<div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</a>
			
			<a class="brand" href="adminUser.jsp">
				Room Booking Calendar				
			</a>		
			
			<div class="nav-collapse">
				<ul class="nav pull-right">
					
					<li class="">						
						<a href="adminUser.jsp" class="">
							<i class="icon-chevron-left"></i>
							Back to Homepage
						</a>
						
					</li>
				</ul>
				
			</div><!--/.nav-collapse -->	
	
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->



<div class="account-container register"  align="center" style="border: medium;">
	
<div class="content clearfix">

	
<form action="BookRoomController"  method="post">		

		
<div class="login-fields">		
		
		
<h1>Book Room</h1>			
			
			
<%

Long userid=(Long)session.getAttribute("userid");
String firstname=(String)session.getAttribute("firstname");

%>			
	
<div class="field">


<label for="emp_id">User Id </label><input type="text" id="emp_id" value="<%=userid%>" name="employeeid" />
</div>		
			
		
<div class="field">


<label for="emp_id">Owner Name  </label><input type="text" id="emp_id" name="empName" value="<%=firstname%>" />
</div>		
		
		
	
<div class="field">
<label for="room_id">Location Name  </label><select name="location" id="location">
<option>Select Location</option>
<option>HJ</option>
<option>PT</option>
</select>
</div>			
		

<div class="field">
<label for="roomid">Room Name </label><select name="roomName" id="roomid">



</select>
</div>			
	

<div class="field">
<label for="start_date">Start Date </label><input type="date" id="start_date" name="sDate">
</div>
<div class="field">
<label for="end_date">End Date </label><input type="date" id="end_date" name="eDate">
</div>
<div class="field">
<label for="training_type" >Training Type</label>
</div>
<div class="field">
<select name="training_type">
	<option>ELTP</option>
	<option>RBT</option>
	<option>SLT</option>
</select>
</div>
<div class="field">
<label for="start_time">Start Time </label>
<input type=time name="start_time" min=9:00 max=19:00 step=900>
</div>
<div class="field">
<label for="end_time">End Time </label><input type="time" name="end_time" min=9:00 max=19:00 step=900>
</div>


		
				
				
			</div> <!-- /login-fields -->
			
			<div class="login-actions">
				
													
				<button class="button btn btn-primary btn-large">Register</button>
				
			</div> <!-- .actions -->
			
			
		</form>
		
		
		
		
	</div> <!-- /content -->
	
</div> <!-- /account-container -->


<!-- Text Under Box -->


<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>

</body>

 </html>
     --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>Booking Form - Room Booking Calendar</title>

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
<link href="css/pages/book.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="sweet-alert.css">
<script src="js/sweet-alert.min.js"></script>


<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">


	 $(document).ready(function () {
		 
		 Date.prototype.toDateInputValue = (function() {
			    var local = new Date(this);
			    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
			    return local.toJSON().slice(0,10);
			});
		 if(<%=request.getAttribute("booked")%>==false)
			{
			 sweetAlertInitialize();
			 sweetAlert("Oops...!", "Timing & dates are clashing.\nCheck the dashboard for status and availability");
			 	/* alert("Booking cannot be done..!!\nTiming & dates are clashing.\nCheck the dashboard for status");  */
		/* 	 	alert("firstname:"+name);   */
					
			}
		 
		 
		 $('#start_date').prop("min",new Date().toDateInputValue());	
		 
			//alert("Inside onload");
		 //Check date and time ranges conditions
		 $("#start_date").blur(function (){
				//alert($("#start_date").val());
				$("#end_date").prop("min",$("#start_date").val());
				//alert($("#end_date"));
			});

		 $("[name=start_time]").blur(function(){
			//	alert($("[name=start_time]").val());
				var temp=$("[name=start_time]").val();
				//alert(temp);
				$("[name=end_time]").prop("min",temp);
				//alert($("[name=end_time]"));
		 });
		 
		 
		 
		 
		 //fullday checkbox code
				
					
					$("#fullDay").click(function() {
		
					if($(this).is(':checked'))
					{
						//alert("inside checked");
								 $("[name=start_time]").val("09:00");  // checked
								$("[name=start_time]").attr("readonly", "true");
								$("[name=end_time]").val("18:00");  // checked
								$("[name=end_time]").attr("readonly", "true");
								//$("#checkbox1").attr("disabled", "disabled");
					}
				else
					{
					//alert("inside UNchecked");
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
		 
	 
 $.ajax(
				{
					type:"GET",
							url:"display_location.jsp",
							data:{loc:$(this).val()},
										
						
							 
							success:function(data)
							{
								//alert('hi');
								$('#location').html(data);
						
								
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
	 
	 
	$('select#location').change(function(event) {
	//	alert($(this).val());
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

 

</script>


</head>

<body>

	<div class="navbar navbar-fixed-top">

		<div class="navbar-inner">

			<div class="container">

				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="adminUser.jsp"> Room Booking Calendar </a>

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

		</div>
		<!-- /navbar-inner -->

	</div>
	<!-- /navbar -->

	<div style="width: 50px; height: 50px;"></div>

	<div class="account-container register" align="center">

		<div class="content clearfix"
			style="width: 380px; height: 650px; border: solid">


			<form action="BookRoomController" method="post">


				<div class="login-fields">


					<h1>Book Room</h1>
					<br> <br>
					<%

Long userid=(Long)session.getAttribute("userid");
String firstname=(String)session.getAttribute("firstname");

%>
					<table>
						<tr>

							<td><label for="emp_id">User Id </label></td>
							<td><input type="text" id="emp_id" value="<%=userid%>"
								name="employeeid" required /></td>
						</tr>

						<tr>
							<td><label for="emp_id">Owner Name </label></td>
							<td><input type="text" id="emp_id" name="empName"
								value="<%=firstname%>" required /></td>
						</tr>


						<tr>
							<td><label for="room_id">Location Name </label></td>
							<td><select name="location" id="location" required>
							</select></td>
						</tr>


						<tr>
							<td><label for="roomid">Room Name </label></td>
							<td><select name="roomName" id="roomid" required>



							</select></td>
						</tr>


						<tr>
							<td><label for="start_date">Start Date </label></td>
							<td><input type="date" id="start_date" name="sDate" required></td>
						</tr>
						<tr>
							<td><label for="end_date">End Date </label></td>
							<td><input type="date" id="end_date" name="eDate" required></td>
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
							<td>Full Day Booking</td>
							<td><input type="checkbox" id="fullDay" checked="checked"></td>
						</tr>
						<tr>
							<td><label for="start_time">Start Time </label></td>
							<td><input type=time id="timeStart" name="start_time"
								min=9:00 max=19:00 step=900 required></td>
						</tr>
						<tr>
							<td><label for="end_time">End Time </label></td>
							<td><input type="time" id="timeEnd" name="end_time" min=9:00
								max=19:00 step=900 required></td>
						</tr>
					</table>




				</div>
				<!-- /login-fields -->

				<div class="login-actions">


					<br> <br>
					<button class="button btn btn-primary btn-large">Book</button>



				</div>
				<!-- .actions -->


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



