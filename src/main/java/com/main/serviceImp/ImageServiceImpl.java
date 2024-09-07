package com.main.serviceImp;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.main.Entities.CompletedEvents;
import com.main.Entities.Image;
import com.main.dao.ImageRepository;
import com.main.services.ImageService;


@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	ImageUploader imageUploader;


	@Override
	public List<String> imageuploader(MultipartFile[] file,CompletedEvents cp) {
		List<String> images = new ArrayList<>();
		String url;
		for(int i=0;i<file.length;i++) {
			Image img = new Image();
			url = this.imageUploader.imageUpload(file[i]);
			images.add(url);
			img.setImageUrl(url);
			img.setCompletedEvents(cp);
			this.imageRepository.save(img);
			img = null;
		}
			
		return images;
		
	}
	
	public List<String> findALLImages(long id){
		List<String> images = new ArrayList<>();
		images = this.imageRepository.findImagesByEventID(id);
		return images;
	}

}
