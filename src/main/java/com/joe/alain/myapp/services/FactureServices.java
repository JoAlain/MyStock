package com.joe.alain.myapp.services;

import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.*;
import com.joe.alain.myapp.repositories.FactureClientDetailsRepository;
import com.joe.alain.myapp.repositories.FactureClientRepository;
import com.joe.alain.myapp.repositories.FactureFournisseurRepository;
import com.joe.alain.myapp.repositories.ModePaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FactureServices {

    @Autowired
    FactureClientRepository factureClientRepository;

    @Autowired
    FactureFournisseurRepository factureFournisseurRepository;

    @Autowired
    ModePaiementRepository modePaiementRepository;

    @Autowired
    FactureClientDetailsRepository factureClientDetailsRepository;

    public List<FactureClient> findAllFClient()
    {
        List<FactureClient> result = (List<FactureClient>) factureClientRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<FactureClient>();
        }
    }

    public List<FactureFournisseur> findAllFFournisseur()
    {
        List<FactureFournisseur> result = (List<FactureFournisseur>) factureFournisseurRepository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<FactureFournisseur>();
        }
    }

    public Page<FactureClient> findAllFClient(Pageable pageable) {
        return factureClientRepository.findAll(pageable);
    }

    public Page<FactureClientDetails> findAllDetailsFClient(Pageable pageable,int facture) {
        FactureClient factureClient = new FactureClient();
        factureClient.setId(facture);
        return factureClientDetailsRepository.findAllByFacture(pageable,factureClient);
    }

    public List<ModeDePaiement> findAllModepaiement() {
        return modePaiementRepository.findAll();
    }

    public Page<FactureFournisseur> findAllFFournisseur(Pageable pageable) {
        return factureFournisseurRepository.findAll(pageable);
    }

    public FactureClient getFClientById(Integer id) throws Exception
    {
        try {
            Optional<FactureClient> employee = factureClientRepository.findById(id);

            if (employee.isPresent()) {
                return employee.get();
            } else {
                throw new Exception(Constant.noRecordFound);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public FactureClientDetails getFClientDById(Integer id) throws Exception
    {
        Optional<FactureClientDetails> entity = factureClientDetailsRepository.findById(id);

        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public double calculerSommeMontant(List<FactureClientDetails> array)throws Exception{
        double somme = 0;
        try{

            for (FactureClientDetails factureClientDetails: array){
                somme += factureClientDetails.getMontant();
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return somme;
    }

    public FactureFournisseur getFFournisseurById(Integer id) throws Exception
    {
        Optional<FactureFournisseur> employee = factureFournisseurRepository.findById(id);

        if(employee.isPresent()) {
            return employee.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public FactureClient saveFClient(FactureClient entity){
        factureClientRepository.save(entity);
        return entity;
    }

    public FactureClientDetails saveFClientDTS(FactureClientDetails entity){
        factureClientDetailsRepository.save(entity);
        return entity;
    }

    public String saveFFournisseur(FactureFournisseur entity){
        factureFournisseurRepository.save(entity);
        return "";
    }

    public void deleteFClientById(Integer id) throws Exception
    {
        Optional<FactureClient> unite = factureClientRepository.findById(id);

        if(unite.isPresent())
        {
            factureClientRepository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public void deleteFFournisseurById(Integer id) throws Exception
    {
        Optional<FactureFournisseur> unite = factureFournisseurRepository.findById(id);

        if(unite.isPresent())
        {
            factureFournisseurRepository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
