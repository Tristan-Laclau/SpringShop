package fr.fms;

import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.dao.ArticleRepository;
import fr.fms.dao.CategoryRepository;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ArticleRepository articleRepository;

	public Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		mainMenu();
	}

	public void displayAllArticles() {
		System.out.println("------------------------------------------------------");
		for(Article article : articleRepository.findAll()) {
			System.out.println(article);
			System.out.println("------------------------------------------------------");
		}
	}
	
	public void displayAllArticlesByPage() {
		Article[] listArticle = new Article[];
		int index = 0;
		
		for(Article article : articleRepository.findAll()) {
			listArticle[index] = article;
			index ++;
		}
		
	}

	public void mainMenu() {

		System.out.println("Bienvenue dans SpringShop, que voulez vous faire?");
		System.out.println("1 : Afficher la liste des articles");
		System.out.println("2 : Afficher les articles par page");


		int choice;

		while(!scan.hasNextInt()) scan.next();

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			displayAllArticles();
			break;
		
		case 2:
			displayAllArticlesByPage();
			break;
		}

	}





}
