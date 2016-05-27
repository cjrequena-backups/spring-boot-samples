package com.sample.db.elasticsearch.index;

import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by crequena on 27/05/2016.
 */
@Log4j2
public abstract class AbstractIndex {

    @Autowired
    Client elasticSearchClient;

    public void deleteIndex(String indexName) throws Exception {
        boolean exists = elasticSearchClient.admin().indices().prepareExists(indexName).execute().actionGet().isExists();
        if (exists) {
            DeleteIndexResponse delete = elasticSearchClient.admin().indices().delete(new DeleteIndexRequest(indexName)).actionGet();
            if (!delete.isAcknowledged()) {
                throw new RuntimeException("Could not delete index!");
            } else {
                log.info("Index " + indexName + " deleted!");
            }
        }
    }
}
