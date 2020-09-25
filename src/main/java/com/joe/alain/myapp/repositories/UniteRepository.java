package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.Unite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface UniteRepository extends CrudRepository<Unite, Integer> {
    Page<Unite> findAll(Pageable pageable);
}
