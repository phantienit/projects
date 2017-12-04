/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.service;

import com.tienlun.dao.ProductDAO;
import com.tienlun.model.Product;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tienpv
 */
public class ProductService {

    @Autowired
    ProductDAO productDao;

    /*
     Lấy danh sách Sản phẩm theo Danh mục
     */
    public ArrayList<Product> getAllProductByCategory(Long categoryId) {
        return productDao.getAllProductByCategory(categoryId);
    }

    /*
     Lấy danh sách danh mục
     */
    public ArrayList<Product> getProductRandom() {
        return productDao.getProductRandom();
    }

    /*
     Lấy sản phẩm theo id
     */
    public Product getProductById(Long productId) {
        return productDao.getProductById(productId);
    }
}
