package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.Entities.ForumMember;

public interface ForumMemberRepository extends JpaRepository<ForumMember, Long>{

}
