package pl.coderslab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class ProductDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveProduct (Product entity) {
		entityManager.persist(entity);
	}
	
	public List<Product> getList(){
		Query query = entityManager.createQuery("SELECT p FROM Product p");
		 List<Product> products = query.getResultList();
	        return products;
	}
	
	public Product findById(long id) {
		return entityManager.find(Product.class, id);
	}
	
	public void update(Product entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Product entity) {
		entityManager.remove(entityManager.contains(entity) ? 
		entity : entityManager.merge(entity));
	}
}
