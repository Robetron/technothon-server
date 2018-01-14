package com.psl.service;

import java.util.Date;
import java.util.List;
import com.psl.dao.TrainingDetailsDao;
import com.psl.entity.TrainingDetails;

public class TrainingDetailsService {
	private TrainingDetailsDao dao;

	public TrainingDetailsDao getDao() {
		return dao;
	}

	public void setDao(TrainingDetailsDao dao) {
		this.dao = dao;
	}

	public TrainingDetailsService() {
		super();
		this.dao = new TrainingDetailsDao();
	}
	public boolean isRoomAvailable(long roomID,Date targetDay,Date edate,String stime,String etime){
		return this.dao.isRoomAvailable(roomID, targetDay, edate, stime, etime);
	}

	
	public void insertTrainingDetails(TrainingDetails details){
		this.dao.insertTrainingDetails(details);			
	}
	
	
	public void deleteTrainingDetails(long id){
		this.dao.deleteTrainingDetails(id);
	}
	
	public long showTrainingid(Date sDate, String startTime, long iD){		
		return this.dao.showTrainingid(sDate, startTime, iD);
	}
	
	
	public List<TrainingDetails> getTrainingDetails(long id) {
		return this.dao.getTrainingDetails(id);
	}
	
}
