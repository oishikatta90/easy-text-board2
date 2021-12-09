package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.controller.ArticleController;
import com.sbs.example.controller.MemberController;
import com.sbs.example.dao.ArticleDao;
import com.sbs.example.dao.MemberDao;
import com.sbs.example.service.ArticleService;
import com.sbs.example.service.MemberService;
import com.sbs.example.session.Session;

public class Container {

	public static Scanner scanner;
	public static Session session;
	public static MemberService memberService;
	public static MemberDao memberDao;
	public static ArticleService articleService;
	public static ArticleDao articleDao;
	public static MemberController memberController;
	public static ArticleController articleController;
	
	static {
		scanner = new Scanner(System.in);
		session = new Session();
		
		memberDao = new MemberDao();
		articleDao = new ArticleDao();
		
		memberService = new MemberService();
		articleService = new ArticleService();
		
		memberController = new MemberController();
		articleController = new ArticleController();
		
	}

}
