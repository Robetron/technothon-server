package com.psl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.psl.dao.StatusDao;
import com.psl.dao.TrainingDetailsDao;
import com.psl.entity.*;
import com.psl.service.StatusService;

/**
 * Servlet implementation class ReccurrenceController
 */
public class ReccurrenceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private StatusService statusService;

	public ReccurrenceController() {
		super();
//		statusService = new StatusService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String ownerName = (String) session.getAttribute("firstname");
		Long id = (Long) session.getAttribute("userid");
		String s = (String) session.getAttribute("usertype");
		int flag1 = 0;
		// Long id=Long.parseLong(userId);
		List<TrainingDetails> list = new ArrayList<TrainingDetails>();
		// TrainingDetailsDao tdao=new TrainingDetailsDao();

		Map<Date, StatusValue> map = new HashMap<Date, StatusValue>();

		System.out.println("Hello");
		PrintWriter out = response.getWriter();
		out.println("Hello");

		String click = request.getParameter("click");
		System.out.println("click:" + click);
		String stime = request.getParameter("stime");
		String etime = request.getParameter("etime");
		String room = request.getParameter("roomid");
		String location = request.getParameter("location");
		String trainingType = request.getParameter("training_type");
		String trainingName = request.getParameter("training_name");

		/*
		 * String days[]=request.getParameterValues("day"); for(String s:days)
		 * System.out.println(s);
		 */
		String recur = request.getParameter("recur");

		long ID = Long.parseLong(room);

		// String day=request.getParameter("day");
		String sdate = request.getParameter("sdate");

		String range = request.getParameter("range");
		System.out.println("");
		System.out.println("stime:" + stime + "\t etime " + etime + "\t room "
				+ room + "\t recur: " + recur + "\t sdate: " + sdate
				+ "\t range: " + range + " TType" + trainingType);
		Calendar cal = Calendar.getInstance();
		System.out.println((Calendar.TUESDAY));

		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date truncatedDate1 = null;
		try {
			truncatedDate1 = formatter.parse(sdate);

			// System.out.println(truncatedDate1+"  "+truncatedDate2);
			// long timeDifference = truncatedDate2.getTime()-
			// truncatedDate1.getTime();

			c.setTime(truncatedDate1);

			System.out.println("cal: " + c.getTime().getDay() + "  "
					+ c1.getTime());

			// c.add(Calendar.DATE, 14);
			// System.out.println(c.getTime());
			// int daysInBetween = (int) (timeDifference / (24*60*60*1000));
			// System.out.println(daysInBetween);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * public TrainingDetails(long trainingID, long employeeID, long roomID,
		 * Date startDate, Date endDate, String trainingType, String startTime,
		 * String endTime, String ownerName)
		 */
		if (range.equalsIgnoreCase("no end date")) {
			if (recur.equalsIgnoreCase("weekly")) {
				Calendar newcal = Calendar.getInstance();
				newcal.setTime(truncatedDate1);
				newcal.add(Calendar.MONTH, 3);
				System.out.println("cal: " + c.getTime() + "\t newcal: "
						+ newcal.getTime());
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));
				while (c.compareTo(newcal) < 0) {
					c.add(Calendar.DATE, 7);
					if (c.compareTo(newcal) < 0) {
						list.add(new TrainingDetails(1, id, ID, c.getTime(), c
								.getTime(), trainingType, stime, etime,
								ownerName, trainingName));
						System.out.println("newDate: " + c.getTime());

					}
				}
				System.out.println("list: " + list);
				System.out.println(newcal.getTime());

			} else if (recur.equalsIgnoreCase("monthly")) {
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));

				Calendar newcal = c;
				int n2 = newcal.getTime().getDate();
				for (int i = 0; i < 2; i++) {
					c.add(Calendar.MONTH, 1);
					list.add(new TrainingDetails(1, id, ID, c.getTime(), c
							.getTime(), trainingType, stime, etime, ownerName,
							trainingName));
					System.out.println(c.getTime());
				}
				/*
				 * for(int i=0;i<2;i++){ int m=c.getTime().getMonth();
				 * c.add(Calendar.DATE,30); int n1=c.getTime().getDate();
				 * while(n1!=n2){ c.add(Calendar.DATE,1);
				 * 
				 * }
				 * 
				 * System.out.println(c.getTime()+" : "+c.getTime().getDay()+"  : "
				 * +c.getTime().getDate()); }
				 */
			}

		} else if (range.equalsIgnoreCase("end by")) {
			String edate = request.getParameter("edate");
			Date truncatedDate2;
			try {
				truncatedDate2 = formatter.parse(edate);
				c1.setTime(truncatedDate2);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (recur.equalsIgnoreCase("weekly")) {

				System.out.println("cal: " + c.getTime() + "\t newcal: "
						+ c1.getTime());
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));

				while (c.compareTo(c1) < 0) {
					c.add(Calendar.DATE, 7);
					if (c.compareTo(c1) < 0) {
						list.add(new TrainingDetails(1, id, ID, c.getTime(), c
								.getTime(), trainingType, stime, etime,
								ownerName, trainingName));
						System.out.println("newDate: " + c.getTime());

					}
				}

			} else if (recur.equalsIgnoreCase("monthly")) {
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));
				while (c.compareTo(c1) < 0) {
					c.add(Calendar.MONTH, 1);
					if (c.compareTo(c1) < 0) {
						list.add(new TrainingDetails(1, id, ID, c.getTime(), c
								.getTime(), trainingType, stime, etime,
								ownerName, trainingName));
						System.out.println("newDate: " + c.getTime());

					}
				}
			}

		} else if (range.equalsIgnoreCase("end after")) {
			int count = Integer.parseInt(request.getParameter("count"));

			if (recur.equalsIgnoreCase("weekly")) {
				List<TrainingDetails> booking = new ArrayList<TrainingDetails>();
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));
				for (int i = 0; i < count; i++) {
					c.add(Calendar.DATE, 7);
					list.add(new TrainingDetails(1, id, ID, c.getTime(), c
							.getTime(), trainingType, stime, etime, ownerName,
							trainingName));
					System.out.println(c.getTime() + "  : "
							+ c.getTime().getDay());
				}

			} else if (recur.equalsIgnoreCase("monthly")) {
				list.add(new TrainingDetails(1, id, ID, c.getTime(), c
						.getTime(), trainingType, stime, etime, ownerName,
						trainingName));
				Calendar newcal = c;
				int n2 = newcal.getTime().getDate();

				for (int i = 0; i < count; i++) {
					/*
					 * int m=c.getTime().getMonth(); c.add(Calendar.DATE,30);
					 * int n1=c.getTime().getDate(); while(n1!=n2){
					 * c.add(Calendar.DATE,1);
					 * 
					 * }
					 */
					c.add(Calendar.MONTH, 1);
					list.add(new TrainingDetails(1, id, ID, c.getTime(), c
							.getTime(), trainingType, stime, etime, ownerName,
							trainingName));
					System.out.println(c.getTime() + " : "
							+ c.getTime().getDay() + "  : "
							+ c.getTime().getDate());
				}

			}
		}

		System.out.println("list is " + list.size() + " " + list);

		// till here got all records..!-----------------------------------
		TrainingDetailsDao tdd = new TrainingDetailsDao();
		boolean insert = false;
		for (TrainingDetails details : list) {
			insert = tdd.isRoomAvailable(details.getRoomID(),
					details.getStartDate(), details.getEndDate(),
					details.getStartTime(), details.getEndTime());
			if (insert == false) {
				flag1 = 1;
				break;
			}

		}

		if (insert) {
			for (TrainingDetails details : list) {

				System.out.println("in for loop..");
				String trainingid = "";
				StatusDao statusdao = new StatusDao();
				TrainingDetailsDao tdao = new TrainingDetailsDao();
				// parse date in Date format
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date sDate = details.getStartDate();
				Date eDate = details.getEndDate();

				// check status of the room for that day
				Map<Date, StatusValue> map1 = null;
				try {
					map1 = statusdao.getStatus(details.getRoomID(), sDate,
							eDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("status map is" + map1.toString());
				Calendar start = Calendar.getInstance();
				start.setTime(sDate);

				Calendar end = Calendar.getInstance();
				end.setTime(eDate);

				if (map1.isEmpty()) {
					// room is available for all days selected, insert training
					// details in training table
					System.out.println("room is available..");

					tdao.insertTrainingDetails(details);

					// added code of loukik
					trainingid = trainingid
							+ tdao.showTrainingid(sDate,
									details.getStartTime(), details.getRoomID());
					System.out.println("TID " + trainingid);

					while (!start.after(end)) {

						System.out.println("in while");
						Date targetDay = start.getTime();
						statusdao.insertStatus(details.getRoomID(), targetDay,
								details, trainingid);
						start.add(Calendar.DATE, 1);
					}

				} else {
					// room is partially or fully booked or some are available
					System.out.println("room is partially or fully booked..");
					Set<Date> target = map1.keySet();

					System.out.println("target is " + target);
					int flag;
					flag1 = 0;
					for (Date d : target) {
						System.out.println("d id " + d);
						boolean bool = tdao.isRoomAvailable(
								details.getRoomID(), d, eDate,
								details.getStartTime(), details.getEndTime());
						System.out.println("is room available : " + bool);
						if (bool == true) {
							continue;
						} else {
							flag1 = 1;
							break;
						}

					}
					if (flag1 == 0) {
						tdao.insertTrainingDetails(details);

						// added
						trainingid = trainingid
								+ tdao.showTrainingid(sDate,
										details.getStartTime(),
										details.getRoomID());
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
									statusdao.updateStatus(details.getRoomID(),
											targetDay, details.getStartTime(),
											details.getEndTime(), trainingid);
									flag = 0;
									break;
								}
							}

							if (flag == 1) {
								statusdao.insertStatus(details.getRoomID(),
										targetDay, details, trainingid);
							}
							start.add(Calendar.DATE, 1);
						}
					} else {
						break;
					}

				}

			}

		}

		if (flag1 == 1 && s.equals("Administrator")) {

			request.setAttribute("booked", "false");

			RequestDispatcher rd2 = request
					.getRequestDispatcher("recurrenceForm.jsp");
			rd2.forward(request, response);

		} else if (flag1 == 1 && s.equals("Application")) {

			request.setAttribute("booked", "false");

			RequestDispatcher rd2 = request.getRequestDispatcher("bookp.jsp");
			rd2.forward(request, response);

		} else if (s.equals("Administrator")) {
			session.setAttribute("bookvalue", "true");
			response.sendRedirect("adminUser.jsp");

		}

		else {
			session.setAttribute("bookvalue", "true");
			response.sendRedirect("applicationUser.jsp");

		}

		// response.getWriter().println("alert('Password expired, please update your password..');");

		/*
		 * RequestDispatcher rd1=request.getRequestDispatcher("adminUser.jsp");
		 * rd1.forward(request, response);
		 */

	}

}
