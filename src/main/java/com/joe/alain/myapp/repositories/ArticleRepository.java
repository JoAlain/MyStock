package com.joe.alain.myapp.repositories;


import com.joe.alain.myapp.modele.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Page<Article> findAll(Pageable pageable);
}
