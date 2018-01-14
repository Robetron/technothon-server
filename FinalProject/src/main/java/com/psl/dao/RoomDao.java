package com.psl.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.psl.entity.Room;
import com.psl.util.HibernateUtility;

public class RoomDao {
	
	SessionFactory sf;
	
	public RoomDao() {
		// TODO Auto-generated constructor stub
		// sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			
		// session=HibernateUtility.getSesssion();
	}

	public boolean insertRoomDetails(Room room){
		Session session=HibernateUtility.getSesssion();
	//	System.out.println(room.toString());
		try{
			session.save(room);
			session.beginTransaction().commit();
			return true;
		}
		catch(Exception e){
			return false;
		}
	
	}
	
	public List<Room> getRoomByLocation(String loc){
		System.out.println("Location"+loc);
		Session session=HibernateUtility.getSesssion();

		List<Room> list = new ArrayList<Room>();		
		Query q = session.createQuery("from Room R  where R.location= :loc");
		q.setString("loc", loc);
		list = q.list();
		return list;
		
	}
	public List<Room> getRoomByLocationByType(String loc,String roomType){
		
		List<Room> list = new ArrayList<Room>();
		Session session=HibernateUtility.getSesssion();

		Query q = session.createQuery("from Room R  where R.location= :loc AND R.roomType= :roomType");
		q.setString("loc", loc);
		q.setString("roomType", roomType);
		list = q.list();
		
		return list;
		
	}
	/*public static void main(String op[]){
		RoomDao dao=new RoomDao();
		Room room=new Room(101, "Ruby", "lab", 45, "HJ");
		boolean check=dao.insertRoomDetails(room);
		if(check)
			System.out.println("record inserted");
		else
			System.out.println("Record not inserted");
		dao.insertRoomDetails(new Room(102, "platium", "assessment", 34, "HJ"));
		dao.insertRoomDetails(new Room(103, "corel", "assessment", 34, "HJ"));
		dao.insertRoomDetails(new Room(104, "silver", "lab", 34, "BR"));
		dao.insertRoomDetails(new Room(102, "vikramsheela", "softskill", 34, "AR/PT"));
		List<Room> list=dao.getRoomByLocationByType("AR/PT", "lab");
		System.out.println(list);
	}*/
}
