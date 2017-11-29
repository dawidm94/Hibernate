package pl.coderslab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.coderslab.Client;

public interface ClientRepository extends JpaRepository <Client, Long> {

	@Query("select c from Client c where c.firstName = :name or c.lastName = :name")
	List<Client> findByLastNameOrFirstName(@Param("name") String name);

}
