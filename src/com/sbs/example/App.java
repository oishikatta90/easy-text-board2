package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.controller.ArticleController;
import com.sbs.example.controller.Controller;
import com.sbs.example.controller.MemberController;
import com.sbs.example.service.ArticleService;
import com.sbs.example.service.MemberService;

public class App {
	private MemberController memberController;
	private ArticleController articleController;

	public App() {
		memberController = Container.memberController;
		articleController = Container.articleController;

		makeTestData();

		init();
	}

	private void init() {
		ArticleService articleService = Container.articleService;
		Container.session.selectedBoardId = articleService.getDefaultBoardId();

	}

	private void makeTestData() {
		// 회원 2명 생성
		MemberService memberService = Container.memberService;
		int firstMemberId = memberService.join("admin1", "1234", "어드민1");
		int secondMemberId = memberService.join("admin2", "1234", "어드민2");

		// 공지사항 게시판 생성
		ArticleService articleService = Container.articleService;
		int noticeBoardId = articleService.makeBoard("공지사항");
		int freeBoardId = articleService.makeBoard("자유");
		// 1번 회원이 공지사항 게시물 5개 작성
		// 2번 회원이 공지사항 게시물 5개 작성
		for (int i = 1; i <= 5; i++) {
			articleService.write(noticeBoardId, firstMemberId, "원피스" + i + "권", "모험편" + i + "장");
			articleService.write(noticeBoardId, secondMemberId, "원피스" + i + "권", "모험편" + i + "장");

		}
		
		

	}

	public void run() {
		Scanner scanner = Container.scanner;

		while (true) {
			System.out.print("명령어 >> ");
			String cmd = scanner.nextLine();

			if (cmd.equals("system exit")) {
				System.out.println(" ==시스템을 종료합니다.== ");
				break;
			}

			Controller controller = getControllerByCmd(cmd);
			if (controller != null) {
				controller.doCommand(cmd);
			}
		}
		scanner.close();
	}

	private Controller getControllerByCmd(String cmd) {
		if (cmd.startsWith("member ")) {
			return memberController;
		} else if (cmd.startsWith("article ")) {
			return articleController;
		}
		return null;
	}

}
