<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.psl.entity.*"%>
<%@ page import="com.psl.dao.*"%>

<%    
    
String loc=request.getParameter("loc");
String temp=loc.trim();
System.out.println(loc);
//char c=loc.charAt(0);
System.out.println(temp);//"src/com/psl/dao/TrainingDetailsDao.java"
Long id=Long.parseLong(temp);

System.out.println(id);
TrainingDetailsDao dao=new TrainingDetailsDao();
StatusDao st=new StatusDao();
dao.deleteTrainingDetails(id);
st.deletStatus(id);


%>