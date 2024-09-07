package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.Entities.CompletedEvents;

public interface CompletedEventRepository extends JpaRepository<CompletedEvents,Long>{

}
