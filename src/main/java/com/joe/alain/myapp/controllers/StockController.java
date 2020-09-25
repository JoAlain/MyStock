package com.joe.alain.myapp.controllers;

import com.joe.alain.myapp.modele.Article;
import com.joe.alain.myapp.modele.EtatStock;
import com.joe.alain.myapp.modele.Mouvement;
import com.joe.alain.myapp.services.ArticleServices;
import com.joe.alain.myapp.services.DepotServices;
import com.joe.alain.myapp.services.StockServices;
import com.joe.alain.myapp.util.Constante;
import com.joe.alain.myapp.util.Utilitaire;
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
public class StockController {

    @Autowired
    StockServices services;

    @Autowired
    ArticleServices articleServices;

    @Autowired
    DepotServices depotServices;

    @Autowired
    StockServices stockServices;

    @PostMapping("/add/entree")
    public String saveEntree(Model model, Mouvement entity){
        try {
            model.addAttribute("successFlash","Success");
            entity.setType("entree");
            entity.setMontant(entity.getPu()*entity.getEntree());
            services.save(entity);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/entree";
    }

    @PostMapping("/add/stock")
    public String saveStock(Model model, EtatStock entity){
        try {
            model.addAttribute("successFlash","Success");
            Mouvement en = new Mouvement(Utilitaire.dateDuJourSql() , "E", entity.getDepot(), "", "entree", entity.getArticle(), entity.getReste(), entity.getPu(), entity.getReste() * entity.getPu(), 1);
            en.setType("entree");
            services.save(en);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/etat";
    }

    @PostMapping("/add/sortie")
    public String saveSortie(Model model, Mouvement entity) throws Exception{
        try {
            model.addAttribute("successFlash","Success");
            entity.setType("sortie");
            entity.setMontant(entity.getPu()*entity.getSortie());
            double reste = services.getResteStock(entity.getArticle(), entity.getDepot());
            if(entity.getSortie() <= reste) {
                services.save(entity);
            } else {
                throw new Exception("Etat de stock insuffisant");
            }
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/sortie";
    }

    @GetMapping(path = {"/entree", "/entree/{id}"})
    @ResponseBody
    public ModelAndView listEntree(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("entree");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Mouvement> unitePage = services.getEntree(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("mouvements",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Mouvement entity = services.getById(id.get());
            modelAndView.addObject("mouvement",entity);
        } else {
            Mouvement entity = new Mouvement();
            modelAndView.addObject("mouvement",entity);
        }
        return modelAndView;
    }

    @GetMapping(path = "/etat")
    @ResponseBody
    public ModelAndView listEtat(@RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("etat-stock");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<EtatStock> unitePage = services.getEtatStock(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("etats",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        return modelAndView;
    }

    @GetMapping(path = {"/sortie", "/sortie/{id}"})
    @ResponseBody
    public ModelAndView listSortie(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("sortie");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Mouvement> unitePage = services.getSortie(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("mouvements",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Mouvement unite = services.getById(id.get());
            modelAndView.addObject("mouvement",unite);
        } else {
            Mouvement unite = new Mouvement();
            modelAndView.addObject("mouvement",unite);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/findOneMouvement/{id}"})
    @ResponseBody
    public Mouvement findOneUnite(@PathVariable("id") Optional<Integer> id)throws Exception{
        return services.getById(id.get());
    }

    @GetMapping(path = "/delete/entree/{id}")
    public String deleteEntree(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        services.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/entree";
    }

    @GetMapping(path = "/delete/sortie/{id}")
    public String deleteSortie(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        services.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/sortie";
    }

    @GetMapping(path = "/allArticle")
    @ResponseBody
    public List<Article> listAllArticle(){
        return articleServices.findAll();
    }

    @GetMapping(path = {"/findStock/{id}"})
    @ResponseBody
    public EtatStock findStock(@PathVariable("id") Optional<String> id)throws Exception{
        return stockServices.getStockById(id.get());
    }
}
