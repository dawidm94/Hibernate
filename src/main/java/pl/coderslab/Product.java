package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	Product(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	Product(){
		
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private double price;
	@OneToOne
	private Adnotation adnotation;
	
	@ManyToOne
	private Brand brand;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	} 
	
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public static Product genRand() {
		Random rand = new Random();
		Product result = new Product("prod" + rand.nextInt(10), rand.nextDouble()*200);
		return result;
	}
	
	public long getId() {
		return id;
	}

	public static List<Product> getRandList(int amount){
		List<Product> resultList = new ArrayList<>();
		for(int i=0; i<amount; i++) {
			resultList.add(Product.genRand());
		}
		return resultList;
	}
	
	public String toString() {
		return name + ", cena: " + price + " dolarow.";
	}
}
