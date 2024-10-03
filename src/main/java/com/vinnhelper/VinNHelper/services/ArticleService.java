package com.vinnhelper.VinNHelper.services;

import com.vinnhelper.VinNHelper.models.Article;
import com.vinnhelper.VinNHelper.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article findById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Article exisingArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        exisingArticle.setTitle(updatedArticle.getTitle());
        exisingArticle.setDescription(updatedArticle.getDescription());

        return articleRepository.save(exisingArticle);
    }

    public Article incrimentViewsInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        Long currentViews = exisitngArticle.getViews();
        ++currentViews;
        exisitngArticle.setViews(currentViews);

        return articleRepository.save(exisitngArticle);
    }

    public Article incrimentLikesInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        Long currentLikes = exisitngArticle.getLikes();
        ++currentLikes;
        exisitngArticle.setViews(currentLikes);

        return articleRepository.save(exisitngArticle);
    }

    public Article decrimentLikesInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));

        Long currentLikes = exisitngArticle.getLikes();
        --currentLikes;
        exisitngArticle.setViews(currentLikes);

        return articleRepository.save(exisitngArticle);
    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
}
