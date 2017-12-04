/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.dao;

import com.tienlun.util.CommonUtils;
import com.tienlun.util.HibernateUtil;
import java.util.Date;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ict-os27
 */
public class GenericHiberDAO {

    private static final Logger logger = Logger.getLogger(GenericHiberDAO.class);

    public GenericHiberDAO() {
    }

    public Date getSysdate() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query = session.createSQLQuery("SELECT SYSDATE()");
            Date date = (Date) query.uniqueResult();
            transaction.commit();
            return date;
        } catch (Exception ex) {
            transaction.rollback();
            logger.log(Priority.ERROR, CommonUtils.getStackTrace(ex));
            return null;
        }
    }
}
