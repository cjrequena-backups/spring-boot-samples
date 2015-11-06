package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleRedisMainApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleRedisMainApp.class, args);
	}

	// public static void main(String[] args) throws InterruptedException {
	// ApplicationContext ctx = SpringApplication.run(SampleRedisMainApp.class,
	// args);
	// ICacheService<SampleDomain> cacheService = (ICacheService<SampleDomain>)
	// ctx.getBean(SampleCacheService.class);
	// SampleDomain domain = new SampleDomain();
	// domain.setId("KEY-1");
	// domain.setName("BOOK ONE");
	// cacheService.put(domain);
	// domain = cacheService.get(domain);
	// log.debug(domain.getId());
	// log.debug(domain.getName());
	// domain.setName("BOOK UPDATE");
	// cacheService.put(domain);
	// domain.setName("");
	// domain = cacheService.get(domain);
	// log.debug(domain.getId());
	// log.debug(domain.getName());
	// System.exit(0);
	// }

}
