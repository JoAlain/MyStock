package com.joe.alain.myapp.controllers;

import com.joe.alain.myapp.modele.Tiers;
import com.joe.alain.myapp.modele.TypeTiers;
import com.joe.alain.myapp.services.TiersServices;
import com.joe.alain.myapp.util.Constante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class TiersController {

    @Autowired
    TiersServices services;


    @PostMapping("/add/tiers")
    public String saveEntree(Model model, Tiers entity){
        try {
            model.addAttribute("successFlash","Success");
            services.save(entity);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/tiers";
    }

    @GetMapping(path = {"/tiers", "/tiers/{id}"})
    @ResponseBody
    public ModelAndView listEntree(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("tiers");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Tiers> unitePage = services.findAll(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("tiers",unitePage.getContent());

        modelAndView.addObject("title","Tiers");
        if (id.isPresent()) {
            Tiers entity = services.getById(id.get());
            modelAndView.addObject("tier",entity);
        } else {
            Tiers entity = new Tiers();
            modelAndView.addObject("tier",entity);
        }
        return modelAndView;
    }


    @GetMapping(path = {"/findOneTiers/{id}"})
    @ResponseBody
    public Tiers findOne(@PathVariable("id") Optional<Integer> id)throws Exception{
        return services.getById(id.get());

    }

    @GetMapping(path = "/delete/tiers/{id}")
    public String delete(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        services.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/tiers";
    }

    @GetMapping(path = "/allFournisseur")
    @ResponseBody
    public List<Tiers> listAllArticle()throws Exception{
        return services.findAllFournisseur();
    }

    @GetMapping(path = "/allTypeTiers")
    @ResponseBody
    public List<TypeTiers> listAllTypeTiers()throws Exception{
        return services.findAllType();
    }
}
