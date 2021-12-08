package com.sbs.example.controller;

import java.util.Scanner;

import com.sbs.example.Container;
import com.sbs.example.service.ArticleService;

public class ArticleController {

	private ArticleService articleService;
	
	public ArticleController() {
		articleService = Container.articleService;
	}

	public void doCommand(String cmd) {
		if (cmd.equals("article add")) {
			add(cmd);
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
