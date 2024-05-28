package com.lautadev.products_service.service;

import com.lautadev.products_service.model.Products;

import java.util.List;

public interface IProductsService {
    public void saveProduct(Products products);
    public List<Products> getProducts();
    public Products findProduct(Long id);
    public void deleteProduct(Long id);
    public void editProduct(Long id, Products products);
    public List<Products> findProductsByIds(List<Long> idProducts);
}
