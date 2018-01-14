package com.psl.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.psl.entity.Room;
import com.psl.service.BookingService;
import com.psl.service.LocationService;
import com.psl.service.RoomService;
import com.psl.service.StatusService;

/**
 * Servlet implementation class Tabledata
 */
public class Tabledata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoomService roomService;
	private StatusService statusService;
	private BookingService bookingService;
	private LocationService locationService;
    //   RoomDao roomDao;
    //   StatusDao statusDao;
    //   BookingDao bookingDao;
	//private LocationDao locationDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tabledata() {
        super();
        //locationDao=new LocationDao();
        //roomDao=new RoomDao();
        //statusDao=new StatusDao();

    	roomService = new RoomService();
    	statusService = new StatusService();
    	bookingService = new BookingService();
    	locationService = new LocationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String location=request.getParameter("loc");
		List<Room> roomList = roomService.getRoomByLocation(location);
		//List<String> nameList=new ArrayList<String>();
		//List<Long> capList=new ArrayList<Long>();
				
		//String list="{\"List\":[";
		
		JSONArray	arrayone=new JSONArray();
		JSONObject rooms;
		for (Room room:roomList) {
			//list=list+"\""+room.getRoomID()+"\":{\"name\":\""+room.getRoomName()+"\",\"capacity\":"+room.getCapacity()+"},";
			rooms=new JSONObject();
			rooms.put("roomId",room.getRoomID());
			rooms.put("roomName", room.getRoomName());
			rooms.put("capacity", room.getCapacity());
			arrayone.add(rooms);
		}
		JSONObject json=new JSONObject();
		json.put("roomList",arrayone);
		//StringBuffer str=new StringBuffer(list);
		//str.setCharAt(str.length()-1,']');
		//str.append('}');
		//str.append('\'');
		//System.out.println(str);

//		json.addAll(locationList);
		
		/*String str1={1:{name:"opel","capacity":30}};*/
		/*jsonobj.put("nameList",nameList);
		jsonobj.put("capList",capList);*/
		/*JSONObject obj=new JSONObject();
		obj.put("list",roomList);*/
		//StringBuffer str=new StringBuffer(obj.toString());
		
		
		//str.deleteCharAt(0);
		//str.deleteCharAt(str.length()-1);
		
		//System.out.println(str);
		response.setContentType("application/json");
		response.getWriter().write(json.toString());
	}			
		
		
		/*String location=request.getParameter("location");
					String startDate=request.getParameter("startDate");
					String endDate=request.getParameter("endDate");
					String roomType=request.getParameter("roomType");
					Map<Date,StatusValue> map=new HashMap<Date, StatusValue>();
					List<Map<Date, StatusValue>> mapList=new ArrayList<Map<Date,StatusValue>>();
					List<Room> roomList=roomDao.getRoomByLocation(location);
					SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date sDate=format.parse(startDate);
						Date eDate=format.parse(endDate);
						
						for (Room room : roomList) {
							
						mapList.add(statusDao.getStatus(room.getRoomID(), sDate, eDate));
						}
						
						
						
					
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					
					//code to send data to REPORTS.HTML
					
					
					
					List<Training> trainingList=new ArrayList<Training>();
					Map<Room, List<Long>> roomTrainingMap=new HashMap<Room, List<Long>>();
					for (Room room : roomList) {
						//Edit with  bokingDao 
						roomTrainingMap.put(room, bookingDao.getTrainingIDList(room.getRoomID()));
					}
						
					JSONObject json = new JSONObject();
				    json.putAll( roomTrainingMap );
				    System.out.printf( "JSON: %s", json.toString() );*/
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
