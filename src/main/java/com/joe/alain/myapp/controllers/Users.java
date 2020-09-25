package com.joe.alain.myapp.controllers;

import com.joe.alain.myapp.modele.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class Users {
    @GetMapping(path = {"/users","/users/{id}"})
    @ResponseBody
    public ModelAndView listArticle(@PathVariable("id") Optional<Integer> id, @RequestParam(defaultValue = "1") int page)throws Exception{
        ModelAndView modelAndView = new ModelAndView("article");
/*
        PageRequest pageable = PageRequest.of(page - 1, 25);
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
        }*/
        return modelAndView;
    }
}
