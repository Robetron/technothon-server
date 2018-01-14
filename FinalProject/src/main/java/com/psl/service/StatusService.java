package com.psl.service;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;
import com.psl.dao.StatusDao;
import com.psl.entity.Status;
import com.psl.entity.StatusValue;
import com.psl.entity.TrainingDetails;

public class StatusService {
	private StatusDao dao;

	public StatusDao getDao() {
		return dao;
	}

	public void setDao(StatusDao dao) {
		this.dao = dao;
	}

	public StatusService() {
		super();
		this.dao = new StatusDao();
	}

	public void updateStatus(long roomID, Date date, String starttime, String endtime, String trainingID) {
		this.dao.updateStatus(roomID, date, starttime, endtime, trainingID);
	}

	public Map<Date, StatusValue> getStatus(long roomID, Date start, Date end) throws ParseException {
		return this.dao.getStatus(roomID, start, end);
	}

	public void addStatus(Status status) {
		this.dao.addStatus(status);
	}

	public void deletStatus(Long id) {
		this.dao.deletStatus(id);

	}

	public void insertStatus(long roomID, Date date, TrainingDetails details, String trainingID) {
		this.dao.insertStatus(roomID, date, details, trainingID);
	}
}
