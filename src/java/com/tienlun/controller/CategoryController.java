/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.controller;

import com.tienlun.service.CategoryService;
import com.tienlun.service.ProductService;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author tienpv
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    private final ResourceBundle rb = ResourceBundle.getBundle("config");

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/category_{categoryId}.html")
    public String index(Model m, @PathVariable("categoryId") Long categoryId) {
        m.addAttribute("lstProduct", productService.getAllProductByCategory(categoryId));
        m.addAttribute("lstCategory", categoryService.getAllCategory());
        return rb.getString("page.shop");
    }
}
