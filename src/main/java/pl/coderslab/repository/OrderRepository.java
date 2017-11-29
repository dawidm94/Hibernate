package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.coderslab.Client;
import pl.coderslab.Order;
import pl.coderslab.Product;

public interface OrderRepository extends JpaRepository <Order, Long> {
	List<Order> findByClient(Client client);
	int countByClient(Client client);
	int countByProduct(Product product);

}
