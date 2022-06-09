package fr.fms.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;


public class IBusinessImpl implements IBusiness{
	
	@Autowired
	public ArticleRepository articleRepository;
	
	@Autowired
	public CategoryRepository categoryRepository;

	@Override
	public List<Article> getAllArticles() {
		
		return articleRepository.findAll();
	}


}
