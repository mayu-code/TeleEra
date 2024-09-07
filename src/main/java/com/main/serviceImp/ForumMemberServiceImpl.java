package com.main.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.Entities.ForumMember;
import com.main.dao.ForumMemberRepository;
import com.main.services.ForumMemberService;

@Service
public class ForumMemberServiceImpl implements ForumMemberService {
	
	@Autowired
	private ForumMemberRepository forumMemberRepository;
	
	@Override
	public ForumMember addForumMember(ForumMember member) {
		return this.forumMemberRepository.save(member);
	}
	
	@Override
	public List<ForumMember> getAllFroumMebers() {
		return (List<ForumMember>) this.forumMemberRepository.findAll();
	}


	
	@Override
	public void updateForumMember(ForumMember member, long id) {
		member.setId(id);
		this.forumMemberRepository.save(member);
		
	}

	@Override
	public void deleteForumMember(long id) {
		this.forumMemberRepository.deleteById(id);
		
	}

}
