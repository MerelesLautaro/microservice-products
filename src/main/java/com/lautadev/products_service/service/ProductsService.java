package com.lautadev.products_service.service;

import com.lautadev.products_service.model.Products;
import com.lautadev.products_service.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<Products> findProductsByIds(List<Long> idProducts) {
        List<Products> listProducts = this.getProducts();
        List<Products> listProductsByIDs = new ArrayList<>();

        // Convertir la lista de IDs a un Set para una búsqueda más eficiente
        Set<Long> idProductsSet = new HashSet<>(idProducts);

        // Iterar sobre la lista de productos
        for (Products product : listProducts) {
            // Si el ID del producto está en el Set de IDs, agregarlo a la lista de productos coincidentes
            if (idProductsSet.contains(product.getCode())) {
                listProductsByIDs.add(product);
            }
        }

        return listProductsByIDs;
    }
}
