package com.vinnhelper.VinNHelper.servicesTests;

import com.vinnhelper.VinNHelper.models.Article;
import com.vinnhelper.VinNHelper.models.User;
import com.vinnhelper.VinNHelper.repositories.ArticleRepository;
import com.vinnhelper.VinNHelper.services.ArticleService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleServiceTest {

    @InjectMocks
    private ArticleService articleService;

    @Mock
    private ArticleRepository articleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createArticleTest() {
        Article article = new Article();

        article.setTitle("title");
        article.setDescription("description");
        article.setViews(0L);
        article.setCreator(new User());
        article.setLikes(0L);
        article.setPublicationDate(ZonedDateTime.now());

        when(articleRepository.save(article)).thenReturn(article);

        Article createdArticle = articleService.createArticle(article);
        assertNotNull(createdArticle);
        assertEquals("title", createdArticle.getTitle());
    }
}
