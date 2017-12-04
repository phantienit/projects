/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.dao;

import com.tienlun.model.Product;
import com.tienlun.util.CommonUtils;
import com.tienlun.util.Constants;
import com.tienlun.util.HibernateUtil;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tienpv
 */
public class ProductDAO {

    private static final Logger logger = Logger.getLogger(UsersDAO.class);

    public ArrayList<Product> getAllProductByCategory(Long categoryId) {
        ArrayList<Product> lstProduct = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Product WHERE categoryId = :categoryId AND isActive = :isActive");
            query.setLong("categoryId", categoryId);
            query.setLong("isActive", Constants.Status.ACTIVE);
            lstProduct = (ArrayList<Product>) query.list();
            transaction.commit();
            return lstProduct;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return lstProduct;
        }
    }

    public ArrayList<Product> getProductRandom() {
        ArrayList<Product> lstProduct = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Product WHERE isActive = :isActive ORDER BY rand()");
            query.setLong("isActive", Constants.Status.ACTIVE);
            query.setMaxResults(6);
            lstProduct = (ArrayList<Product>) query.list();
            transaction.commit();
            return lstProduct;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return lstProduct;
        }
    }

    public Product getProductById(Long productId) {
        Product product = new Product();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("FROM Product WHERE productId = :productId AND isActive = :isActive");
            query.setLong("productId", productId);
            query.setLong("isActive", Constants.Status.ACTIVE);
            product = (Product) query.uniqueResult();
            transaction.commit();
            return product;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return product;
        }
    }

}
