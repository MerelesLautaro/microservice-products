package com.lautadev.products_service.service;

import com.lautadev.products_service.model.Products;
import com.lautadev.products_service.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements IProductsService {
    @Autowired
    private IProductsRepository productRepo;


    @Override
    public void saveProduct(Products products) {
        productRepo.save(products);
    }

    @Override
    public List<Products> getProducts() {
        return productRepo.findAll();
    }

    @Override
    public Products findProduct(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void editProduct(Long id, Products products) {
        Products productsEdit = this.findProduct(id);

        productsEdit.setName(products.getName());
        productsEdit.setBrand(products.getBrand());
        productsEdit.setIndividualPrice(products.getIndividualPrice());

        this.saveProduct(productsEdit);
    }
}
