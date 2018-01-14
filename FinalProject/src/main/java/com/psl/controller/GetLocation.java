package com.psl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.json.simple.JSONArray;

import com.psl.entity.Location;
import com.psl.service.LocationService;

/**
 * Servlet implementation class GetLocation
 */
public class GetLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LocationService locationService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLocation() {
        super();
        locationService = new LocationService();
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
		List<Location> locationList = locationService.getLocationList();
		JSONArray json=new JSONArray();
		for (Location location : locationList) {
			System.out.println("LLL"+location);
			json.add(location.getLocationName());
		}
		
//		json.addAll(locationList);
		response.setContentType("text/plain");
		response.getWriter().print(json.toString());
	}

}
