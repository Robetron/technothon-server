package com.psl.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.psl.entity.Room;
import com.psl.entity.Status;
import com.psl.entity.Training;
import com.psl.entity.TrainingDetails;
import com.psl.util.HibernateUtility;

public class TrainingDetailsDao {
	Session session;
	SessionFactory sf;
	
	public TrainingDetailsDao() {
		// TODO Auto-generated constructor stub
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		 session= sf.openSession();
	}
	
	public boolean isRoomAvailable(long roomID,Date targetDay,Date edate,String stime,String etime){
		boolean bool = true;
		System.out.println("room id is-- " +roomID);
		List<TrainingDetails> list = new ArrayList<TrainingDetails>();		
		
		Query q = session.createQuery("from TrainingDetails T  where T.roomID= :roomID");
		q.setLong("roomID", roomID);
		list = q.list();
	
		
		Calendar end = Calendar.getInstance();
		end.setTime(edate);
		
		String checkarr[] = stime.split(":");
		int InputStartTime = Integer.parseInt(checkarr[0] + checkarr[1]);
		
		String checkarr1[] = etime.split(":");
		int InputEndTime = Integer.parseInt(checkarr1[0] + checkarr1[1]);

		
		 
		    System.out.println("target day is -- " + targetDay);
		    // Do Work Here
		    

			for(TrainingDetails TDetails : list){
				
				System.out.println("rooms are " + TDetails);
				Date startdate = TDetails.getStartDate();
				Date enddate = TDetails.getEndDate();
				
				String starttime = TDetails.getStartTime();
				String endtime = TDetails.getEndTime();
			
				String startarr[] = starttime.split(":");
				int StartTime = Integer.parseInt(startarr[0] + startarr[1]);
				
			
				String endarr[] = endtime.split(":");
				int EndTime = Integer.parseInt(endarr[0] + endarr[1]);

			
				System.out.println("hr and min are " + StartTime + " " + EndTime);
				
				if( targetDay.equals(startdate) || targetDay.equals(enddate) || (targetDay.after(startdate) && targetDay.before(enddate)) )
				{
					
					if( (InputStartTime < StartTime) && (InputEndTime<=StartTime)){
						//can book room
						bool = true;
						continue;
					}
					else if( (InputStartTime >= EndTime) && (InputEndTime > EndTime) ){
						//can book room
						bool = true;
						continue;
					}
					else{
						bool = false;
						return bool; 
					}
					
				}
		
			}
		
/*		}*/
		return bool;
	}

	
	@SuppressWarnings("deprecation")
	public void insertTrainingDetails(TrainingDetails details){
		System.out.println(details.toString());
		session.save(details);
		session.flush();
		session.beginTransaction().commit();
		try {
			session.connection().setTransactionIsolation(2);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		}
	
	
	public void deleteTrainingDetails(long id){
		
		Query q = session.createQuery("delete TrainingDetails where trainingID=:id");
		q.setLong("id", id);
		System.out.println(q.executeUpdate());
		session.beginTransaction().commit();
		
	}
	
	public long showTrainingid(Date sDate, String startTime, long iD){		
		
		Query qry = session.createQuery("select trainingID from TrainingDetails where startDate=:dte and roomID=:rid and startTime=:strt");
		qry.setLong("rid", iD);
		qry.setDate("dte", sDate);
		qry.setString("strt", startTime);
		long i = 0;
		List l =qry.list();
		Iterator it = l.iterator();
		while(it.hasNext())
		{
		    i = (Long)it.next();
		   System.out.println(i);
		   
		}		
		return i;
		
		
	}
	
	
	public List<TrainingDetails> getTrainingDetails(long id) {
		
		List<TrainingDetails> list;		
		Query q = session.createQuery("from TrainingDetails TD  where TD.trainingID =:id");		
	
		//need to do this to avoid exception bcoz of : operator
		//http://www.coderanch.com/t/440045/ORM/databases/org-hibernate-QueryException-named-parameters
		q.setLong("id", id);
		list = q.list();
		System.out.println("training details are " + list.toString());
		
		return list;
	}
	
	
	
	
}
