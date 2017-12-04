/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.service;

import com.tienlun.dao.GenericHiberDAO;
import com.tienlun.dao.UsersDAO;
import com.tienlun.form.UsersForm;
import com.tienlun.model.Users;
import com.tienlun.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author ict-os27
 */
public class UsersService extends GenericHiberDAO {

    @Autowired
    UsersDAO usersDAO;

    public Users login(String email, String pass) {
        return usersDAO.login(email, pass);
    }

    public boolean checkEmail(String email) {
        return usersDAO.checkEmail(email);
    }
    
    public boolean checkUser(String userName) {
        return usersDAO.checkUser(userName);
    }

    public boolean insertUser(Users u) {
        return usersDAO.insertUser(u);
    }

    public void formToBO(UsersForm form, Users bo) {
        if (form.getUserName() != null && !"".equals(form.getUserName())) {
            bo.setUserName(form.getUserName());
        }
        if (form.getPassword() != null && !"".equals(form.getPassword())) {
            bo.setPassword(form.getPassword());
        }
        if (form.getEmail() != null && !"".equals(form.getEmail())) {
            bo.setEmail(form.getEmail());
        }
        if (form.getFirstName() != null && !"".equals(form.getFirstName())) {
            bo.setFirstName(form.getFirstName());
        }
        if (form.getLastName() != null && !"".equals(form.getLastName())) {
            bo.setLastName(form.getLastName());
        }
        if (form.getBirthDate() != null) {
            bo.setBirthDate(form.getBirthDate());
        }
        if (form.getPhone() != null && !"".equals(form.getPhone())) {
            bo.setPhone(form.getPhone());
        }
        if (form.getImageLink() != null && !"".equals(form.getImageLink())) {
            bo.setImageLink(form.getImageLink());
        }
        if (form.getAddress() != null && !"".equals(form.getAddress())) {
            bo.setAddress(form.getAddress());
        }
        if (form.getIsActive() != null && form.getIsActive() != -1L) {
            bo.setIsActive(Constants.Status.ACTIVE);
        }
        if (form.getCreateBy() != null && form.getCreateBy() != -1L) {
            bo.setCreateBy(form.getCreateBy());
        }
        if (form.getCreateDate() != null) {
            bo.setCreateDate(getSysdate());
        }
        if (form.getModifyBy() != null && form.getModifyBy() != -1L) {
            bo.setModifyBy(form.getModifyBy());
        }
        if (form.getModifyDate() != null) {
            bo.setModifyDate(getSysdate());
        }
    }
}
