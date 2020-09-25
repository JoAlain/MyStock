package com.joe.alain.myapp.services;


import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.Categorie;
import com.joe.alain.myapp.repositories.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServices {

    @Autowired
    CategorieRepository repository;

    public List<Categorie> findAll()
    {
        List<Categorie> result = (List<Categorie>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Categorie>();
        }
    }
    public String save(Categorie entity){
        repository.save(entity);
        return "";
    }

    public Page<Categorie> getPaginatedCategories(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Categorie getById(Integer id) throws Exception
    {
        Optional<Categorie> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public void deleteById(Integer id) throws Exception
    {
        Optional<Categorie> unite = repository.findById(id);
        if(unite.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
