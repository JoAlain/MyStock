package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.Mouvement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface StockRepository extends CrudRepository<Mouvement, Integer> {
    Page<Mouvement> findAll(Pageable pageable);
    Page<Mouvement> findByType(Pageable pageable, String type);
}
