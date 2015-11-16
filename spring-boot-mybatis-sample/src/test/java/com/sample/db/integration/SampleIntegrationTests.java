package com.sample.db.integration;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.db.MainApplication;
import com.sample.db.configuration.Constants;
import com.sample.db.configuration.DatabaseConfigurationTest;
import com.sample.db.entity.SampleMyBatisEntity;
import com.sample.db.mapper.SampleMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MainApplication.class, DatabaseConfigurationTest.class})
@ActiveProfiles(Constants.SPRING_PROFILE_TESTING)
@WebIntegrationTest
public class SampleIntegrationTests {

	@Autowired
	SampleMapper sampleMapper;

	@Test
	public void test() {
		List<SampleMyBatisEntity> list = sampleMapper.getAll();
		for (Iterator<SampleMyBatisEntity> iterator = list.iterator(); iterator.hasNext();) {
			SampleMyBatisEntity entity = iterator.next();
			log.debug(entity.getEmail());
		}
	}

}
