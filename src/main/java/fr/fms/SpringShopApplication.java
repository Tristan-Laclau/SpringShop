package fr.fms;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopApplication implements CommandLineRunner {

	private static IBusinessImpl job = new IBusinessImpl();

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
		for(Article article : job.getAllArticles()) {
			System.out.println(article);
			System.out.println("------------------------------------------------------");
		}
	}

	public void displayAllArticlesByPage() {
		ArrayList<Article> listArticle = new ArrayList<Article>();
		int index = 0;
		int input = -1;

		for(Article article : job.getAllArticles()) {
			listArticle.set(index, article);
			index ++;
		}

		while(!scan.hasNextInt()) scan.next();
		input = scan.nextInt();

		while (input != 3) {


			for (int i = 0; i < 5 ; i ++) {
				System.out.println(listArticle.get(i));
			}
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
