/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.alain.myapp.services;

import java.util.List;

import com.joe.alain.myapp.modele.UserD;
import com.joe.alain.myapp.repositories.UserRepositoryD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Doudou TIARILALA <doudou.tiarilala@inqipit.fr>
 * 21 juil. 2020 14:35:34
 */
@Service
public class UserServiceD {

    @Autowired
    UserRepositoryD userRepository;

    public List<UserD> findAll() {
        return (List<UserD>) userRepository.findAll();
    }
}
