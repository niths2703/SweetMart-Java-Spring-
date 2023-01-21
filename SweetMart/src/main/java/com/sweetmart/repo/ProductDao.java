package com.sweetmart.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sweetmart.model.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

}