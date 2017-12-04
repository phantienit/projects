/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.controller;

import com.tienlun.form.UsersForm;
import com.tienlun.model.Users;
import com.tienlun.service.CategoryService;
import com.tienlun.service.ProductService;
import com.tienlun.service.UsersService;
import com.tienlun.util.Constants;
import com.tienlun.validation.UserValidation;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author tienpv
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    private final ResourceBundle rb = ResourceBundle.getBundle("config");

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/index.html")
    public String index(Model m) {
        m.addAttribute("lstCategory", categoryService.getAllCategory());
        m.addAttribute("lstProductRandom", productService.getProductRandom());
        return rb.getString("page.index");
    }

    @RequestMapping(value = "/login.html")
    public String login(Model m) {
        m.addAttribute("incorrect", false);
        return rb.getString("page.login");
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.POST)
    public String doLogin(HttpServletRequest request, HttpServletResponse response,
            Users usersForm, Model m, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        Users users = usersService.login(usersForm.getEmail(), usersForm.getPassword());

        if (users != null) {
            HttpSession session = request.getSession();
            session.setAttribute("users", users);
            return rb.getString("page.index");
        } else {
            m.addAttribute("incorrect", true);
            return rb.getString("page.login");
        }
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.POST)
    public String doRegister(UsersForm userForm, BindingResult result) {
        UserValidation validation = new UserValidation();
        validation.validate(userForm, result);
        if (result.hasErrors()) {
            return rb.getString("page.login");
        }
        if (usersService.checkEmail(userForm.getEmail())) {
            return rb.getString("page.login");
        }
        Users user = new Users();
        usersService.formToBO(userForm, user);
        if (usersService.insertUser(user)) {
            return rb.getString("page.login");
        }
        return rb.getString("page.login");
    }

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public ResponseEntity checkUserNameAndEmail(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        if (userName != null && !"".equals(userName)) {
            if (usersService.checkUser(userName)) {
                return new ResponseEntity(Constants.Duplicate.ERROR, HttpStatus.OK);
            } else {
                return new ResponseEntity(Constants.Duplicate.OK, HttpStatus.OK);
            }
        }

        String email = request.getParameter("email");
        if (email != null && !"".equals(email)) {
            if (usersService.checkEmail(email)) {
                return new ResponseEntity(Constants.Duplicate.ERROR, HttpStatus.OK);
            } else {
                return new ResponseEntity(Constants.Duplicate.OK, HttpStatus.OK);
            }
        }
        return new ResponseEntity(Constants.Duplicate.ERROR, HttpStatus.OK);
    }
}
