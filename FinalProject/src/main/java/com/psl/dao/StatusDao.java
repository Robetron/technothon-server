package com.psl.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.Session;
import com.psl.entity.Status;
import com.psl.entity.StatusValue;
import com.psl.entity.TrainingDetails;
import com.psl.util.HibernateUtility;

public  class StatusDao {
		
	public void updateStatus(long roomID, Date date,String starttime,String endtime,String trainingID){
		
		String startarr1[] = starttime.split(":");
    	String endarr1[] = endtime.split(":");
    	
    	int STime = Integer.parseInt(startarr1[0] + startarr1[1]);
    	int ETime = Integer.parseInt(endarr1[0] + endarr1[1]);
    	
		System.out.println("roomid and date in update status is " + roomID + " " + date);
		Session session=HibernateUtility.getSesssion();
		Query q = session.createQuery("from TrainingDetails T  where T.roomID= :roomID");
		q.setLong("roomID", roomID);
		List<TrainingDetails> list=q.list();
		System.out.println("List size " + list.size() + " values in update status.. " + list);
		
		
		//added
		Query qry = session.createQuery("select trainingID from Status where roomID=:roomID and date= :date");
		qry.setLong("roomID", roomID);
		qry.setDate("date", date);
	
		String i = "";
		List l =qry.list();
		//System.out.println("Staus table size:"+l.size());
		Iterator it = l.iterator();
		while(it.hasNext())
		{
		    i = (String) it.next();
		   System.out.println(i);
		   
		}		
		
		i = i + "," + trainingID;
		System.out.println("i is " +i);
		
		int TotalTime = 900;
		TotalTime = TotalTime - (ETime - STime);
		boolean flag=false;
		
		for(TrainingDetails details : list)
		{
			
			Date StartDate = details.getStartDate();
			Date EndDate = details.getEndDate();
			
			Calendar start = Calendar.getInstance();
			start.setTime(StartDate);
			
			Calendar end = Calendar.getInstance();
			end.setTime(EndDate);
			
			while( !start.after(end))
			{			
				  Date targetDay = start.getTime();
				  System.out.println("target day is -- " + targetDay);
				  
				  if(targetDay.equals(date))
				  {
					  System.out.println("got the required date..!!! ");
				    	String stime = details.getStartTime();
				    	String etime = details.getEndTime();
				    	
				    	String startarr[] = stime.split(":");
				    	String endarr[] = etime.split(":");
				    	
				    	int StartTime = Integer.parseInt(startarr[0] + startarr[1]);
				    	int EndTime = Integer.parseInt(endarr[0] + endarr[1]);
				    	
				    	TotalTime = TotalTime - (EndTime - StartTime);
				    	
				  }
				
			 
			   start.add(Calendar.DATE, 1);
			}
			
		}
		
		System.out.println("total time is " + TotalTime);
		
		long booked = 0;
		if(TotalTime <= 200){
			System.out.println("inside booked 1");
			booked = 1;
			
		}
		else{
			System.out.println("inside booked 2");
			booked = 2;
		}
		System.out.println(booked + " " + roomID);
		
		String update = "update Status set status = :booked " + "where roomID = :room_ID AND date = :date";
		Query query = session.createQuery(update);

		query.setParameter("booked",booked);
		query.setParameter("room_ID",roomID); 
		query.setParameter("date", date);
		System.out.println("updateing status:"+update);
		int result = query.executeUpdate();
		System.out.println("result is " +result);
		String update1 = "update Status set trainingID = :i " + "where roomID = :room_ID AND date = :date";
        System.out.println("updating training id"+update1);
		Query query1 = session.createQuery(update1);

	
		query1.setParameter("room_ID",roomID); 
		query1.setParameter("date", date);
		query1.setParameter("i", i);
		
		System.out.println("here");
		int result1 = query1.executeUpdate();
		
		session.beginTransaction().commit();

	}

