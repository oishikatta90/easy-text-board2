package com.sbs.example.service;

import java.util.List;

import com.sbs.example.Container;
import com.sbs.example.dao.ArticleDao;
import com.sbs.example.dto.Article;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int write(int loginedMemberId, String title, String body) {
		return articleDao.write(loginedMemberId, title, body);
	}

	public List<Article> getForPrintArticles() {
		return articleDao.getForPrintArticles();
	}
}
