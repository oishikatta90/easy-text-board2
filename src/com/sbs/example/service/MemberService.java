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

}
