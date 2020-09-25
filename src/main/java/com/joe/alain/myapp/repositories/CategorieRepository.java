package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.Categorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface CategorieRepository extends CrudRepository<Categorie, Integer> {
    Page<Categorie> findAll(Pageable pageable);
}
