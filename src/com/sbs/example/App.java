package com.sbs.example;

import java.util.Scanner;

import com.sbs.example.controller.ArticleController;
import com.sbs.example.controller.Controller;
import com.sbs.example.controller.MemberController;

public class App {
	private MemberController memberController;
	private ArticleController articleController;

	public App() {
		memberController = new MemberController();
		articleController = new ArticleController();
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
			controller.doCommand(cmd);
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
