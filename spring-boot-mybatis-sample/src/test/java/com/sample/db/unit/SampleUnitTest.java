package com.sample.db.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sample.db.entity.SampleMyBatisEntity;
import com.sample.db.mapper.SampleMapper;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class SampleUnitTest {

	@Mocked
	@Injectable
	SampleMapper sampleMapper;

	@Test
	public void test() {
		try {
			// Define the Expectations block here
			new Expectations() {
				// variables declared here are mocked by default
				{
					SampleMyBatisEntity sampleMyBatisEntity = new SampleMyBatisEntity();
					sampleMyBatisEntity.setEmail("crequena@hotelbeds.com");
					sampleMyBatisEntity.setFirstName("Carlos");
					sampleMyBatisEntity.setLastName("Requena");
					sampleMyBatisEntity.setId(1);
					List<SampleMyBatisEntity> list = new ArrayList<>();
					list.add(sampleMyBatisEntity);
					sampleMapper.getAll();
					returns(list);
				}
			};

			List<SampleMyBatisEntity> listResult = sampleMapper.getAll();
			// Check that an object isn't null
			assertNotNull(listResult);
			// Check the size
			assertEquals("", listResult.size(), 1);
			// Check some content
			assertEquals("", listResult.get(0).getEmail(), "crequena@hotelbeds.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
