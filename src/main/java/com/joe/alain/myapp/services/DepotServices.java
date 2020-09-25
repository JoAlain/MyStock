package com.joe.alain.myapp.services;

import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.Depot;
import com.joe.alain.myapp.repositories.DepotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepotServices {
    @Autowired
    DepotRepository repository;

    public List<Depot> findAll()
    {
        List<Depot> result = (List<Depot>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Depot>();
        }
    }

    public Page<Depot> getDepot(Pageable pageable) {
        return repository.findAll(pageable);
    }


    public Depot getById(Integer id) throws Exception
    {
        Optional<Depot> employee = repository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public String save(Depot entity){
        repository.save(entity);
        return "";
    }

    public void deleteById(Integer id) throws Exception
    {
        Optional<Depot> unite = repository.findById(id);

        if(unite.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
