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

import com.main.Entities.ForumMember;
import com.main.serviceImp.ForumMemberServiceImpl;
import com.main.serviceImp.ImageUploader;

@RestController
@RequestMapping("/fmembers")
@CrossOrigin("http://localhost:5173")
public class ForumMemberCtr {
	
	@Autowired
	private ForumMemberServiceImpl forumMemberServiceImpl;
	
	@Autowired
	private ImageUploader imageUploader;
	
	
	@PostMapping("/member")
	public ResponseEntity<ForumMember> addForumMember(@RequestPart("forumMember") ForumMember forumMember,@RequestParam("image") MultipartFile file){
		ForumMember member = null;
		forumMember.setImageUrl(this.imageUploader.imageUpload(file));
		try {
			member = this.forumMemberServiceImpl.addForumMember(forumMember);
			return ResponseEntity.of(Optional.of(member));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@GetMapping("/members")
	public ResponseEntity<List<ForumMember>> getAllForumMember(){
		List<ForumMember> list = this.forumMemberServiceImpl.getAllFroumMebers();
;		try {
			return ResponseEntity.of(Optional.of(list));
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@DeleteMapping("/member/{id}")
	public ResponseEntity<Void> deleteForumMemeber(@PathVariable("id") long id){
		try {
			 this.forumMemberServiceImpl.deleteForumMember(id);
			 return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PutMapping("/member/{id}")
	public ResponseEntity<Void> updateForumMember(@RequestPart("forumMember") ForumMember forumMember,
												@RequestParam("image") MultipartFile file,
												@PathVariable("id") long id){
		
		if(file!=null) {
			forumMember.setImageUrl(imageUploader.imageUpload(file));
		}
		
		try {
			this.forumMemberServiceImpl.updateForumMember(forumMember, id);
			return ResponseEntity.ok().build();
			
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
