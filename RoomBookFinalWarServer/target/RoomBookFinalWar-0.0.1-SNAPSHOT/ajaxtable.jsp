<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="java.text.ParseException"%>
<%@ page session="true"%>


<head>


</head>




<%
String loc=request.getParameter("loc");
final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
final String DB_URL = "jdbc:mysql://localhost:3306/rbcdatabase1";
List<String> list =new ArrayList<String>();





String dd="";
Connection conn = null;
Statement stmt = null;
Statement stmt1=null;
Statement stmt2=null;
try{
   //STEP 2: Register JDBC driver
   Class.forName("com.mysql.jdbc.Driver");
   Long userid= (Long)session.getAttribute("userid");
   //STEP 3: Open a connection
   System.out.println("Connecting to database...");
   conn = (Connection) DriverManager.getConnection(DB_URL,"root","root");
String loc1=request.getParameter("loc");
   //STEP 4: Execute a query
   System.out.println("Creating statement...");
   stmt = (Statement) conn.createStatement();
   stmt1 = (Statement) conn.createStatement();
   stmt2=(Statement) conn.createStatement();
   String sql;
   sql = "SELECT room_id,room_name,capacity from room_table where location='"+loc1+"'";
   
 //  String startDate="2014-11-10";
  // String endDate="2014-11-15";
   
  String startDate=request.getParameter("sDate");
  String endDate=request.getParameter("eDate");
  SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");	
  SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy");	
   List<Long> listid=new ArrayList<Long>();
   
	Date sDate = null;
	Date eDate = null;
	try {
		
		 sDate = format.parse(startDate);
		 eDate = format.parse(endDate);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}

   ResultSet rs = stmt.executeQuery(sql);
   ResultSet rs1=null;
   ResultSet rs2=null;
   ResultSet rs3=null;
   //STEP 5: Extract data from result set
   
   Calendar start = Calendar.getInstance();
	start.setTime(sDate);
	
	Calendar end = Calendar.getInstance();
	end.setTime(eDate);
	
	

	//start time and end time same, so cannot book room
	
	
	

   
   
   
   
   
   
   
   
   
 
  
   
/* dd+="<table id=1234 class=\"CSSTableGenerator\" style=\"width:100%;\"><thead><tr><th>Day</th><th>Date</th>"; */
 dd+="<table id=1234 class=\"CSSTableGenerator\" style=\"width:100%;\"><thead ><tr><th>Day</th><th>Date</th>"; 
/* dd+="<thead ><tr><th>Day</th><th>Date</th>"; */
  




 int i=0;
   while(rs.next()){
      //Retrieve by column name
	
	listid.add(rs.getLong(1));
	
  
  
 dd+="<th>"+rs.getString(2)+"("+rs.getString(3)+")"+"</th>";
               
     
   
      
	i++;
	  
       
       System.out.println("dd");
   }



dd+="</tr></thead><tbody>";

while( !start.after(end)){		

		
	    Date targetDay = start.getTime();
	   String temp=format.format(targetDay);
	  String temp1=format1.format(targetDay);
	   System.out.print(temp);
	   Date sqldate=format.parse(temp); 
	   String dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(sqldate);

	   System.out.println("target day is -- " + targetDay);
	    // Do Work Here
	    dd+="<tr><td>"+dayOfWeek+"</td><td>"+temp1+"</td>";




		System.out.print("Hiii"); 
System.out.print(listid.size());
System.out.print(listid.toString()); 
int z,k;
        for(int j=0;j<i;j++)
         {
        	 System.out.print("hi..");
          	 System.out.print("hi..");
        	String sql1="select status from status_table where date='"+temp+"'and room_id='"+listid.get(j)+"'";
        	String sql3="select room_name from room_table where room_id='"+listid.get(j)+"'";
        	 rs1=stmt.executeQuery(sql1);
        	 rs3=stmt2.executeQuery(sql3);
        	System.out.print(sql1);
        	
        	z=0;
        	k=0;
        	String thover="temp";
        	while(rs1.next()&& k==0)
        	{
        		/* Long g=rs1.getLong("status");
        		if(g!=1 && g!=2)
        		{
        			i++;
        			out.print("<td>0</td>");
        		} */
        	//	else
        		//{
        		z++;
        		k++;
         
        		String sql2="select training_type,start_time,end_time,owner_name,training_name from training_table where start_date<='"+temp+"'and end_date>='"+temp+"' and room_id="+listid.get(j);
  
        		rs2=stmt1.executeQuery(sql2);
        	    thover="";
        		while(rs2.next())
        		{
        			 thover+=" OwnerName : "+rs2.getString("owner_name")+"&#13 Duration : "+rs2.getString("start_time")+" to "+rs2.getString("end_time")+"&#13 TrainingType : "+rs2.getString("training_type")+"&#13 Training Name : "+rs2.getString("training_name")+"&#13&#13";
        					
        		}
        		
        		
        		   		String tt="c"+rs1.getLong("status");
dd+="<td class=\""+tt+"\" title=\""+thover+"\"></td>";
  
  
  


        	//	}
        	}
        if(z==0)
        {
        	String gg="";
        	while(rs3.next())
        	{
        		gg=gg+rs3.getString("room_name");
        	}
        	dd+="<td class=\"c0\" title=\""+gg+"\"></td>";
        } 
        	
 
 
     	
        System.out.print("out....");	
        	}
dd+="</tr>";

			start.add(Calendar.DATE, 1);
		}


dd+="</tbody></table>";


   //STEP 6: Clean-up environment
   //rs2.close();

   rs1.close();
   rs2.close();
   rs.close();
   rs3.close();
   stmt.close();
   stmt2.close();
   stmt1.close();
   conn.close();
}catch(SQLException se){
   //Handle errors for JDBC
   se.printStackTrace();
}catch(Exception e){
   //Handle errors for Class.forName
   e.printStackTrace();
}finally{
   //finally block used to close resources
   try{
      if(stmt!=null)
         stmt.close();
   }catch(SQLException se2){
   }// nothing we can do
   try{
      if(conn!=null)
         conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }//end finally try
}//end try
System.out.println("Goodbye!");
//PrintWriter out=response.getWriter();
out.print(dd);


//end main


















%>




</div>
<!-- /login-fields -->

<div class="login-actions"></div>
<!-- .actions -->






</div>
<!-- /content -->

</div>
<!-- /account-container -->


<!-- Text Under Box -->


<script src="js/jquery-1.7.2.min.js"></script>
<script src="js/bootstrap.js"></script>

<script src="js/signin.js"></script>

</body>























