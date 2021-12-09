package com.sbs.example.controller;

import java.util.List;
import java.util.Scanner;

import com.sbs.example.Container;
import com.sbs.example.dto.Article;
import com.sbs.example.dto.Board;
import com.sbs.example.dto.Member;
import com.sbs.example.service.ArticleService;
import com.sbs.example.service.MemberService;

public class ArticleController extends Controller {

	private ArticleService articleService;
	private MemberService memberService;

	public ArticleController() {
		articleService = Container.articleService;
		memberService = Container.memberService;
	}

	public void doCommand(String cmd) {
		if (cmd.equals("article add")) {
			add(cmd);
		} else if (cmd.equals("article list")) {
			list(cmd);
		} else if (cmd.equals("article makeBoard")) {
			makeBoard(cmd);
		} else if (cmd.startsWith("article selectBoard")) {
			selectBoard(cmd);
		}
	}

	private void selectBoard(String cmd) {
		int boardId = Integer.parseInt(cmd.split(" ")[2]);
		
		Board board = articleService.getBoardById(boardId);
		
		if (board == null) {
			System.out.println("존재하지 않는 게시판 번호입니다.");
			return;
		}
		
		System.out.printf("%s 게시판으로 변경합니다.\n", board.name);
		Container.session.selectedBoardId = board.id;
	}

	private void makeBoard(String cmd) {
		Scanner scan = Container.scanner;
		String name;

		System.out.print("게시판 이름 : ");
		name = scan.nextLine();
		
		int boardId = articleService.makeBoard(name);
		
		System.out.printf("%s(%d) 게시판이 생성되었습니다.",name, boardId);
	}

	private void list(String cmd) {
		List<Article> articles = articleService.getForPrintArticles();

		for (Article article : articles) {
			Member member = memberService.getMemberById(article.memberId);
			System.out.printf("게시물번호 : %d / 회원이름 : %s / 게시물 제목 : %s / 게시물 내용 : %s\n", article.id, member.name,
					article.title, article.body);
		}
	}

	private void add(String cmd) {
		if (Container.session.isLogined() == false) {
			System.out.println("로그인 후 이용해주세요.");
			return;
		}
		Scanner scan = Container.scanner;

		String title;
		String body;

		System.out.print("제목: ");
		title = scan.nextLine();
		System.out.print("내용: ");
		body = scan.nextLine();
		
		int boardID = Container.session.selectedBoardId;
		int memberId = Container.session.loginedMemberId;
		int id = articleService.write(boardID, memberId, title, body);
		System.out.printf("%d번 글 생성되었습니다.\n", id);
	}

}
