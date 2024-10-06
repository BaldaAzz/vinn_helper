package com.vinnhelper.VinNHelper.services;

import com.vinnhelper.VinNHelper.models.Article;
import com.vinnhelper.VinNHelper.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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

        isValidArticle(article);

        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {

        isValidArticle(updatedArticle);

        Article existingArticle = articleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Article not found"));

        existingArticle.setTitle(updatedArticle.getTitle());
        existingArticle.setDescription(updatedArticle.getDescription());

        return articleRepository.save(existingArticle);
    }

    public Article incrimentViewsInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Article not found"));

        Long currentViews = exisitngArticle.getViews();
        ++currentViews;
        exisitngArticle.setViews(currentViews);

        return articleRepository.save(exisitngArticle);
    }

    public Article incrimentLikesInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Article not found"));

        Long currentLikes = exisitngArticle.getLikes();
        ++currentLikes;
        exisitngArticle.setViews(currentLikes);

        return articleRepository.save(exisitngArticle);
    }

    public Article decrimentLikesInArticle(Long id) {
        Article exisitngArticle = articleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Article not found"));

        Long currentLikes = exisitngArticle.getLikes();
        --currentLikes;
        exisitngArticle.setViews(currentLikes);

        return articleRepository.save(exisitngArticle);
    }


    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    private void isValidArticle(Article article) {

        if (article.getCreator() == null) {
            throw new IllegalArgumentException("Article creator can not be empty");
        }

        if (article.getTitle() == null || article.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Article title can not be empty");
        }

        if (article.getDescription() == null || article.getDescription().isEmpty()) {
            throw new IllegalArgumentException("Article description can not be empty");
        }
    }
}
