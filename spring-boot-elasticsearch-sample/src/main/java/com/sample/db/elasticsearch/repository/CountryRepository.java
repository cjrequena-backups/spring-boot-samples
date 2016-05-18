package com.sample.db.elasticsearch.repository;

import com.sample.db.mybatis.mapper.CountryMapper;
import com.sample.db.entity.Country;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.admin.indices.flush.FlushRequest;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by crequena on 10/05/2016.
 */
@Log4j2
@Component
public class CountryRepository implements ICountryRepository {

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
                bulkRequestBuilder.add(elasticSearchClient.prepareIndex("countries", "country", ""+country.getId()).setSource(xb));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        bulk(bulkRequestBuilder, "countries");
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
