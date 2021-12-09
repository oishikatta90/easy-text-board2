package com.sbs.example.service;

import java.util.List;

import com.sbs.example.dao.ArticleDao;
import com.sbs.example.dto.Article;
import com.sbs.example.dto.Board;

public class ArticleService {
	private ArticleDao articleDao;

	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int write(int boardId, int loginedMemberId, String title, String body) {
		return articleDao.write(boardId, loginedMemberId, title, body);
	}

	public List<Article> getForPrintArticles(int boardId) {
		return articleDao.getForPrintArticles(boardId);
	}

	public int makeBoard(String name) {
		return articleDao.makeBoard(name);

	}

	public Board getBoardById(int boardId) {
		return articleDao.getBoardById(boardId);
	}

	public int getDefaultBoardId() {
		List<Board> boards = articleDao.getBoards();
		return boards.get(1).id;
	}
}
