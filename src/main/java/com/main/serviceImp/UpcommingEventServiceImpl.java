package com.main.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.Entities.UpcommingEvent;
import com.main.dao.UpcommingEventRepository;
import com.main.services.UpcommingEventService;

@Service
public class UpcommingEventServiceImpl implements UpcommingEventService{
	
	@Autowired
	private UpcommingEventRepository eventRepository;

	@Override
	public UpcommingEvent addUpcommingEvent(UpcommingEvent event) {
		return (UpcommingEvent) this.eventRepository.save(event);
	}

	@Override
	public List<UpcommingEvent> getAllUpcommingEvent() {
		return (List<UpcommingEvent>) this.eventRepository.findAll();
	}

	@Override
	public void updateUpcommingEvent(UpcommingEvent event, long id) {
		event.setId(id);
		this.eventRepository.save(event);
		
	}

	@Override
	public void deleteUpcommingEvent(long id) {
		this.eventRepository.deleteById(id);
	}

}
