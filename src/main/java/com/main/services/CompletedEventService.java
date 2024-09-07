package com.main.services;

import java.util.List;

import com.main.Entities.CompletedEvents;

public interface CompletedEventService {
	

	public CompletedEvents postEvent(CompletedEvents completedEvents);
	public List<CompletedEvents> allCompletedEvent();
	public CompletedEvents getEventById(long id);
	public void deleteEvent(long id);
	public CompletedEvents updateEvent(long id);
	
}
