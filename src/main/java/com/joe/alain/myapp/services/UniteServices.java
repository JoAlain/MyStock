package com.joe.alain.myapp.services;


import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.Unite;
import com.joe.alain.myapp.repositories.UniteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniteServices {

    @Autowired
    UniteRepository repository;

    public List<Unite> findAll()
    {
        List<Unite> result = (List<Unite>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Unite>();
        }
    }

    public Page<Unite> getPaginatedUnites(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public Unite getUniteById(Integer id) throws Exception
    {
        Optional<Unite> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public String saveUnite(Unite entity){
        repository.save(entity);
        return "";
    }

    public void deleteUniteById(Integer id) throws Exception
    {
        Optional<Unite> unite = repository.findById(id);

        if(unite.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
