package com.joe.alain.myapp.repositories;

import com.joe.alain.myapp.modele.Article;
import com.joe.alain.myapp.modele.Depot;
import com.joe.alain.myapp.modele.EtatStock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface EtatStockRepository extends CrudRepository<EtatStock, String> {
    Page<EtatStock> findAll(Pageable pageable);
    EtatStock findByArticleAndDepot(Article a, Depot d);
}
