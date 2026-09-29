package edu.jsp.product_app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.product_app.entity.Product;

@RestController
@RequestMapping("/product/api")
public class ProductController {

	@Autowired
	private ProductService productservice;

	// http://localhost:8080/product/api/create
	@PostMapping("/create")
	public List<Product> saveProducts(@RequestBody List<Product> products) {
		return productservice.saveProducts(products);
	}

	@GetMapping("/getById/{id}")
	public Product getById(@PathVariable int id) {
		return productservice.getById(id);
	}

	@GetMapping("/fetchAll")
	public List<Product> fetchAll() {
		return productservice.fetchAll();
	}

	@DeleteMapping("/deleteById/{id}")
	public String deleteById(@PathVariable int id) {
		return productservice.deleteById(id);
	}

}
