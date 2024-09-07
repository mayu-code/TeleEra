package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.Entities.UpcommingEvent;

public interface UpcommingEventRepository extends JpaRepository<UpcommingEvent, Long> {

}
