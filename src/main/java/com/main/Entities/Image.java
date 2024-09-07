package com.main.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn
	private CompletedEvents completedEvents;
	
	public long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", imageUrl=" + imageUrl + ", completedEvents=" + completedEvents + "]";
	}
	public CompletedEvents getCompletedEvents() {
		return completedEvents;
	}
	public void setCompletedEvents(CompletedEvents completedEvents) {
		this.completedEvents = completedEvents;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
