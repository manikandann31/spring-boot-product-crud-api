package edu.jsp.product_app.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		//optional class is used to avoid null checks 

		if (o.isPresent()) {
			productRepository.deleteById(id);
			return "product deleted successfully";
		}
		throw new RuntimeException(" id not found !!!");
	}
	
	public Product updateProduct(int id , Product newPrd) {
		
		Product exPrd = productRepository.findById(id).orElseThrow( ()-> new RuntimeException("id notfound !!!"));
		
		exPrd.setBrand(newPrd.getBrand());
		exPrd.setName(newPrd.getName());
		exPrd.setPrice(newPrd.getPrice());
		exPrd.setQuantity(newPrd.getQuantity());
		exPrd.setRating(newPrd.getRating());
		
		return productRepository.save(exPrd);
	}
	
	public String uploadImage(String path , MultipartFile file) throws IOException {
		
		String originalName=file.getOriginalFilename();
		
		String randomId=UUID.randomUUID().toString();
		
		String filename = randomId+
				originalName.substring(originalName.indexOf('.'));
		
		String filePath = path + File.separator + filename;
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		Files.copy(file.getInputStream(),Paths.get(filePath));
		
		return filename;
	}
	
	public Product updateProduct(int id , MultipartFile file) throws Exception {
		
		Product exPrd = productRepository.findById(id).orElseThrow( ()-> new RuntimeException("id notfound !!!"));
		
		String path = "images";
		
//		call uploadImage --> return filename;
		String fileName = uploadImage(path, file);
		
		exPrd.setImage(fileName);
		
		return productRepository.save(exPrd);
					
	}
	public List<Product> findByBrand(String brand){
		return productRepository.findByBrand(brand);
	}

	public List<Product> findByprice(double st,double end ){
		return productRepository.findByPriceBetween(st, end);
	}
	
	public List<Product> fetchByRating(double st,double end ){
		return productRepository.fetchByRatingBetween(st, end);
	}
}
