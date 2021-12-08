package com.sbs.example.controller;

import java.util.Scanner;

import com.sbs.example.Container;
import com.sbs.example.dto.Member;
import com.sbs.example.service.MemberService;
import com.sbs.example.session.Session;

public class MemberController {

	private MemberService memberService;

	public MemberController() {
		memberService = Container.memberService;
	}

	public void doCommand(String cmd) {
		if (cmd.equals("member login")) {
			login(cmd);
		} else if (cmd.equals("member logout")) {
			logout(cmd);
		} else if (cmd.equals("member join")) {
			join(cmd);
		} else if (cmd.equals("member whoami")) {
			whoami(cmd);
		}
	}

	private void whoami(String cmd) {
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		int loginedMemberId = Container.session.loginedMemberId;

		Member loginedMember = memberService.getMemberById(loginedMemberId);

		System.out.printf("== 로그인 된 사용자 정보 ==\n");
		System.out.printf("로그인 아이디 :%s\n", loginedMember.id);
		System.out.printf("이름 : %s\n", loginedMember.name);
	}

	private void logout(String cmd) {
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		Container.session.logout();
		System.out.println("로그아웃 되었습니다!");

	}

	private void login(String cmd) {
		Scanner scan = Container.scanner;

		String loginId;
		String loginPw;

		System.out.print("로그인 아이디: ");
		loginId = scan.nextLine();

		Member member = memberService.getMemberByLoginId(loginId);

		if (member == null) {
			System.out.printf("%s(은)는 존재하지 않는 로그인 아이디입니다.", loginId);
			return;
		}
		System.out.print("로그인 비밀번호: ");
		loginPw = scan.nextLine();

		// service, dao는 session을 몰라야한다
		// session은 오직 controller만 사용 가능하다.

		if (member.loginPw.equals(loginPw) == false) {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}

		Container.session.login(member.id);
		System.out.printf("%s님, 환영합니다.\n", member.name);

	}

	private void join(String cmd) {
		Scanner scan = Container.scanner;

		String loginId;
		String loginPw;
		String name;

		System.out.print("아이디: ");
		loginId = scan.nextLine();

		boolean isJoinableLoginId = memberService.isJoinableLoginId(loginId);

		if (isJoinableLoginId == false) {
			System.out.printf("%s(은)는 이미 사용중인 아이디입니다.", loginId);
			return;
		}
		System.out.print("비밀번호: ");
		loginPw = scan.nextLine();
		System.out.print("이름: ");
		name = scan.nextLine();

		int id = memberService.join(loginId, loginPw, name);
		System.out.printf("%d번 회원이 생성되었습니다.\n", id);
	}

}
