/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.alain.myapp.controllers;

import java.util.List;

import com.joe.alain.myapp.modele.User;
import com.joe.alain.myapp.modele.UserD;
import com.joe.alain.myapp.services.UserServiceD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class UserController {

    @Autowired
    UserServiceD userService;

    @GetMapping(path = "/userlist")
    @ResponseBody
    public List<UserD> userList() {
        return (List<UserD>) userService.findAll();
    }

}
