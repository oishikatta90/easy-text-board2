package com.sbs.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.example.dto.Member;

public class MemberDao {
	private List<Member> members;
	private int lastId;
	
	public MemberDao() {
		members = new ArrayList<>();
		lastId = 0;
		
		makeTestData();
	}

	private void makeTestData() {
		Member member = new Member();
		member.id = 1;
		member.loginId = "admin";
		member.loginPw = "1234";
		member.name = "어드민";
		
		members.add(member);
		
		member = new Member();
		member.id = 2;
		member.loginId = "admin2";
		member.loginPw = "1234";
		member.name = "어드민2";
		
		members.add(member);
		
	}

	public int join(String loginId, String loginPw, String name) {
		Member member = new Member();
		member.id = lastId + 1;
		member.loginId = loginId;
		member.loginPw = loginPw;
		member.name = name;
		
		members.add(member);
		
		lastId = member.id;
		
		//임시
		System.out.println(members);
		
		return member.id;
		
	}

	public Member getMemberByLoginId(String loginId) {
		for (Member member : members) {
			if (member.loginId.equals(loginId)) {
				return member;
			}
		}
		return null;
	}

	public Member getMemberById(int id) {
		for (Member member : members) {
			if (member.id == id) {
				return member;
			}
		}
		return null;
	}
}
