package fr.fms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.fms.business.IBusinessImpl;
import fr.fms.entities.Article;
import fr.fms.entities.Category;

@SpringBootApplication
public class SpringShopApplication implements CommandLineRunner {

	@Autowired
	private IBusinessImpl job;


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

		//		Page<Article> articles = articleRepository.findAll(PageRequest.of(2, 5));
		//	       
		//        for(Article article : articles) {
		//            System.out.println(article);
		//        }
		//        System.out.println(articles.getTotalPages());
	}

	public void articleMenu() {

		System.out.println("Quelle action voulez-vous effectuer?");
		System.out.println("1 : Ajouter un article");
		System.out.println("2 : Supprimer un article");
		System.out.println("3 : Mettre à jour un article");
		System.out.println("4 : Lire un article");
		System.out.println("5 : Retour au menu");


		int choice;

		while(!scan.hasNextInt()) scan.next();

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			addArticle();
			break;
		case 2:
			removeArticle();
			break;
		case 3:
			updateArticle();
			break;
		case 4:
			readArticle();
			break;
		default:

			break;
		}
	}

	public void addArticle() {


		System.out.println("Entrez le nom de l'article");
		String description = scan.next();

		System.out.println("Entrez une marque");
		String brand = scan.next();

		System.out.println("Entrez un prix");
		double price = scan.nextDouble();

		job.createArticle(description,brand,price);

	}

	public void removeArticle() {

		System.out.println("Entrez l'id de l'article à supprimer");

		displayAllArticles();

		int idChoice = scan.nextInt();

		job.deleteArticleById(Long.valueOf(idChoice));
	}

	public void updateArticle() {

		System.out.println("Entrez l'id de l'article à modifier");

		displayAllArticles();

		int idArticle = scan.nextInt();

		System.out.println("Entrez le nouveau nom de l'article");
		String newDescription = scan.next();

		System.out.println("Entrez la nouvelle marque de l'article");
		String newBrand = scan.next();

		System.out.println("Entrez le nouveau prix de l'article");
		double newPrice = scan.nextDouble();

		displayAllCategories();
		System.out.println("Entrez la nouvelle catégorie de l'article");
		String newCategory = scan.next();

		job.updateArticle(Long.valueOf(idArticle), newDescription, newBrand, newPrice, newCategory);

	}

	public void readArticle() {

		System.out.println("Entrez l'ID de l'article que vous souhaitez consulter");
		int idArticle = scan.nextInt();

		for (Article article : job.getAllArticles()) {
			if(article.getId()==Long.valueOf(idArticle)) System.out.println(article);
		}
	}

	public void categoryMenu() {

		System.out.println("Quelle action voulez-vous effectuer?");
		System.out.println("1 : Ajouter une catégorie");
		System.out.println("2 : Supprimer une catégorie");
		System.out.println("3 : Mettre à jour une catégorie");
		System.out.println("4 : Lire une catégorie");
		System.out.println("5 : Retour au menu");


		int choice;

		while(!scan.hasNextInt()) scan.next();

		choice = scan.nextInt();

		switch (choice) {
		case 1:
			addCategory();
			break;
		case 2:
			removeCategory();
			break;
		case 3:
			updateCategory();
			break;
		case 4:
			readCategory();
			break;
		default:

			break;
		}
	}

	public void addCategory() {
		System.out.println("Entrez le nom de la catégorie");
		String name = scan.next();

		job.createCategory(name);
	}
	
	public void removeCategory() {

		System.out.println("Entrez l'id de la catégorie à supprimer");

		displayAllCategories();

		int idChoice = scan.nextInt();

		job.deleteCategoryById(Long.valueOf(idChoice));
	}

	public void updateCategory() {

		System.out.println("Entrez l'id de la catégorie à modifier");

		displayAllCategories();

		int idArticle = scan.nextInt();

		System.out.println("Entrez le nouveau nom de la catégorie");
		String newName = scan.next();

		job.updateCategory(Long.valueOf(idArticle), newName);

	}

	public void readCategory() {

		System.out.println("Entrez l'ID de la catégorie que vous souhaitez consulter");
		int idCategory = scan.nextInt();

		for (Category category : job.getAllCategories()) {
			if(category.getId()==Long.valueOf(idCategory)) System.out.println(category);
		}
	}


	public void displayAllCategories() {
		System.out.println("------------------------------------------------------");
		for(Category category : job.getAllCategories()) {
			System.out.println(category);
			System.out.println("------------------------------------------------------");
		}
	}

	public void displayArticlesByCategory() {

	}

	public void mainMenu() {

		System.out.print("Bienvenue dans SpringShop! ");

		boolean leaving = false;

		while(!leaving) {

			System.out.println("Que voulez-vous faire?");
			System.out.println("1 : Afficher la liste des articles");
			System.out.println("2 : Afficher les articles par page");
			System.out.println("3 : Accéder au menu des articles");
			System.out.println("4 : Accéder au menu des catégories");
			System.out.println("5 : Rechercher un article par catégorie");
			System.out.println("6 : Quitter l'application");


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
			case 3:
				articleMenu();
				break;
			case 4:
				categoryMenu();
				break;
			case 5:
				displayArticlesByCategory();
				break;
			default:
				leaving=true;
				break;
			}
		}
	}





}
