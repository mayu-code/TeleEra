package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.Entities.Image;

public interface ImageRepository extends JpaRepository<Image, Long>{

	@Query("select i.imageUrl from Image i where i.completedEvents.id=:id")
	public List<String> findImagesByEventID(long id);
}
