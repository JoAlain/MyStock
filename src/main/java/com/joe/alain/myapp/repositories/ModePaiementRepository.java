package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.ModeDePaiement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModePaiementRepository extends CrudRepository<ModeDePaiement, Integer> {
    List<ModeDePaiement> findAll();
}
