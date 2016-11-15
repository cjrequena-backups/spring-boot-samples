package com.sample.db.integration;

import com.sample.MainApplication;
import com.sample.db.pojos.Album;
import com.sample.db.mapper.AlbumMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MainApplication.class})
@WebIntegrationTest
public class SampleMyBatisIT {

	@Autowired
	AlbumMapper albumMapper;

	@Test
	public void test() {
		final Album album = albumMapper.selectByPrimaryKey(1);
		log.debug(album.getTitle());

	}

}
