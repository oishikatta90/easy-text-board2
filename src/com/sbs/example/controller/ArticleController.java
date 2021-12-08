package com.sbs.example.controller;

import java.util.List;
import java.util.Scanner;

import com.sbs.example.Container;
import com.sbs.example.dto.Article;
import com.sbs.example.service.ArticleService;

public class ArticleController {

	private ArticleService articleService;
	
	public ArticleController() {
		articleService = new ArticleService();
	}

	public void doCommand(String cmd) {
		if (cmd.equals("article add")) {
			add(cmd);
		} else if (cmd.equals("article list")) {
			list(cmd);
		}
	}

	private void list(String cmd) {
		List<Article> articles = articleService.getForPrintArticles();
		for (Article article : articles) {
			System.out.printf("게시물번호 : %d / 회원번호 : %d / 게시물 제목 : %s / 게시물 내용 : %s\n",article.id, article.memberId, article.title, article.body);
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

		int id = articleService.write(Container.session.loginedMemberId,title, body);
		System.out.printf("%d번 글 생성되었습니다.\n", id);
	}

}
