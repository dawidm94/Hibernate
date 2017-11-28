package pl.coderslab;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
public class OrderDao {

	@PersistenceContext
	EntityManager entityManager;
	
	public void saveOrder (Order entity) {
		entityManager.persist(entity);
	}
	
	public List<Order> getList(){
		Query query = entityManager.createQuery("SELECT b FROM Order b");
		 List<Order> Orders = query.getResultList();
	        return Orders;
	}
	
	public Order findById(long id) {
		return entityManager.find(Order.class, id);
	}
	
	public void update(Order entity) {
		entityManager.merge(entity);
	}
	
	public void delete(Order entity) {
		entityManager.remove(entityManager.contains(entity) ? 
		entity : entityManager.merge(entity));
	}
}
