package com.repository;

import com.entity.Article;
import com.entity.User;
import com.entity.UserArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by vicriss on 2015/09/22.
 */
public interface UserArticleRepository extends JpaRepository<UserArticle,Integer> {
    public UserArticle findByUserAndArticle(User user,Article article);
    public List<UserArticle> findByUserId(int userId);
    public UserArticle findByUserIdAndArticleId(int userId, int articleId);
}
