package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ProductConverter implements Converter<String, Product>{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public Product convert(String source) {
		Product product = productDao.findById(Integer.parseInt(source));
		return product;
	}
	
}
