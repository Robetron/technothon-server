package com.psl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.psl.entity.Location;
import com.psl.service.LocationService;

/**
 * Servlet implementation class AddLocationController
 */
public class AddLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LocationService locationService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddLocationController() {
		super();
		locationService = new LocationService();
		// TODO Auto-generated constructor stub
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
		String locationName = request.getParameter("locationName");
		System.out.println(locationName);
		// LocationDao dao=new LocationDao();

		Location location = new Location();
		location.setLocationName(locationName);
		boolean inserted = locationService.addLocation(location);
		System.out.println("inserted in location controller:" + inserted);
		if (inserted == false) {
			System.out.println("inside inserted=false of location controller");
			request.setAttribute("inserted", inserted);
			RequestDispatcher rd1 = request
					.getRequestDispatcher("addlocation.jsp");
			rd1.forward(request, response);
		} else {
			response.sendRedirect("adminUser.jsp");
		}
	}

}
