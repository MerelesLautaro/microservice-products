package com.lautadev.products_service.repository;

import com.lautadev.products_service.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductsRepository  extends JpaRepository<Products, Long> {
}
