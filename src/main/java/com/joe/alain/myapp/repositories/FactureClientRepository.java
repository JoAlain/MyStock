package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.FactureClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FactureClientRepository extends CrudRepository<FactureClient, Integer> {
    Page<FactureClient> findAll(Pageable pageable);
}
