package com.sample.integration;

import java.util.Map;

import com.sample.ElasticsearchApplication;
import com.sample.entity.OperationDocument;
import com.sample.repository.OperationDocumentRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ElasticsearchApplication.class })
@Log4j2
public class OperationDocumentRepositoryIT {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private OperationDocumentRepository repository;

	@Test
	public void test() {
		Map mapping = elasticsearchTemplate.getMapping(OperationDocument.class);
		log.debug(mapping.toString());
	}


}