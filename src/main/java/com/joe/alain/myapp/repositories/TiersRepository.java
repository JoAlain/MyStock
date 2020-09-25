package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.Tiers;
import com.joe.alain.myapp.modele.TypeTiers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TiersRepository extends CrudRepository<Tiers, Integer> {
    Page<Tiers> findAll(Pageable pageable);
    List<Tiers> findByType(TypeTiers type);
}
