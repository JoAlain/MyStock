/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.UserD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Doudou TIARILALA <doudou.tiarilala@inqipit.fr>
 */
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface UserRepositoryD extends CrudRepository<UserD, Integer> {

}
