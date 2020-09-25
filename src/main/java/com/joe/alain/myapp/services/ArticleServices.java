package com.joe.alain.myapp.services;


import com.joe.alain.myapp.config.Constant;
import com.joe.alain.myapp.modele.Article;
import com.joe.alain.myapp.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServices {

    @Autowired
    ArticleRepository repository;

    public Page<Article> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public List<Article> findAll()
    {
        List<Article> result = (List<Article>) repository.findAll();

        if(result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Article>();
        }
    }

    public Article getArticleById(Integer id) throws Exception
    {
        Optional<Article> entity = repository.findById(id);

        if(entity.isPresent()) {
            return entity.get();
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }

    public String save(Article entity){
        repository.save(entity);
        return "";
    }

    public void deleteArticleById(Integer id) throws Exception
    {
        Optional<Article> employee = repository.findById(id);

        if(employee.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new Exception(Constant.noRecordFound);
        }
    }
}
