package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.FactureClient;
import com.joe.alain.myapp.modele.FactureClientDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface FactureClientDetailsRepository extends CrudRepository<FactureClientDetails, Integer> {
    Page<FactureClientDetails> findAll(Pageable pageable);
    Page<FactureClientDetails> findAllByFacture(Pageable pageable,FactureClient factureClient);
}
