package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.Depot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DepotRepository extends CrudRepository<Depot, Integer> {
    Page<Depot> findAll(Pageable pageable);
}
