package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.SousCategorie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface SousCategorieRepository extends CrudRepository<SousCategorie, Integer> {
    Page<SousCategorie> findAll(Pageable pageable);
}
