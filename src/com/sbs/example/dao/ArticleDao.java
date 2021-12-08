package com.sbs.example.dao;

import java.util.ArrayList;
import java.util.List;

import com.sbs.example.dto.Article;
import com.sbs.example.dto.Member;

public class ArticleDao {
	private List<Article>articles;
	private int lastId;
	
	public ArticleDao() {
		articles = new ArrayList<>();
		lastId = 0;
		makeTestData();
	}
	
	
	private void makeTestData() {
		for (int i = 1; i <= 5; i++) {
			write(1, "제목" + i, "내용" + i);
		}

		for (int i = 6; i <= 10; i++) {
			write(2, "제목" + i, "내용" + i);
		}
	}

	public int write(int loginedMemberId, String title, String body) {
		Article article = new Article();
		article.id = lastId + 1;
		article.memberId = loginedMemberId;
		article.title = title;
		article.body = body;
		articles.add(article);
		
		lastId = article.id;
		
		return article.id;
		
	}


	public List<Article> getForPrintArticles() {
		return articles;
	}

}
