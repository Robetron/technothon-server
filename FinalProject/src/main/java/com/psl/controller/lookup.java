package com.psl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.psl.dao.LocationDao;
import com.psl.dao.UserDao;
import com.psl.service.UserService;

/**
 * Servlet implementation class lookup
 */
public class lookup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LocationDao locationDao;

	UserService userService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public lookup() {
		super();
		locationDao = new LocationDao();
		userService = new UserService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// UserDao checkuser=new UserDao();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String ch = userService.authenticateUser(username, password);
		HttpSession session = request.getSession();

		if (ch == null) {
			response.sendRedirect("login.html");
		} else {
			String data[] = ch.split(" ");
			String usertype = data[0];
			String firstname = data[1];
			long userid = Integer.parseInt(data[2]);

			session.setAttribute("usertype", usertype);
			session.setAttribute("firstname", firstname);
			session.setAttribute("userid", userid);

			System.out.println(userid + usertype + firstname);
			if (usertype.equals("Administrator")) {
				System.out.println("in administrator");
				RequestDispatcher rd1 = request.getRequestDispatcher("adminUser.jsp");
				rd1.forward(request, response);

			}

			else if (usertype.equals("Application")) {
				System.out.println("in application");
				RequestDispatcher rd2 = request.getRequestDispatcher("applicationUser.jsp");
				rd2.forward(request, response);
			}
		}
	}
}