	public  Map<Date,StatusValue> getStatus(long roomID,Date start,Date end) throws ParseException{
		
		Map<Date,StatusValue> map=new HashMap<Date, StatusValue>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Session session=HibernateUtility.getSesssion();
		Query query=session.createQuery("from Status S WHERE S.roomID = :room_id");
		query.setParameter("room_id",roomID);
		List<Status> list=query.list();
		System.out.println("List values");
		System.out.println(list);
		
		for(Status s:list){
			
			if((s.getDate().equals(start) || s.getDate().after(start)) && (s.getDate().before(end)|| s.getDate().equals(end)))
			{		
						System.out.println(s.getRoomID()+"\t"+s.getStatus()+"\t"+s.getDate());

						System.out.println("true");
						StatusValue val;
						if(s.getStatus()==0) val=StatusValue.AVAILABLE;
						else if(s.getStatus()==1) val=StatusValue.BOOKED;
						else val=StatusValue.PARTIAL;
						
						map.put(s.getDate(),val);
					}
		}
		System.out.println("Map values");
		System.out.println(map);
		return map;
	}
	public void addStatus(Status status){
		Session session=HibernateUtility.getSesssion();
		session.save(status);
		session.beginTransaction().commit();
		
	}
	
	public void deletStatus(Long id){
		Session session=HibernateUtility.getSesssion();
	//	EntityManager entitymanager=new Entity
		String id1="";
		id1=id1+id;
		Status stat=new Status();
		//String searchkey="";
		Query q1 =session.createQuery("from Status where trainingID like :searchkey");
        q1.setParameter("searchkey","%"+id1+"%");
            		
          
		List l =q1.list();
		String i;
		long stid;
		Iterator it = l.iterator();
		while(it.hasNext())
		{
		  stat=(Status)it.next();
		  System.out.println(stat.toString());
		  i=stat.getTrainingID();
		  System.out.println(i);
		  stid=stat.getStatusID();
		    if(i.contains(","))
		    {
		    	String uid="";
		    	String st[]=i.split(",");
		    	int j=0,k=0;
		    	while(j<st.length)
		    	{
		    		
		    	   if(!st[j].equals(id1))
		    	   {
		    		   System.out.println(st[j]);
		    		  if(k>0)
		    		  {
		    			  uid=uid+",";
		    		  }
		    		  uid=uid+st[j];
		    		  k++;
		    		  
		    		   
		    		   
		    	   }
		    	   j++;
		    	}
		    	long g=2;
		    	 Session session1=HibernateUtility.getSesssion(); 
			    	session.flush();
			    	session1.flush();
			    	String update2 = "update Status set status= :bs " + "where statusID = :m_ID";
					Query query3 = session1.createQuery(update2);
					query3.setParameter("bs",g);
					query3.setParameter("m_ID",stid);
					System.out.println(query3.executeUpdate());
					session1.beginTransaction().commit();
					session1.close();
		    	String update1 = "update Status set trainingID = :uid " + "where statusID = :m_ID";
		    	
		    	System.out.println(uid);
System.out.println(update1);
				Query query2 = session.createQuery(update1);
				
			
				query2.setParameter("m_ID",stid); 
				query2.setParameter("uid",uid);
				
				//query1.setParameter("i", i);
				System.out.println(query2.executeUpdate());
				session.beginTransaction().commit();
		    	
		    	
		    }
		    else
		    {
		    	
		    	
		    	Query q2 = session.createQuery("delete Status where statusID=:id2");
				q2.setParameter("id2",stid);
				System.out.println(q2.executeUpdate());
				//session.beginTransaction().commit();
		    	
		    	
		    	
		    }
		    
		    
		    
		   
		   
		}		
		
		
		
		
		
		
		session.beginTransaction().commit();
		
	}
	
	public void insertStatus(long roomID, Date date,TrainingDetails details,String trainingID)
	{
		Session session=HibernateUtility.getSesssion();
		int TotalTime=900;
		System.out.println("got the required date..!!! ");
    	String stime = details.getStartTime();
    	String etime = details.getEndTime();
    	
    	String startarr[] = stime.split(":");
    	String endarr[] = etime.split(":");
    	
    	int StartTime = Integer.parseInt(startarr[0] + startarr[1]);
    	int EndTime = Integer.parseInt(endarr[0] + endarr[1]);
    		
    	TotalTime = TotalTime - (EndTime - StartTime);
    	
    	long booked = 0;
		if(TotalTime <= 200){
			System.out.println("inside booked 1");
			booked = 1;
			
		}
		else{
			System.out.println("inside booked 2");
			booked = 2;
		}
		System.out.println(booked + " " + roomID);
		
		Status status = new Status();
		status.setDate(date);
		status.setRoomID(roomID);
		status.setStatus(booked);
		status.setTrainingID(trainingID);
		session.save(status);
		session.beginTransaction().commit();
		
	}
	
	

	/*public static void main(String[] args) {
		StatusDao status=new StatusDao();
		status.deletStatus((long) 38);
		
		
	}*/
	
	
	
}







