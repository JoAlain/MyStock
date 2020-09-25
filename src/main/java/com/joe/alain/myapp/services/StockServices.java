package com.joe.alain.myapp.services;


import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.Article;
import com.joe.alain.myapp.modele.Depot;
import com.joe.alain.myapp.modele.EtatStock;
import com.joe.alain.myapp.modele.Mouvement;
import com.joe.alain.myapp.repositories.EtatStockRepository;
import com.joe.alain.myapp.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StockServices {
    @Autowired
    StockRepository repository;

    @Autowired
    EtatStockRepository stockRepository;



    public List<Mouvement> findAll()
    {
        List<Mouvement> result = (List<Mouvement>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Mouvement>();
        }
    }

    public Page<Mouvement> getMouvement(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Mouvement> getEntree(Pageable pageable) {
        return repository.findByType(pageable, "entree");
    }

    public Page<Mouvement> getSortie(Pageable pageable) {
        return repository.findByType(pageable, "sortie");
    }

    public Page<EtatStock> getEtatStock(Pageable pageable) {
        return stockRepository.findAll(pageable);
    }

    public Mouvement getById(Integer id) throws Exception
    {
        Optional<Mouvement> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public String save(Mouvement entity){
        repository.save(entity);
        return "";
    }

    public void deleteById(Integer id) throws Exception
    {
        Optional<Mouvement> unite = repository.findById(id);

        if(unite.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public double getResteStock(Article article, Depot depot) throws Exception{
        EtatStock etatStock =  stockRepository.findByArticleAndDepot(article, depot);
        return etatStock.getReste();
    }

    public EtatStock getStockById(String article) throws Exception{
        Optional<EtatStock> etatStock = stockRepository.findById(article);

        if(etatStock.isPresent()) {
            return etatStock.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
