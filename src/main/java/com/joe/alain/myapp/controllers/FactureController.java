package com.joe.alain.myapp.controllers;

import com.joe.alain.myapp.modele.*;
import com.joe.alain.myapp.services.FactureServices;
import com.joe.alain.myapp.services.TiersServices;
import com.joe.alain.myapp.util.Constante;
import com.joe.alain.myapp.util.Utilitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class FactureController {

    @Autowired
    FactureServices services;

    @Autowired
    TiersServices tiersServices;


    @PostMapping("/add/fclient")
    public String saveFClient(Model model, FactureClient entity){
        try {
            model.addAttribute("successFlash","Success");
            entity.setEtat(1);
            entity.setCreation(Utilitaire.dateDuJourSql());
            FactureClient factureClient = services.saveFClient(entity);
            return "redirect:/fcDetails/"+factureClient.getId();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "";
    }

    @PostMapping("/add/fclientdts")
    public String saveFClientDTS(Model model, FactureClientDetails entity){
        try {
            model.addAttribute("successFlash","Success");
            entity.setMontant(entity.getQuantite()*entity.getProduit().getPrix());
            FactureClientDetails factureClient = services.saveFClientDTS(entity);
            return "redirect:/fcDetails/"+factureClient.getFacture().getId();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "";
    }

    @GetMapping(path = "/fcDetails/{id}")
    @ResponseBody
    public ModelAndView fClientDetails(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("f-client-details");
        PageRequest pageable = PageRequest.of(page - 1, 100);
        Page<FactureClientDetails> unitePage = services.findAllDetailsFClient(pageable, id.get());
        int totalPages = unitePage.getTotalPages();
        double total = services.calculerSommeMontant(unitePage.toList());
        modelAndView.addObject("total",total);
        modelAndView.addObject("fclientdts",unitePage.getContent());


        modelAndView.addObject("title","Details Facture");
        if (id.isPresent()) {
            FactureClient entity = services.getFClientById(id.get());
            modelAndView.addObject("fclient",entity);
        }
        return modelAndView;
    }

    @PostMapping("/add/ffournisseur")
    public String saveFFournisseur(Model model, FactureFournisseur entity){
        try {
            model.addAttribute("successFlash","Success");
            services.saveFFournisseur(entity);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/ffournisseur";
    }

    @GetMapping(path = {"/fclient", "/fclient/{id}"})
    @ResponseBody
    public ModelAndView listFClient(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("f-client");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<FactureClient> unitePage = services.findAllFClient(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("fclients",unitePage.getContent());

        modelAndView.addObject("title","Facture");
        if (id.isPresent()) {
            FactureClient entity = services.getFClientById(id.get());
            modelAndView.addObject("fclient",entity);
        } else {
            FactureClient entity = new FactureClient();
            modelAndView.addObject("fclient",entity);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/ffournisseur", "/ffournisseur/{id}"})
    @ResponseBody
    public ModelAndView listFFournisseur(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("f-fournisseur");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<FactureFournisseur> unitePage = services.findAllFFournisseur(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("ffournisseurs",unitePage.getContent());

        modelAndView.addObject("title","Tiers");
        if (id.isPresent()) {
            FactureFournisseur entity = services.getFFournisseurById(id.get());
            modelAndView.addObject("ffournisseur",entity);
        } else {
            FactureFournisseur entity = new FactureFournisseur();
            modelAndView.addObject("ffournisseur",entity);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/findOneFClient/{id}"})
    @ResponseBody
    public FactureClient findOneFClient(@PathVariable("id") Optional<Integer> id)throws Exception{
        try {
            return services.getFClientById(id.get());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(path = {"/findOneFClientDTS/{id}"})
    @ResponseBody
    public FactureClientDetails findOneFClientD(@PathVariable("id") Optional<Integer> id)throws Exception{
        return services.getFClientDById(id.get());
    }

    @GetMapping(path = {"/findOneFFournisseur/{id}"})
    @ResponseBody
    public FactureFournisseur findOneFFournisseur(@PathVariable("id") Optional<Integer> id)throws Exception{
        return services.getFFournisseurById(id.get());

    }

    @GetMapping(path = "/delete/fclient/{id}")
    public String delete(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        services.deleteFClientById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/fclient";
    }

    @GetMapping(path = "/delete/ffournisseur/{id}")
    public String deleteF(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        services.deleteFFournisseurById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/ffournisseur";
    }

    @GetMapping(path = "/allModePaiement")
    @ResponseBody
    public List<ModeDePaiement> listAllModePaiement()throws Exception{
        return services.findAllModepaiement();
    }

    @GetMapping(path = "/allClient")
    @ResponseBody
    public List<Tiers> listAllClient()throws Exception{
        return tiersServices.findAllClient();
    }
}
