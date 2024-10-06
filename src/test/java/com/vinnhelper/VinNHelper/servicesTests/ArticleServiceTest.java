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
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.verify;
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

    private Article getValidTestArticle(Long id) {
        Article article = new Article();

        article.setId(id);
        article.setTitle("title");
        article.setDescription("description");
        article.setViews(0L);
        article.setCreator(new User());
        article.setLikes(0L);
        article.setPublicationDate(ZonedDateTime.now());

        return article;
    }

    private Article getNotValidTestArticle(Long id) {
        Article article = new Article();

        article.setId(id);
        article.setTitle("");
        article.setDescription(null);
        article.setViews(0L);
        article.setCreator(new User());
        article.setLikes(0L);
        article.setPublicationDate(ZonedDateTime.now());

        return article;
    }

    @Test
    public void testCreateArticleWhenAllValuesAreValid() {
        Long id = 1L;
        Article article = getValidTestArticle(id);

        when(articleRepository.save(article)).thenReturn(article);

        Article createdArticle = articleService.createArticle(article);

        assertNotNull(createdArticle);
        assertEquals("title", createdArticle.getTitle());
    }

    @Test
    public void testCreateArticleWhenValuesAreNotValid() {
        Long id = 1L;
        Article article = getNotValidTestArticle(id);

        when(articleRepository.save(article)).thenReturn(article);

        assertThrows(IllegalArgumentException.class, () -> {
            articleService.createArticle(article);
        });
    }

    @Test
    public void testGetAllArticlesWhenObjectsExist() {
        Long id = 1L;
        Article article = getValidTestArticle(id);

        when(articleRepository.findAll()).thenReturn(Arrays.asList(article));

        List<Article> articlesList = articleService.findAll();

        assertEquals(1, articlesList.size());
        assertEquals("title", articlesList.get(0).getTitle());
    }

    @Test
    public void testGetByIdArticleWhenObjectExists() {
        Long id = 1L;
        Article article = getValidTestArticle(id);

        Long articleId = 1L;

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(article));

        Article foundArticle = articleService.findById(articleId);

        assertNotNull(foundArticle);
        assertEquals("title", foundArticle.getTitle());
    }

    @Test
    public void testGetByIdArticleWhenResultIsNull() {

        Article foundArticle = articleService.findById(1L);

        assertNull(foundArticle);
    }

    @Test
    public void testUpdateArticleWhenAllValuesAreValid() {

        Long articleId = 1L;
        Article existingArticle = getValidTestArticle(articleId);

        Article updatedArticle = new Article();
        updatedArticle.setTitle("New Title");
        updatedArticle.setDescription("New Description");
        updatedArticle.setCreator(new User());

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        Article result = articleService.updateArticle(articleId, updatedArticle);

        assertNotNull(result);
        assertEquals("New Title", result.getTitle());
        assertEquals("New Description", result.getDescription());

//        Проверяет дествительно ли данный объект был сохранён
        verify(articleRepository).save(existingArticle);
    }

    @Test
    public void testUpdateArticleWhenValuesAreNotValid() {
        Long articleId = 1L;
        Article existingArticle = getValidTestArticle(articleId);

        Article updatedArticle = new Article();
        updatedArticle.setTitle("");
        updatedArticle.setDescription("");
        updatedArticle.setCreator(new User());

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        assertThrows(IllegalArgumentException.class, () -> {
            articleService.updateArticle(articleId, updatedArticle);
        });
    }

    @Test
    public void testIncrementViewsInArticle() {
        Long articleId = 1L;
        Article existingArticle = getValidTestArticle(articleId);

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        Article result = articleService.incrementViewsInArticle(articleId);

        assertNotNull(result);
        assertEquals(1L, result.getViews());
        verify(articleRepository).save(existingArticle);
    }

    @Test
    public void testIncrementLikesInArticle() {

        Long articleId = 1L;
        Article existingArticle = getValidTestArticle(articleId);

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        Article result = articleService.incrementLikesInArticle(articleId);

        assertNotNull(result);
        assertEquals(1L, result.getLikes());
        verify(articleRepository).save(existingArticle);
    }

    @Test
    public void testDecrementLikesInArticle() {
        Long articleId = 1L;
        Article existingArticle = getValidTestArticle(articleId);
        existingArticle.setLikes(2L);

        when(articleRepository.findById(articleId)).thenReturn(Optional.of(existingArticle));
        when(articleRepository.save(existingArticle)).thenReturn(existingArticle);

        Article result = articleService.decrementLikesInArticle(articleId);

        assertNotNull(result);
        assertEquals(1L, result.getLikes());
        verify(articleRepository).save(existingArticle);
    }

    @Test
    public void testDeleteArticle() {
        Long articleId = 1L;

        articleService.deleteArticle(articleId);
        verify(articleRepository).deleteById(articleId);
    }
}
