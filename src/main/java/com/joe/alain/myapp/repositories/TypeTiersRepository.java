package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.TypeTiers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TypeTiersRepository extends CrudRepository<TypeTiers, Integer> {
    List<TypeTiers> findAll();
}
