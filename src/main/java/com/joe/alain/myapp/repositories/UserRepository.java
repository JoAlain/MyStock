package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
}