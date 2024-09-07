package com.main.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.Entities.CompletedEvents;
import com.main.Entities.CompletedEventsDTO;

@Service
public class CompletedEventDTOServiceImpl {
	
	@Autowired
	CompletedEventServiceImpl eventServiceImpl;
	
	@Autowired
	ImageServiceImpl imageServiceImpl;
	
	
	public List<CompletedEventsDTO> allEvents(){
		List<CompletedEventsDTO> cdeto = new ArrayList<>();
		List<CompletedEvents> cmt = this.eventServiceImpl.allCompletedEvent();
		for(CompletedEvents cpt1:cmt) {
			CompletedEventsDTO event = new CompletedEventsDTO();
			event.setId(cpt1.getId());
			event.setEventName(cpt1.getEventName());
			event.setDate(cpt1.getDate());
			event.setDescription(cpt1.getDescription());
			event.setLocation(cpt1.getLocation());
			event.setImageUrl(this.imageServiceImpl.findALLImages(cpt1.getId()));
			cdeto.add(event);
			event = null;
		}
		return cdeto;
	}

}
