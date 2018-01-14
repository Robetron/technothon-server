package com.psl.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psl.entity.StatusValue;
import com.psl.entity.TrainingDetails;
import com.psl.service.StatusService;
import com.psl.service.TrainingDetailsService;

/**
 * Servlet implementation class BookRoomController
 */
public class BookRoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
//	private BookingService bookingService;
	private StatusService statusService;
	private TrainingDetailsService trainingDetailsService;

	public BookRoomController() {
		super();
//		bookingService = new BookingService();
		statusService = new StatusService();
		trainingDetailsService = new TrainingDetailsService();
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
		// TODO Auto-generated method stub

		int flag1 = 0;
		String userId = request.getParameter("employeeid");
		String name = request.getParameter("empName");
		String locName = request.getParameter("location");
		String roomID = request.getParameter("roomName");
		String startDate = request.getParameter("sDate");
		String endDate = request.getParameter("eDate");
		String startTime = request.getParameter("start_time");
		String endTime = request.getParameter("end_time");
		String trainingType = request.getParameter("training_type");
		String trainingName = request.getParameter("training_name");

		HttpSession session = request.getSession();
		String s = (String) session.getAttribute("usertype");

		System.out.println("--" + userId + name + startDate + " date:"
				+ endDate + "roomname:" + roomID);

		// parse date in Date format
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = null;
		Date eDate = null;
		// added
		String trainingid = "";
		try {

			sDate = format.parse(startDate);
			eDate = format.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sDate.after(eDate)) {
			System.out
					.println("wrong value entered, start date in front of end date");
		}

		long empID = Long.parseLong(userId);
		long ID = Long.parseLong(roomID); // room.getRoomIDByName(roomName);
		System.out.println("!!!!!!!!!!ID is   " + ID);

		System.out.println("dates after parsing" + sDate + eDate);

		//StatusDao statusdao = new StatusDao();
		//TrainingDetailsDao tdao = new TrainingDetailsDao();
		TrainingDetails details = new TrainingDetails();

		// check status of the room for that day
		Map<Date, StatusValue> map = null;
		try {
			map = statusService.getStatus(ID, sDate, eDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("status map is" + map.toString());

		details.setEmployeeID(empID);
		details.setEndDate(eDate);
		details.setEndTime(endTime);
		details.setRoomID(ID);
		details.setStartDate(sDate);
		details.setStartTime(startTime);
		details.setTrainingType(trainingType);
		details.setOwnerName(name);
		details.setTrainingName(trainingName);

		Calendar start = Calendar.getInstance();
		start.setTime(sDate);

		Calendar end = Calendar.getInstance();
		end.setTime(eDate);

		if (map.isEmpty()) {
			// room is available for all days selected, insert training details
			// in training table
			System.out.println("room is available..");

			trainingDetailsService.insertTrainingDetails(details);

			// added code of loukik
			trainingid = trainingid + trainingDetailsService.showTrainingid(sDate, startTime, ID);
			System.out.println("TID " + trainingid);

			while (!start.after(end)) {

				System.out.println("in while");
				Date targetDay = start.getTime();
				statusService.insertStatus(ID, targetDay, details, trainingid);
				start.add(Calendar.DATE, 1);
			}

		} else {
			// room is partially or fully booked or some are available
			System.out.println("room is partially or fully booked..");
			Set<Date> target = map.keySet();

			int flag;
			flag1 = 0;
			for (Date d : target) {
				boolean bool = trainingDetailsService.isRoomAvailable(ID, d, eDate, startTime,
						endTime);
				System.out.println("is room available : " + bool);
				if (bool == true) {
					continue;
				} else {
					flag1 = 1;

					break;
				}

			}
			if (flag1 == 0) {
				trainingDetailsService.insertTrainingDetails(details);

				// added
				trainingid = trainingid
						+ trainingDetailsService.showTrainingid(sDate, startTime, ID);
				System.out.println("TID-- " + trainingid);
				while (!start.after(end)) {
					System.out.println("in while");
					Date targetDay = start.getTime();
					flag = 1;

					/*
					 * if(flag1==0) {
					 */

					for (Date d : target) {
						if (d.equals(targetDay)) {
							System.out.println("in update");
							statusService.updateStatus(ID, targetDay, startTime,
									endTime, trainingid);
							flag = 0;
							break;
						}
					}

					if (flag == 1) {
						statusService.insertStatus(ID, targetDay, details,
								trainingid);
					}
					start.add(Calendar.DATE, 1);
				}
			}
			/*
			 * else if(flag1==1) {
			 * 
			 * request.setAttribute("booked","false");
			 * 
			 * 
			 * RequestDispatcher rd2=request.getRequestDispatcher("book.jsp");
			 * rd2.forward(request, response);
			 * 
			 * 
			 * 
			 * 
			 * } else {
			 * 
			 * response.sendRedirect("adminUser.jsp");
			 * 
			 * 
			 * }
			 */

		}

		if (flag1 == 1 && s.equals("Administrator")) {

			request.setAttribute("booked", "false");

			RequestDispatcher rd2 = request.getRequestDispatcher("book1.jsp");
			rd2.forward(request, response);

		} else if (flag1 == 1 && s.equals("Application")) {

			request.setAttribute("booked", "false");

			RequestDispatcher rd2 = request.getRequestDispatcher("bookp.jsp");
			rd2.forward(request, response);

		} else if (s.equals("Administrator")) {

			/*
			 * request.setAttribute("booked","true");
			 * 
			 * RequestDispatcher
			 * rd3=request.getRequestDispatcher("adminUser.jsp");
			 * rd3.forward(request, response);
			 */
			session.setAttribute("bookvalue", "true");
			response.sendRedirect("adminUser.jsp");

		}

		else {

			/*
			 * request.setAttribute("booked","true");
			 * 
			 * RequestDispatcher
			 * rd4=request.getRequestDispatcher("applicationUser.jsp");
			 * rd4.forward(request, response);
			 */
			session.setAttribute("bookvalue", "true");
			response.sendRedirect("applicationUser.jsp");

		}

		// response.getWriter().println("alert('Password expired, please update your password..');");

		// else

		// RequestDispatcher rd1=request.getRequestDispatcher("adminUser.jsp");
		// rd1.forward(request, response);

		// response.sendRedirect("adminUser.jsp");

	}

}
