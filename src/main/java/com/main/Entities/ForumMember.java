package com.main.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ForumMember {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Name;
	private String post;
	private String branch;
	private String bio;
	private String imageUrl;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "ForumMember [id=" + id + ", Name=" + Name + ", post=" + post + ", branch=" + branch + ", imageUrl="
				+ imageUrl + ", bio=" + bio + "]";
	}
	
	
	

}
