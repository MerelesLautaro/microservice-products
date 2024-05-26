package com.lautadev.products_service.controller;

import com.lautadev.products_service.model.Products;
import com.lautadev.products_service.service.IProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private IProductsService productServ;

    @PostMapping("/save")
    public String saveProduct(@RequestBody Products products){
        productServ.saveProduct(products);
        return "Product Saved successfully";
    }

    @GetMapping("/get")
    public List<Products> getProducts(){
       return productServ.getProducts();
    }

    @GetMapping("/get/{id}")
    public Products findProduct(@PathVariable Long id){
        return productServ.findProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        productServ.deleteProduct(id);
        return "Product deleted";
    }

    @PutMapping("/edit/{id}")
    public Products editProduct(@PathVariable Long id, @RequestBody Products products){
        productServ.editProduct(id,products);
        return productServ.findProduct(products.getCode());
    }

}
