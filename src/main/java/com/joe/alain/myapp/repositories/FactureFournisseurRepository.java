package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.FactureFournisseur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FactureFournisseurRepository extends CrudRepository<FactureFournisseur, Integer> {
    Page<FactureFournisseur> findAll(Pageable pageable);
}
