package com.joe.alain.myapp.controllers;


import com.joe.alain.myapp.modele.*;
import com.joe.alain.myapp.services.*;
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
public class ArticleController {

    @Autowired
    ArticleServices articleServices;

    @Autowired
    FactureServices factureServices;

    @Autowired
    UniteServices uniteServices;

    @Autowired
    DepotServices depotServices;

    @Autowired
    SousCategorieServices sCatServices;

    @Autowired
    CategorieServices categorieServices;

    @PostMapping("/add/unite")
    public String saveUnite(Model model,Unite entity){
        try {
            model.addAttribute("successFlash","Success");
            uniteServices.saveUnite(entity);
        }catch (Exception exc){
            exc.printStackTrace();
        }
        return "redirect:/unite";
    }
    @PostMapping("/add/depot")
    public String saveDepot(Depot entity){
        depotServices.save(entity);
        return "redirect:/depot";
    }

    @PostMapping("/add/article")
    public String saveArticle(Article entity){
        articleServices.save(entity);
        return "redirect:/article";
    }

    @PostMapping("/add/souscategorie")
    public String saveSousCategorie(SousCategorie entity){
        sCatServices.save(entity);
        return "redirect:/souscategorie";
    }

    @PostMapping("/add/categorie")
    public String saveCategorie(Categorie entity){
         categorieServices.save(entity);
         return "redirect:/categorie";
    }


    @GetMapping(path = {"/article","/article/{id}"})
    @ResponseBody
    public ModelAndView listArticle(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{
        ModelAndView modelAndView = new ModelAndView("article");

        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Article> unitePage = articleServices.findAll(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("articles",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Article unite = articleServices.getArticleById(id.get());
            modelAndView.addObject("article",unite);
        } else {
            Article unite = new Article();
            modelAndView.addObject("article",unite);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/unite", "/unite/{id}"})
    @ResponseBody
    public ModelAndView listUnite(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("unite");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Unite> unitePage = uniteServices.getPaginatedUnites(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("unites",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Unite unite = uniteServices.getUniteById(id.get());
            modelAndView.addObject("unite",unite);
        } else {
            Unite unite = new Unite();
            modelAndView.addObject("unite",unite);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/depot", "/depot/{id}"})
    @ResponseBody
    public ModelAndView listDepot(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("depot");
        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Depot> unitePage = depotServices.getDepot(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("depots",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Depot unite = depotServices.getById(id.get());
            modelAndView.addObject("depot",unite);
        } else {
            Depot unite = new Depot();
            modelAndView.addObject("depot",unite);
        }
        return modelAndView;
    }

    @GetMapping(path = "/allcategorie")
    @ResponseBody
    public List<Categorie>  listAllCategorie(){
        return categorieServices.findAll();
    }

    @GetMapping(path = "/allScategorie")
    @ResponseBody
    public List<SousCategorie>  listAllSCategorie(){
        return sCatServices.findAll();
    }

    @GetMapping(path = "/allUnite")
    @ResponseBody
    public List<Unite>  listAllUnite(){
        return uniteServices.findAll();
    }

    @GetMapping(path = "/allDepot")
    @ResponseBody
    public List<Depot>  listAllDepot(){
        return depotServices.findAll();
    }

    @GetMapping(path = {"/categorie", "/categorie/{id}"})
    @ResponseBody
    public ModelAndView listCategorie(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("categorie");

        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<Categorie> unitePage = categorieServices.getPaginatedCategories(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("categories",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            Categorie unite = categorieServices.getById(id.get());
            modelAndView.addObject("categorie",unite);
        } else {
            Categorie unite = new Categorie();
            modelAndView.addObject("categorie",unite);
        }
        return modelAndView;
    }

    @GetMapping(path = {"/souscategorie", "/souscategorie/{id}"})
    @ResponseBody
    public ModelAndView listSousCategorie(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{

        ModelAndView modelAndView = new ModelAndView("souscategorie");

        PageRequest pageable = PageRequest.of(page - 1, Constante.getPagination());
        Page<SousCategorie> unitePage = sCatServices.getPaginatedSousCategories(pageable);
        int totalPages = unitePage.getTotalPages();
        modelAndView.addObject("totalPages",totalPages);
        modelAndView.addObject("souscategories",unitePage.getContent());

        modelAndView.addObject("successFlash",null);
        if (id.isPresent()) {
            SousCategorie unite = sCatServices.getById(id.get());
            modelAndView.addObject("souscategorie",unite);
        } else {
            SousCategorie unite = new SousCategorie();
            modelAndView.addObject("souscategorie",unite);
        }
        return modelAndView;
    }



    @GetMapping(path = {"/findOneUnite/{id}"})
    @ResponseBody
    public Unite findOneUnite(@PathVariable("id") Optional<Integer> id)throws Exception{
        return uniteServices.getUniteById(id.get());

    }

    @GetMapping(path = {"/findOneDepot/{id}"})
    @ResponseBody
    public Depot findOneDepot(@PathVariable("id") Optional<Integer> id)throws Exception{
        return depotServices.getById(id.get());

    }

    @GetMapping(path = {"/findOneArticle/{id}"})
    @ResponseBody
    public Article findOneArticle(@PathVariable("id") Optional<Integer> id)throws Exception{
        return articleServices.getArticleById(id.get());

    }

    @GetMapping(path = {"/findOneCat/{id}"})
    @ResponseBody
    public Categorie findOneCat(@PathVariable("id") Optional<Integer> id)throws Exception{
        return categorieServices.getById(id.get());

    }

    @GetMapping(path = {"/findOneSCat/{id}"})
    @ResponseBody
    public SousCategorie findOneSCat(@PathVariable("id") Optional<Integer> id)throws Exception{
        return sCatServices.getById(id.get());

    }

    @GetMapping(path = "/delete/article/{id}")
    public String deleteArticle(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        articleServices.deleteArticleById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/article";
    }

    @GetMapping(path = "/delete/unite/{id}")
    public String deleteUnite(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        uniteServices.deleteUniteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/unite";
    }

    @GetMapping(path = "/delete/depot/{id}")
    public String deleteDepot(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        depotServices.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/depot";
    }

    @GetMapping(path = "/delete/categorie/{id}")
    public String deleteCat(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        categorieServices.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/categorie";
    }

    @GetMapping(path = "/delete/souscategorie/{id}")
    public String deleteSCat(Model model, @PathVariable("id") Optional<Integer> id) throws Exception {
        sCatServices.deleteById(id.get());
        model.addAttribute("successFlash","Success");
        return "redirect:/souscategorie";
    }


}
