package edu.jsp.product_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.product_app.entity.Product;
import edu.jsp.product_app.repo.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public Product getById(int id) {
		Optional<Product> o = productRepository.findById(id);
		if (o.isPresent()) {
			return o.get();
		}
		throw new RuntimeException("id not found ");
	}

	public List<Product> fetchAll() {
		return productRepository.findAll();
	}

	public String deleteById(int id) {
		Optional<Product> o = productRepository.findById(id);

		if (o.isPresent()) {
			productRepository.deleteById(id);
		}
		throw new RuntimeException(" id not found !!!");
	}

}
