package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class BrandConverter implements Converter<String, Brand>{

	@Autowired
	private BrandDao brandDao;
	
	@Override
	public Brand convert(String source) {
		Brand brand = brandDao.findById(Integer.parseInt(source));
		return brand;
	}
	
}
