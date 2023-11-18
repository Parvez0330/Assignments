package com.cg.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.productrepository.ProductRepo1;
import com.cg.entity.Product;

//import jakarta.transaction.Transactional;

@Service
//@Transactional

public class ProductService {
	@Autowired
	private ProductRepo1 repo;

	public List<Product> listAll() {
		List<Product> products = repo.findAll();
		System.out.println(products);
		return products;
	}

	public void save(Product product) {
		repo.save(product);
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public Product get(Long id) {
		return repo.findById(id).get();
	}
	
	

}