package com.sbs.example.controller;

import java.util.Scanner;

import com.sbs.example.Container;
import com.sbs.example.dto.Member;
import com.sbs.example.service.MemberService;

public class MemberController{

	private MemberService memberService;
	
	public MemberController() {
		memberService = Container.memberService;
	}

	public void doCommand(String cmd) {
		if (cmd.equals("member login")) {
		} else if (cmd.equals("member join")) {
			join(cmd);
		}
	}

	private void join(String cmd) {
		Scanner scan = Container.scanner;
		
		String loginId;
		String loginPw;
		String name;
		
		System.out.print("로그인 아이디: ");
		loginId = scan.nextLine();
		System.out.print("로그인 비밀번호: ");
		loginPw = scan.nextLine();
		System.out.print("이름: ");
	 	name = scan.nextLine();
	 	
	 	int id = memberService.join(loginId, loginPw, name);
	 	System.out.printf("%d번 회원이 생성되었습니다.\n", id);
	}

}
