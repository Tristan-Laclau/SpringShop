package fr.fms.business;

import java.util.List;

import fr.fms.entities.Article;

public interface IBusiness {

	/**
	 * Returns all articles
	 */
	public List<Article> getAllArticles();
}
