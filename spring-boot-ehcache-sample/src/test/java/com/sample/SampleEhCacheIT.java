package com.sample;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.EhCacheApplication;
import com.sample.entity.SampleEntity;
import com.sample.repository.CacheRepository;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = EhCacheApplication.class)
@WebIntegrationTest(randomPort = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SampleEhCacheIT {


	@Autowired
	@Qualifier("sampleEhCacheRepository")
	CacheRepository<SampleEntity> sampleEhCacheRepository;

	@Before
	public void setUp() throws Exception {
		SampleEntity entity1 = new SampleEntity();
		entity1.setObjectKey(1);
		entity1.setId(1);
		entity1.setEmail("email1");
		entity1.setFirstName("firstName1");
		entity1.setLastName("lastName1");

		SampleEntity entity2 = new SampleEntity();
		entity2.setObjectKey(2);
		entity2.setId(2);
		entity2.setEmail("email2");
		entity2.setFirstName("firstName2");
		entity2.setLastName("lastName2");

		SampleEntity entity3 = new SampleEntity();
		entity3.setObjectKey(3);
		entity3.setId(3);
		entity3.setEmail("email3");
		entity3.setFirstName("firstName3");
		entity3.setLastName("lastName3");

		SampleEntity entity4 = new SampleEntity();
		entity4.setObjectKey(4);
		entity4.setId(4);
		entity4.setEmail("email4");
		entity4.setFirstName("firstName4");
		entity4.setLastName("lastName4");

		sampleEhCacheRepository.put(entity1);
		sampleEhCacheRepository.put(entity2);
		sampleEhCacheRepository.put(entity3);
		sampleEhCacheRepository.put(entity4);
	}
	
	@Test
	public void testA() {
		SampleEntity entity1 = new SampleEntity();
		entity1.setObjectKey(1);
		entity1 = sampleEhCacheRepository.get(entity1);
		assertEquals("", entity1.getFirstName(), "firstName1");
		//log.debug(entity1.getFirstName());
	}
	
	@Test
	public void testB() {
		List<SampleEntity> list = sampleEhCacheRepository.getAll();
		for (Iterator<SampleEntity> iterator = list.iterator(); iterator.hasNext();) {
			SampleEntity SampleEntity = iterator.next();
			log.debug(SampleEntity.getFirstName());
		}
		assertEquals("", list.size(), 4);
	}

	@Test
	public void testC() {
		SampleEntity entity5 = new SampleEntity();
		entity5.setObjectKey(5);
		entity5.setId(5);
		entity5.setEmail("email5");
		entity5.setFirstName("firstName5");
		entity5.setLastName("lastName5");
		sampleEhCacheRepository.put(entity5);
	}

	@Test
	public void testD() {
		SampleEntity entity5 = new SampleEntity();
		entity5.setId(5);
		entity5.setId(1);
		entity5.setEmail("email1");
		entity5.setFirstName("firstName1");
		entity5.setLastName("lastName1");
		sampleEhCacheRepository.delete(entity5);
		assertEquals("",sampleEhCacheRepository.getAll(), 4);
	}

	@Test
	public void testE() {
		sampleEhCacheRepository.deleteAll();
		// assertThat(sampleRedisRepository.findAll()).hasSize(totalDomains - 1);
	}
}
