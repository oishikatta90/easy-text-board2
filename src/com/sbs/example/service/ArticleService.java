package com.sbs.example.service;

import com.sbs.example.Container;
import com.sbs.example.dao.ArticleDao;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() {
		articleDao = new ArticleDao();
	}

	public int write(int loginedMemberId, String title, String body) {
		return articleDao.write(loginedMemberId, title, body);
	}

}
