package com.sample.db.elasticsearch.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.db.entity.Country;
import com.sample.db.mybatis.mapper.CountryMapper;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.QueryBuilders.nestedQuery;

/**
 * Created by crequena on 10/05/2016.
 */
@Log4j2
@Component
@Data
public class CountryRepository implements ICountryRepository {

    private String INDEX_NAME = "countries";
    private Integer fuzzyNumber = 1;

    @Autowired
    public CountryMapper countryMapper;
    @Autowired
    Client elasticSearchClient;

    @Override
    public void loadDataToElasticSearch() throws Exception {
        BulkRequestBuilder bulkRequestBuilder = elasticSearchClient.prepareBulk();
        List<Country> countries = countryMapper.getAll();
        countries.forEach(country -> {
            try {
                XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
                xb.field("id",country.getId());
                xb.field("iso",country.getIso());
                xb.field("name",country.getName());
                xb.field("meta_data_1",country.getMetaData1());
                xb.field("meta_data_2",country.getMetaData2());
                xb.field("meta_data_3",country.getMetaData3());
                xb.field("meta_data_4",country.getMetaData4());
                bulkRequestBuilder.add(elasticSearchClient.prepareIndex(INDEX_NAME, "COUNTRY", ""+country.getId()).setSource(xb));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bulk(bulkRequestBuilder, INDEX_NAME);
    }

    @Override
    public List<Country> findCountry(String text, List<Filter> exclusiveFilters, List<Filter> inclusiveFilters, int size) throws Exception {
        SearchRequestBuilder srb = elasticSearchClient.prepareSearch(INDEX_NAME);
        srb.setTypes("COUNTRY");

        srb.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);

        //XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
//        xb.startObject("query")
//            .startObject("bool")
//                .startArray("must")
//                    .startObject()
//                        .startObject("term")
//                            .field("name",text)
//                        .endObject()
//                    .endObject()
//                .endArray()
//            .endObject()
//        .endObject();
//        xb.close();



        Set<String> mustNot = new HashSet<String>();
        mustNot.add("Islas Georgias");

        BoolQueryBuilder qb = boolQuery()
            .must(matchPhraseQuery("name", text))
            .mustNot(matchPhraseQuery("name", mustNot));

        srb.setQuery(qb);
        srb.setFrom(0);
        srb.setSize(size);
        srb.addSort("name", SortOrder.DESC);
        srb.setExplain(true);
        srb.setHighlighterPreTags("<strong>");
        srb.addHighlightedField("name");
        srb.setHighlighterFragmentSize(3);
        srb.setHighlighterPostTags("</strong>");
        log.info(srb.toString());

        SearchResponse response = srb.execute().actionGet();
        SearchHits searchHits = response.getHits();


        ObjectMapper mapper = new ObjectMapper();

        List<Country> countries = new ArrayList<>();
        Iterator<SearchHit> it = searchHits.iterator();
        while (it.hasNext()) {
            SearchHit hit = it.next();
            Country country = mapper.readValue(hit.getSourceAsString(), Country.class);
            countries.add(country);
        }

        return countries;

    }

    protected void bulk(BulkRequestBuilder bulkRequestBuilder, String indexName) {
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();
        if (!bulkResponse.hasFailures()) {
            elasticSearchClient.admin().indices().flush(new FlushRequest(indexName).force(true)).actionGet();
        } else {
            log.info("bulk failure!!!" + " bulk failure message: " + bulkResponse.buildFailureMessage());
        }
        bulkRequestBuilder = elasticSearchClient.prepareBulk();
    }
}
