package edu.jsp.product_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.product_app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//	we have to extends (interface to interface) JpaRepository to use all the class which is predefined in it 
//	the predefined class such as 
//	1--------save(product 1 )
//	2--------findById(Integer id )
//	3-------- findAll()
//	4--------delete(product t )
//	5--------deleteById(Integer id)
	
	List<Product> findByBrand(String brand);
}
