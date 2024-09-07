package com.main.contollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.Entities.CompletedEvents;
import com.main.Entities.Image;
import com.main.dao.CompletedEventRepository;
import com.main.dao.ImageRepository;
import com.main.serviceImp.ImageUploader;

@RestController
public class ImageController {
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	CompletedEventRepository comEventRepository;
	
	@Autowired
	ImageUploader imageUploader;
	
	@PostMapping("/completedevent/images/{id}")
	public ResponseEntity<List<String>> createEvent(@RequestParam("image") MultipartFile[] file,@PathVariable("id") long id){
		CompletedEvents cmt = this.comEventRepository.findById(id).get();
		List<String> images = new ArrayList<>();
		String url;
		try {
			for(int i=0;i<file.length;i++) {
				Image img = new Image();
				url = this.imageUploader.imageUpload(file[i]);
				images.add(url);
				img.setImageUrl(url);
				img.setCompletedEvents(cmt);
				this.imageRepository.save(img);
				img = null;
			}
			
			return ResponseEntity.of(Optional.of(images));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();		
			}
	}

}
