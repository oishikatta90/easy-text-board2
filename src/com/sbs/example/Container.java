package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.dao.MemberDao;
import com.sbs.example.service.MemberService;
import com.sbs.example.session.Session;

public class Container {

	public static Scanner scanner;
	public static MemberDao memberDao;
	public static MemberService memberService;
	public static Session session;
	
	static {
		scanner = new Scanner(System.in);
		memberDao = new MemberDao();
		memberService = new MemberService();
		session = new Session();
	}

}
