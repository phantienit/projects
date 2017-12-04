/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.service;

import com.tienlun.dao.CategoryDAO;
import com.tienlun.model.Category;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author tienpv
 */
public class CategoryService {

    @Autowired
    CategoryDAO categoryDao;
    
    /*
    Lấy danh sách danh mục
    */
    public ArrayList<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
