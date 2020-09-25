package com.joe.alain.myapp.services;

import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.*;
import com.joe.alain.myapp.repositories.TiersRepository;
import com.joe.alain.myapp.repositories.TypeTiersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiersServices {
    @Autowired
    TiersRepository tiersRepository;


    @Autowired
    TypeTiersRepository typeTiersRepository;

    public Page<Tiers> findAll(Pageable pageable)
    {
        return tiersRepository.findAll(pageable);
    }

    public List<TypeTiers> findAllType()
    {
        return typeTiersRepository.findAll();
    }

    public List<Tiers> findAllFournisseur()throws Exception{
        TypeTiers typeTiers = new TypeTiers();
        typeTiers.setId(2);
        return tiersRepository.findByType(typeTiers);
    }
    public List<Tiers> findAllClient()throws Exception{
        TypeTiers typeTiers = new TypeTiers();
        typeTiers.setId(1);
        return tiersRepository.findByType(typeTiers);
    }
    public Tiers getById(Integer id) throws Exception
    {
        Optional<Tiers> employee = tiersRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public String save(Tiers entity){
        tiersRepository.save(entity);
        return "";
    }

    public void deleteById(Integer id) throws Exception
    {
        Optional<Tiers> entity = tiersRepository.findById(id);

        if(entity.isPresent())
        {
            tiersRepository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

}
