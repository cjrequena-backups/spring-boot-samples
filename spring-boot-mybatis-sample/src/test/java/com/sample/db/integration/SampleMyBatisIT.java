package com.sample.db.integration;

import com.sample.MainApplication;
import com.sample.db.pojos.AlbumEntity;
import com.sample.db.mapper.AlbumMapper;
import com.sample.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MainApplication.class})
@WebIntegrationTest
public class SampleMyBatisIT {

	@Autowired
	IAlbumService albumService;

	@Test
	public void test() throws Exception {
		List<AlbumEntity> albumEntities = albumService.findAll();

		for (AlbumEntity albumEntity : albumEntities) {
			log.debug(albumEntity.getTitle());
		}


	}

}
