/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.dao;

import com.tienlun.model.Users;
import com.tienlun.util.CommonUtils;
import com.tienlun.util.Constants;
import com.tienlun.util.HibernateUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author tienpv
 */
public class UsersDAO {

    private static final Logger logger = Logger.getLogger(UsersDAO.class);

    // kiểm tra email tồn tại chưa
    public boolean checkEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Users where email = :email");
            query.setString("email", email);
            Users user = (Users) query.uniqueResult();
            transaction.commit();
            return user != null;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return false;
        }
    }

    // kiểm tra user tồn tại chưa
    public boolean checkUser(String userName) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Users where userName = :userName");
            query.setString("userName", userName);
            Users user = (Users) query.uniqueResult();
            transaction.commit();
            return user != null;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return false;
        }
    }

    // phương thức thêm tài khoản
    public boolean insertUser(Users user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            transaction.commit();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return false;
        }
    }

    // kiểm tra đăng nhập
    public Users login(String email, String pass) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createQuery("from Users WHERE (email = :email OR userName = :email) AND password = :password AND isActive = :isActive");
            query.setString("email", email);
            query.setString("password", pass);
            query.setLong("isActive", Constants.Status.ACTIVE);
            Users user = (Users) query.uniqueResult();
            transaction.commit();
            return user;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return null;
        }
    }
}
