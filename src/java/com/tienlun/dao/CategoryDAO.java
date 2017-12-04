/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.dao;

import com.tienlun.model.Category;
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
public class CategoryDAO {

    private static final Logger logger = Logger.getLogger(UsersDAO.class);

    public ArrayList<Category> getAllCategory() {
        ArrayList<Category> lstCategory = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Category WHERE isActive = :isActive");
            query.setLong("isActive", Constants.Status.ACTIVE);
            lstCategory = (ArrayList<Category>) query.list();
            transaction.commit();
            return lstCategory;
        } catch (Exception ex) {
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return lstCategory;
        }
    }

    // phương thức thêm Category
    public boolean insertUser(Category category) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return false;
        }
    }
}
