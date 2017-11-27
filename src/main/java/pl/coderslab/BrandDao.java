package pl.coderslab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class BrandDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveBrand (Brand entity) {
		entityManager.persist(entity);
	}
	
	public List<Brand> getList(){
		Query query = entityManager.createQuery("SELECT b FROM Brand b");
		 List<Brand> brands = query.getResultList();
	        return brands;
	}
	
	public Brand findById(long id) {
		return entityManager.find(Brand.class, id);
	}
	
	public void update(Brand entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Brand entity) {
		entityManager.remove(entityManager.contains(entity) ? 
		entity : entityManager.merge(entity));
	}
}
