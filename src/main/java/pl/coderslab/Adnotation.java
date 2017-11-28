package pl.coderslab;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Adnotation")
public class Adnotation {
	
	@Id
	@GeneratedValue
	private long id;
	private String description;

}
