package com.main.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entities.CompletedEvents;
import com.main.dao.CompletedEventRepository;
import com.main.services.CompletedEventService;

@Service
public class CompletedEventServiceImpl implements CompletedEventService {
	
	@Autowired
	CompletedEventRepository completedEventRepository;

	@Override
	public List<CompletedEvents> allCompletedEvent() {
		return this.completedEventRepository.findAll();
	}

	@Override
	public CompletedEvents getEventById(long id) {
		Optional<CompletedEvents> completedEvents =  this.completedEventRepository.findById(id);
		return completedEvents.get();
	}

	@Override
	public void deleteEvent(long id) {
		this.completedEventRepository.deleteById(id);
	}

	@Override
	public CompletedEvents updateEvent(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompletedEvents postEvent(CompletedEvents completedEvents) {
		try {
			return (CompletedEvents) this.completedEventRepository.save(completedEvents);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
