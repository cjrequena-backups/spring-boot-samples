package com.sample.db.elasticsearch.repository;

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
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by crequena on 10/05/2016.
 */
@Log4j2
@Component
@Data
public class CountryRepository implements ICountryRepository {

    private String indexName = "countries";
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
                bulkRequestBuilder.add(elasticSearchClient.prepareIndex(indexName, "country", ""+country.getId()).setSource(xb));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bulk(bulkRequestBuilder, indexName);
    }

    @Override
    public Country findCountry(String text, List<Filter> exclusiveFilters, List<Filter> inclusiveFilters, int size) throws Exception {
        SearchRequestBuilder srb = elasticSearchClient.prepareSearch(indexName);
        srb.setTypes("countries");

        srb.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        XContentBuilder xb = XContentFactory.jsonBuilder().startObject();
        xb.startObject("query");
        xb.startObject("filtered");
        if (fuzzyNumber == null) {
            if (text != null) {
                xb.startObject("query");
                xb.startObject("query_string");
                xb.startArray("fields");
                xb.value("name");
                xb.endArray();
                xb.field("query", text);
                //xb.field("fuzziness", "1");
                xb.endObject(); // query_string
                xb.endObject(); // query
            }
        } else {
            if (text != null) {
                xb.startObject("query");
                xb.startObject("multi_match");
                xb.startArray("fields");
                xb.value("name");
                xb.endArray();
                xb.field("query", text);
                if (fuzzyNumber != null) {
                    xb.field("fuzziness", fuzzyNumber.toString());
                }
                xb.endObject(); // query_string
                xb.endObject(); // query
            }
        }

        boolean exclusive = exclusiveFilters != null && !exclusiveFilters.isEmpty();
        boolean inclusive = inclusiveFilters != null && !inclusiveFilters.isEmpty();
        if (exclusive || inclusive) {
            xb.startObject("filter");
            xb.startObject("bool");
            xb.startArray("must");
            if (exclusive) {
                for (Filter filter : exclusiveFilters) {
                    xb.startObject();
                    xb.startObject("term");
                    xb.field(filter.getField(), filter.getValue());
                    xb.endObject();// term
                    xb.endObject();
                }
            }
            if (inclusive) {
                xb.startObject();
                xb.startArray("or");
                for (Filter filter : inclusiveFilters) {
                    xb.startObject();
                    xb.startObject("term");
                    xb.field(filter.getField(), filter.getValue());
                    xb.endObject();// term
                    xb.endObject();
                }
                xb.endArray();// or
                xb.endObject();
            }
            xb.endArray();// must
            xb.endObject(); // bool

            xb.endObject(); // filter
        }
        xb.endObject(); // filtered
        xb.endObject(); // query
        xb.close();
        //log.info(new String(xb.bytes().array()));
        srb.setQuery(xb);
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
        final SearchHits searchHits = response.getHits();



        Iterator<SearchHit> it = searchHits.iterator();
        while (it.hasNext()) {
            SearchHit hit = it.next();
            System.out.println(hit);
        }

        return null;

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
