package com.main.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.main.Entities.CompletedEvents;

public interface ImageService {
	
	public List<String> imageuploader(MultipartFile[] file,CompletedEvents cp);
	

}
