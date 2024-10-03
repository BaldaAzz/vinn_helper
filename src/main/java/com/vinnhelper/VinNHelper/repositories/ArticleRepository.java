package com.vinnhelper.VinNHelper.repositories;

import com.vinnhelper.VinNHelper.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
