package com.main.Entities;

import java.util.ArrayList;
import java.util.List;

public class CompletedEventsDTO {
	
	private long id;
	private String EventName;
	private String Description;
	private String date;
	private String Location;
	private List<String> imageUrl = new ArrayList<>();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public List<String> getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "CompletedEventsDTO [id=" + id + ", EventName=" + EventName + ", Description=" + Description + ", date="
				+ date + ", Location=" + Location + ", imageUrl=" + imageUrl + "]";
	}
	
	
	

}
