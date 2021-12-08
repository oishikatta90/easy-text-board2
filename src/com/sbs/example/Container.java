package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.dao.MemberDao;
import com.sbs.example.service.MemberService;
import com.sbs.example.session.Session;

public class Container {

	public static Scanner scanner;
	public static Session session;
	public static MemberDao memberDao;
	public static MemberService memberService;
	
	static {
		scanner = new Scanner(System.in);
		memberDao = new MemberDao();
		memberService = new MemberService();
		session = new Session();
	}

}
