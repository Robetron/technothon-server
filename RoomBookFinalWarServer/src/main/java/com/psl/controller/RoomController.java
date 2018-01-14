package com.psl.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.psl.entity.Room;
import com.psl.service.RoomService;

/**
 * Servlet implementation class Controller
 */

public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RoomService roomService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomController() {
        super();
        roomService = new RoomService();
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
		System.out.println(" in dopost method");
		//RoomDao roomDao = new RoomDao();
		String roomName = request.getParameter("roomname");
		String Location = request.getParameter("location");
		String Capacity = request.getParameter("capacity");
		String roomType = request.getParameter("roomtype");

		System.out.println(roomName + " " + roomType);
		Room room = new Room();
		
		
		room.setCapacity(Integer.parseInt(Capacity));
		room.setLocation(Location);

		room.setRoomName(roomName);
		room.setRoomType(roomType);
		
		System.out.println("hhhhhhhhhhhh");
		boolean check=roomService.insertRoomDetails(room);
		System.out.println("value of check="+check);
		if(check)
		{
			response.sendRedirect("adminUser.jsp");
		}
		else
		{
			System.out.println("in else and check value is:"+check);
			request.setAttribute("check",check);
			
			RequestDispatcher rd1=request.getRequestDispatcher("addroom.jsp");             		        		 
	      	rd1.forward(request, response);
		/*	RequestDispatcher rd1=request.getRequestDispatcher("AddRoom.html");             		        		 
	      	rd1.forward(request, response);*/
		//	response.sendRedirect("AddRoom.html");
		}
	}

	
}
