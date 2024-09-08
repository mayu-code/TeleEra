package com.main.contollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.Entities.CompletedEvents;
import com.main.Entities.CompletedEventsDTO;
import com.main.serviceImp.CompletedEventDTOServiceImpl;
import com.main.serviceImp.CompletedEventServiceImpl;
import com.main.serviceImp.ImageServiceImpl;
import com.main.serviceImp.ImageUploader;

@RestController
@RequestMapping("/completedevent")
@CrossOrigin("https://tele-era.netlify.app")
public class CompletedEventCtr {
	
	@Autowired
	CompletedEventServiceImpl eventServiceImpl;
	
	@Autowired
	ImageUploader imagUploader;
	
	@Autowired
	ImageServiceImpl imageServiceImpl;
	
	@Autowired
	CompletedEventDTOServiceImpl completedEventDTOServiceImpl;
	
	
	@PostMapping("/event")
	public ResponseEntity<CompletedEventsDTO> createEvent(@RequestPart("completedEvent") CompletedEvents cp,
			@RequestParam("image") MultipartFile[] file){
		CompletedEventsDTO cedto = new CompletedEventsDTO();
		CompletedEvents completedEvents = new CompletedEvents();
		try {
			completedEvents = this.eventServiceImpl.postEvent(cp);
			cedto.setId(completedEvents.getId());
			cedto.setEventName(completedEvents.getEventName());
			cedto.setDate(completedEvents.getDate());
			cedto.setDescription(completedEvents.getDescription());
			cedto.setLocation(completedEvents.getLocation());
			cedto.setImageUrl(this.imageServiceImpl.imageuploader(file,completedEvents));
			
			
			return ResponseEntity.of(Optional.of(cedto));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<CompletedEventsDTO>> allEvents(){
		List<CompletedEventsDTO> cedto = new ArrayList<>();
		
		try {
			cedto = this.completedEventDTOServiceImpl.allEvents();
			return ResponseEntity.of(Optional.of(cedto));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
	}
	
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") long id){
		try {
			this.eventServiceImpl.deleteEvent(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}


