package com.repository;

import com.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by vicriss on 2015/09/21.
 */
public interface ArticleRepository extends JpaRepository<Article,Integer>{
    public Article findByTitle(String name);
}
