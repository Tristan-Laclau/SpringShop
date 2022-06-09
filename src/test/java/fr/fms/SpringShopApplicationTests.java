package fr.fms;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringShopApplicationTests {

	@Test
	void contextLoads() {
	}

}

// Exercices 1.1 à 1.6 :

//		Category smartphone = categoryRepository.save(new Category("Smartphone"));
//		Category tablet = categoryRepository.save(new Category("Tablet"));
//		Category pc = categoryRepository.save(new Category("PC"));

//		articleRepository.save(new Article("S10","Samsung",500,smartphone));
//		articleRepository.save(new Article("S0","Samsung",350,smartphone));
//		articleRepository.save(new Article("MI10","Xiaomi",100,smartphone));
//		
//		
//		
//		articleRepository.save(new Article("GalaxyTab","Samsung",450,tablet));
//		articleRepository.save(new Article("IPad","Apple",350,tablet));
//		articleRepository.save(new Article("R510","Asus",600,pc));

//		Category smartphone = categoryRepository.findByName("Smartphone");
//		Category tablet = categoryRepository.findByName("Tablet");
//		Category pc = categoryRepository.findByName("PC");
//		
//		for(Article article : articleRepository.findByBrandAndDescription("Samsung", "S10")) {
//		System.out.println(article);
//	}
//		
//		
//		for(Article article : articleRepository.findByBrand("Samsung")) {
//		System.out.println(article);
//	}
//		
//		articleRepository.deleteById((long) 1);
//		articleRepository.save(new Article( (long) 7, "S10","Samsung",500,smartphone));
//		articleRepository.save(new Article( (long) 2, "S0","Samsung", 300, smartphone));

//		for(Category category : categoryRepository.findAllByOrderByNameAsc()) {
//			System.out.println(category);
//		}
//		
