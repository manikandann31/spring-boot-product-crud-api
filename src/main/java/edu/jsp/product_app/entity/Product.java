package edu.jsp.product_app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String brand;
	private double price;
	private double rating;
	private int quantity;
	private String image;
}
