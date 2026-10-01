package edu.jsp.product_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
//	there are two ways to give values to sql 
//	1. named parameter  -------- select p from product p where price between :start and :end
//	1. positional parameter  --- select p from product p where price between ?1 and :?2
	
	List<Product> findByPriceBetween(double start , double end);
	
//	if we write the syntax for acceptable methods such as find , sb will auto create the sql querries 
//	if we want to write out own jpql querry , we can use annotaiton @query and @param
	
	@Query(value = "select p from Product p where p.rating between :start and :end")
	List<Product> fetchByRatingBetween(@Param("start")double st, @Param("end") double end);
}
