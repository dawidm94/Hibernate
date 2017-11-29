package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {
	
	Brand(String name){
		this.name = name;
	}
	
	Brand(){
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy = "brand",cascade = CascadeType.REMOVE)
	private List<Product> products = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public static Brand genRand() {
		Random rand = new Random();
		Brand result = new Brand("brand" + rand.nextInt(10));
		return result;
	}
	
	public long getId() {
		return id;
	}

	public static List<Brand> getRandList(int amount){
		List<Brand> resultList = new ArrayList<>();
		for(int i=0; i<amount; i++) {
			resultList.add(Brand.genRand());
		}
		return resultList;
	}
	
	public String toString() {
		return name;
	}
}
