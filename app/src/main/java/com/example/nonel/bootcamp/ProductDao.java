package com.example.nonel.bootcamp;

import com.example.nonel.bootcamp.Model.Products;

import java.util.ArrayList;

public interface ProductDao {
    public boolean saveProduct(ArrayList<Products> person);
    public ArrayList<Products> getProducts();
    public Products getProduct(int id);
    public boolean updateProduct(int id, Products products);
}
