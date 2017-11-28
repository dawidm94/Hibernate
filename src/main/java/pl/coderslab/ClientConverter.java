package pl.coderslab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class ClientConverter implements Converter<String, Client>{

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public Client convert(String source) {
		Client client = clientDao.findById(Integer.parseInt(source));
		return client;
	}
	
}
