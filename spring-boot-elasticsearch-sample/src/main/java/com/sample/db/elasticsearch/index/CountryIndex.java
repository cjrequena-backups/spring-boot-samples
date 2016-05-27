package com.sample.db.elasticsearch.index;

import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by crequena on 10/05/2016.
 */
@Log4j2
@Component
public class CountryIndex extends AbstractIndex implements ICountryIndex {

    public static final String INDEX_NAME = "countries";



    @Autowired
    Client elasticSearchClient;


    @Override
    public void createIndex() throws Exception {
        Settings.Builder builder = Settings.builder();
        //


        builder.put("number_of_shards", "1");
        builder.put("index.analysis.filter.autocomplete_filter.type", "edge_ngram");
        builder.put("index.analysis.filter.autocomplete_filter.min_gram", "1");
        builder.put("index.analysis.filter.autocomplete_filter.max_gram", "20");

        builder.put("index.analysis.analyzer.autocomplete.type", "custom");
        builder.put("index.analysis.analyzer.autocomplete.tokenizer", "standard");
        builder.putArray("index.analysis.analyzer.autocomplete.filter", "lowercase", "autocomplete_filter");





//        builder.put("index.analysis.analyzer.synonym.tokenizer", "whitespace");
//        builder.putArray("index.analysis.analyzer.synonym.filter", "synonym", "lowercase");
//        builder.put("index.analysis.filter.synonym.type", "synonym");
//        builder.put("index.analysis.filter.synonym.synonyms_path", "synonym.txt");
//
//        builder.put("index.analysis.tokenizer.ngram_tokenizer.type", "nGram");
//        builder.put("index.analysis.tokenizer.ngram_tokenizer.min_gram", "2");
//        builder.put("index.analysis.tokenizer.ngram_tokenizer.max_gram", "10");
//        builder.putArray("index.analysis.tokenizer.ngram_tokenizer.token_chars", "letter", "digit");
//        builder.putArray("index.analysis.tokenizer.ngram_tokenizer.filter", "lowercase", "digit");
//
//        builder.put("index.analysis.analyzer.ngram_generic_analyzer.tokenizer", "ngram_tokenizer");
//        builder.put("index.analysis.analyzer.ngram_spanish_analyzer.tokenizer", "ngram_tokenizer");
//        builder.put("index.analysis.analyzer.ngram_spanish_analyzer.language", "spanish");
//        builder.putArray("index.analysis.analyzer.ngram_spanish_analyzer.filter", "synonym", "lowercase");

        elasticSearchClient.
                admin().
                indices().
                create(new CreateIndexRequest(INDEX_NAME).settings(builder.build())).
                actionGet();
    }

    @Override
    public void deleteIndex(String indexName) throws Exception {
        super.deleteIndex(indexName);
    }


    @Override
    public void mapIndex() throws Exception {

        XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
        xb.startObject("properties");

        xb.startObject("id");
        xb.field("type", "integer");
        xb.field("index", "not_analyzed");
        xb.endObject();

        xb.startObject("iso");
        xb.field("type", "string");
        xb.field("index", "not_analyzed");
        xb.endObject();

        xb.startObject("name");
        xb.field("type", "string");
        xb.field("analyzer", "autocomplete");
        xb.endObject();

        xb.startObject("meta_data_1");
        xb.field("type", "string");
        xb.field("index", "not_analyzed");
        xb.endObject();

        xb.startObject("meta_data_2");
        xb.field("type", "string");
        xb.field("index", "not_analyzed");
        xb.endObject();

        xb.startObject("meta_data_3");
        xb.field("type", "string");
        xb.field("index", "not_analyzed");
        xb.endObject();

        xb.startObject("meta_data_4");
        xb.field("type", "string");
        xb.field("index", "not_analyzed");
        xb.endObject();


        xb.endObject();
        xb.close();

        PutMappingResponse putMappingResponse =
                elasticSearchClient.admin().indices().preparePutMapping(INDEX_NAME).setType("COUNTRY").setSource(xb).execute().actionGet();
        if (!putMappingResponse.isAcknowledged()) {
            throw new RuntimeException("Could not create mapping!");
        } else {
            log.info("Index created!");
        }

    }
}
