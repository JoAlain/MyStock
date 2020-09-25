package com.joe.alain.myapp.services;


import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.SousCategorie;
import com.joe.alain.myapp.repositories.SousCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SousCategorieServices {

    @Autowired
    SousCategorieRepository repository;

    public List<SousCategorie> findAll()
    {
        List<SousCategorie> result = (List<SousCategorie>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<SousCategorie>();
        }
    }

    public String save(SousCategorie entity){
        repository.save(entity);
        return "";
    }

    public Page<SousCategorie> getPaginatedSousCategories(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public SousCategorie getById(Integer id) throws Exception
    {
        Optional<SousCategorie> entity = repository.findById(id);

        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public void deleteById(Integer id) throws Exception
    {
        Optional<SousCategorie> unite = repository.findById(id);
        if(unite.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
