package com.main.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UpcommingEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String eventName;
	private String description;
	private String date;
	private String location;
	private String imageUrl;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "UpcommingEvent [id=" + id + ", EventName=" + eventName + ", Description=" + description + ", date="
				+ date + ", Location=" + location + ", imageUrl=" + imageUrl + "]";
	}
	
	
	

}
