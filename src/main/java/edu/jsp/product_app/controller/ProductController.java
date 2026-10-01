package edu.jsp.product_app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.jsp.product_app.entity.Product;
import edu.jsp.product_app.service.ProductService;

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
	
	@PutMapping("/update/{id}")
	public Product updateProduct(@PathVariable int id ,@RequestBody Product newPrd ) {
		return productservice.updateProduct(id, newPrd);
	}
	
	@PutMapping("/updateimage/{id}")
	public Product updateProduct(@PathVariable int id , @RequestBody MultipartFile file) throws Exception{
		return productservice.updateProduct(id, file);
	}
	@GetMapping("/findbybrand/{brand}")
	public List<Product> findByBrand(@PathVariable String brand) {
		return productservice.findByBrand(brand);
	}
	@GetMapping("/findbyPriceBetween/{start}/{end}")
	public List<Product> findByPriceBetween(@PathVariable double start,@PathVariable double end) {
		return productservice.findByprice(start,end);
	}
	
	@GetMapping("/fetchByRatingBetween/{start}/{end}")
	public List<Product> fetchByRatingBetween(@PathVariable double start,@PathVariable double end) {
		return productservice.fetchByRating(start,end);
	}

}
