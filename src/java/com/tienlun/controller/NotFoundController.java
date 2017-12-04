/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienlun.controller;

import java.util.ResourceBundle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author ict-os27
 */
@Controller
@RequestMapping(value = "/")
public class NotFoundController {

    private final ResourceBundle rb = ResourceBundle.getBundle("config");

    @RequestMapping(value = "/404.html")
    public String index(Model m) {
        return rb.getString("page.404");
    }
}
