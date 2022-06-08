package fr.fms.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.fms.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{
	public Optional<Category> findById(Long id);

}
