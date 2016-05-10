package com.sample.integration;

import com.sample.ElasticsearchApplication;
import com.sample.entity.Article;
import com.sample.repository.SampleArticleRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ElasticsearchApplication.class })
@Log4j2
public class SampleArticleRepositoryIT {

    @Resource
    private SampleArticleRepository sampleArticleRepository;

    @Before
    public void emptyData(){
        sampleArticleRepository.deleteAll();
    }

    @Test
    public void shouldIndexSingleBookEntity(){

        Article article = new Article();
        article.setId("123455");
        article.setTitle("Spring Data Elasticsearch Test Article");
        List<String> authors = new ArrayList<String>();
        authors.add("Author1");
        authors.add("Author2");
        article.setAuthors(authors);
        List<String> tags = new ArrayList<String>();
        tags.add("tag1");
        tags.add("tag2");
        tags.add("tag3");
        article.setTags(tags);
        //Indexing using sampleArticleRepository
        sampleArticleRepository.save(article);
        //lets try to search same record in elasticsearch
        Article indexedArticle = sampleArticleRepository.findOne(article.getId());
        assertThat(indexedArticle,is(notNullValue()));
        assertThat(indexedArticle.getId(),is(article.getId()));
        assertThat(indexedArticle.getAuthors().size(),is(authors.size()));
        assertThat(indexedArticle.getTags().size(),is(tags.size()));
    }
}
