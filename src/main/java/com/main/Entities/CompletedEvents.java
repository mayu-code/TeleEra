package com.main.Entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CompletedEvents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String EventName;
	private String Description;
	private String date;
	private String Location;
	
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

	@Override
	public String toString() {
		return "CompletedEvents [id=" + id + ", EventName=" + EventName + ", Description=" + Description + ", date="
				+ date + ", Location=" + Location ;
	}
	
	
	
	
	
	
	
	

}
