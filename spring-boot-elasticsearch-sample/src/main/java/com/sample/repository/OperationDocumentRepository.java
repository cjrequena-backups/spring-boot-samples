package com.sample.repository;

import com.sample.entity.OperationDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by mohsinhusen on 10/04/15.
 */
public interface OperationDocumentRepository  extends ElasticsearchRepository<OperationDocument, Long> {

}
