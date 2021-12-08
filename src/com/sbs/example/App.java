package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.controller.ArticleController;
import com.sbs.example.controller.MemberController;

public class App {
	public void run() {
		Scanner scanner = Container.scanner;
		MemberController memberController = new MemberController();
		ArticleController articleController = new ArticleController();

		while (true) {
			System.out.print("명령어 >> ");
			String cmd = scanner.nextLine();

			if (cmd.equals("system exit")) {
				System.out.println(" ==시스템을 종료합니다.== ");
				break;
			} else if (cmd.startsWith("member")) {
				memberController.doCommand(cmd);
			} else if (cmd.startsWith("article")) {
				articleController.doCommand(cmd);
			}
		}
	}

}
