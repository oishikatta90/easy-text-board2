package com.sbs.example.service;

import com.sbs.example.Container;
import com.sbs.example.dao.MemberDao;
import com.sbs.example.dto.Member;

public class MemberService {

	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = Container.memberDao;
	}

	public int join(String loginId, String loginPw, String name) {
		return memberDao.join(loginId, loginPw, name);
	}

	public boolean isJoinableLoginId(String loginId) {
		Member member = memberDao.getMemberByLoginId(loginId);
		
		if (member != null) {
			return false;
		}
		return true;
	}

	public Member getMemberByLoginId(String loginId) {
		return memberDao.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberDao.getMemberById(id);
	}

}
