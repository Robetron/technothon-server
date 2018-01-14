package com.psl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.psl.entity.User;
import com.psl.service.UserService;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        userService = new UserService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
/*		PrintWriter out=response.getWriter();*/
		
		System.out.println(" in dopost method");
		//UserDao userDao = new UserDao();
	/*	Long userid =Long.parseLong(request.getParameter("userid"));*/
		String firstname = request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
	/*	String designation = request.getParameter("designation");*/
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		String usertype = request.getParameter("usertype");
		User user = new User();
		
		
		/*user.setEmployeeID(userid);*/
		user.setEmployeeFirstName(firstname);
	/*	user.setDesignation(designation);*/
		user.setEmployeeLastName(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setUserType(usertype);
		System.out.println("hhhhhhhhhhhh");
		
		boolean inserted=userService.addUser(user);
	
		if(inserted==false)
		{
			System.out.println("inside inserted=false");
			request.setAttribute("inserted",inserted);
			request.setAttribute("firstname",firstname);
			request.setAttribute("lastname",lastname);
			
			RequestDispatcher rd1=request.getRequestDispatcher("addUser.jsp");             		        		 
	      	rd1.forward(request, response);
		}
		else
		{
	/*	request.setAttribute("inserted",inserted);
		RequestDispatcher rd1=request.getRequestDispatcher("adminUser.jsp");             		        		 
      	rd1.forward(request, response);	*/
			response.sendRedirect("adminUser.jsp");
		}
		
		
		
	}

}
