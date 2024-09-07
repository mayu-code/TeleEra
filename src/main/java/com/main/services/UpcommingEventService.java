package com.main.services;

import java.util.List;

import com.main.Entities.UpcommingEvent;

public interface UpcommingEventService {
	
	public UpcommingEvent addUpcommingEvent(UpcommingEvent event);
	
	public List<UpcommingEvent> getAllUpcommingEvent();
	
	public void updateUpcommingEvent(UpcommingEvent event,long id);
	
	public void deleteUpcommingEvent(long id);

}
