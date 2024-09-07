package com.main.services;

import java.util.List;
import com.main.Entities.ForumMember;

public interface ForumMemberService {
	
//	Add forum members 
	public ForumMember addForumMember(ForumMember member);
	
//	get all forum members
	public List<ForumMember> getAllFroumMebers();
	
	public void updateForumMember(ForumMember member,long id);
	
	public void deleteForumMember(long id);

}
