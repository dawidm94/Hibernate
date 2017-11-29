package pl.coderslab;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.repository.ClientRepository;
import pl.coderslab.repository.OrderRepository;

@Controller
public class HomeController {
	
	@ModelAttribute("brands") // - w kazdym jsp jest atrybut brands do pobrania
	public List<Brand> getBrands(){
		return brandDao.getList();
	}
	
	@ModelAttribute("skills")
	public Collection<String> skills() {
	List<String> skills = new ArrayList<String>();
	skills.add("Java");
	skills.add("Php");
	skills.add("python");
	skills.add("ruby");
	return skills;
	}
	
	@Autowired
	FileLoader fileLoader;
	
	@RequestMapping("/workers")
	@ResponseBody
	public String workersAction() throws IOException {
		StringBuffer result = new StringBuffer();
		File file = fileLoader.get("workers.txt");
		Scanner scan = new Scanner(file);
		while(scan.hasNextLine()) {
			result.append(scan.nextLine()+"<br/>");
		}
		scan.close();
		return result.toString();
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping({ "/", "/hi", "/homepage" })
	@ResponseBody
	public String body() {
		return "<h1>Hello world</h1>";
	}

	@RequestMapping("/helloParam")
	@ResponseBody
	private String helloParam(@RequestParam long paramName) {
		System.out.println(paramName);
		return "My param = " + paramName;
	}

	@RequestMapping("/number/{max}")
	@ResponseBody
	private String number(@PathVariable int max, @RequestParam(defaultValue = "0") int min) {
		System.out.println(max);
		Random rand = new Random();

		return "Wylosowano: " + rand.nextInt(max - min) + min;
	}
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping("/products")
	public String showProducts(Model model) {
		List<Product> products = productDao.getList();
	        model.addAttribute("products", products);
	        return "products";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String addtocartForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
	    return "addProductForm";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String addtocart(@ModelAttribute Product product) {
		productDao.saveProduct(product);
	    return "redirect:/products";
	}
	
	@RequestMapping("/products/delete/{id}")
	public String delete(@PathVariable long id) {
	    Product prod = productDao.findById(id);
	    productDao.delete(prod);
	        return "redirect:../";
	}

	@RequestMapping("/products/edit/{id}")
	public String edit(Model model,@PathVariable long id) {
	    Product prod = productDao.findById(id);
	    List<Brand> brands = brandDao.getList();
	    model.addAttribute("product", prod);
	    model.addAttribute("brands",brands);
	        return "editForm";
	}
	
	@RequestMapping("/products/edit2")
	public String edit2(Model model,@RequestParam long brandId, @RequestParam long id, @RequestParam String name, @RequestParam double price) {
	    Product prod = productDao.findById(id);
	    Brand brand = brandDao.findById(brandId);
	    prod.setName(name);
	    prod.setPrice(price);
	    prod.setBrand(brand);
	    productDao.update(prod);
	        return "redirect:./";
	}
	
	@Autowired
	private BrandDao brandDao;
	
	@RequestMapping("/brands")
	public String showBrands(Model model) {
		List<Brand> brands = brandDao.getList();
	        model.addAttribute("brands", brands);
	        return "brands";
	}
	
	@RequestMapping("/brands/add")
	public String addBrand(HttpSession ses) {
	    Brand newBrand = Brand.genRand();
	    brandDao.saveBrand(newBrand);
	        return "redirect:./";
	}
	
	@RequestMapping("/brands/delete/{id}")
	public String deleteBrand(@PathVariable long id) {
	    Brand brand = brandDao.findById(id);
	    brandDao.delete(brand);
	        return "redirect:../";
	}

	@RequestMapping("/brands/edit/{id}")
	public String editBrand(Model model,@PathVariable long id) {
	    Brand brand = brandDao.findById(id);
	    model.addAttribute("brand", brand);
	        return "editFormBrands";
	}
	
	@RequestMapping("/brands/edit2")
	public String editBrand2(Model model,@RequestParam long id, @RequestParam String name) {
	    Brand brand = brandDao.findById(id);
	    brand.setName(name);
	    brandDao.update(brand);
	        return "redirect:./";
	}
	
	@Autowired
	ClientDao clientDao;
	
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping("/clients")
	public String showClients(Model model) {
//		List<Client> clients = clientDao.getList();
		List<Client> clients = clientRepository.findByLastNameOrFirstName("Kowalski");
	        model.addAttribute("clients", clients);
	        return "clients";
	}
	
	@RequestMapping(value = "/clients/add", method = RequestMethod.GET)
	public String addClientForm(Model model) {
		Client client = new Client();
		model.addAttribute("client",client);
	        return "addClientForm";
	}
	
	@RequestMapping(value = "/clients/add", method = RequestMethod.POST)
	public String addClient(@ModelAttribute Client client) {  
		clientDao.saveClient(client);
		return "redirect:/clients";
	}
	
	@RequestMapping(value = "/clients/edit/{id}", method = RequestMethod.GET)
	public String editClientForm(Model model, @PathVariable long id) {
		Client client = clientDao.findById(id);
	        model.addAttribute("client", client);
	        return "editClientForm";
	}
	
	@RequestMapping(value = "/clients/edit/{id}", method = RequestMethod.POST)
	public String editClient(@ModelAttribute Client client) {
			clientDao.update(client);
	        return "redirect:/clients";
	}
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping("/orders")
	public String showOrders(Model model) {
		List<Order> orders = orderRepository.findAll();
	        model.addAttribute("orders", orders);
	        return "orders";
	}
	
	@ModelAttribute(name="clients")
	public List<Client> getClients(){
		return clientDao.getList();
	}
	
	@ModelAttribute(name="products")
	public List<Product> getProducts(){
		return productDao.getList();
	}
	
	@RequestMapping(value = "/orders/add", method = RequestMethod.GET)
	public String addOrderForm(Model model) {
		Order order = new Order();
		model.addAttribute("order",order);
	        return "addOrderForm";
	}
	
	@RequestMapping(value = "/orders/add", method = RequestMethod.POST)
	public String addOrder(@ModelAttribute Order order) {  
		orderDao.saveOrder(order);
		return "redirect:/orders";
	}
}
