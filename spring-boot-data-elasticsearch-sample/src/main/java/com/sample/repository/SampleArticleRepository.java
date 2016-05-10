package com.sample.repository;

import com.sample.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SampleArticleRepository extends ElasticsearchRepository<Article,String> {
}
