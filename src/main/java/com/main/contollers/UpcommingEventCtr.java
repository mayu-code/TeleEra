package com.main.contollers;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.main.Entities.UpcommingEvent;
import com.main.serviceImp.ImageUploader;
import com.main.serviceImp.UpcommingEventServiceImpl;

@RestController
@RequestMapping("/upcommingEvents")
@CrossOrigin("http://localhost:5173")
public class UpcommingEventCtr {
	
	@Autowired
	private UpcommingEventServiceImpl serviceImpl;
	
	@Autowired
	private ImageUploader imageUploader;
	
	@PostMapping("/event")
	public ResponseEntity<UpcommingEvent> addUpcommingEvent(@RequestPart("upcommingEvent") UpcommingEvent event ,@RequestParam("image") MultipartFile file){
		UpcommingEvent uevent = null;
		try {
			String url = this.imageUploader.imageUpload(file);
			event.setImageUrl(url);
			uevent = this.serviceImpl.addUpcommingEvent(event);
			return ResponseEntity.of(Optional.of(uevent));
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping("/events")
	public ResponseEntity<List<UpcommingEvent>> getAllUpcommingEvent(){
		try {
			List<UpcommingEvent> list = this.serviceImpl.getAllUpcommingEvent();
			return  ResponseEntity.of(Optional.of(list));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable("id") long id){
		try {
			this.serviceImpl.deleteUpcommingEvent(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/event/{id}")
	public ResponseEntity<Void> updateEvent(@RequestPart("")UpcommingEvent event , 
			@RequestParam("image") MultipartFile file ,
			@PathVariable("id") long id){
		try {
			return null;
		}
		catch(Exception e) {
			return null;
		}
	}

}
