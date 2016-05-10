package com.sample.controller;

import com.sample.entity.Product;
import com.sample.repository.SampleProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
@Controller
public class SampleController {

	@Resource
	private SampleProductRepository sampleProductRepository;


	@RequestMapping("/")
	@ResponseBody
	List<Product> home() {
		//given
		sampleProductRepository.index(new Product(
				"1",
				"test product 1",
				"How great would it be if we could search for this product.",
				true
		));
		sampleProductRepository
				.index(new Product(
						"2",
						"test Product 2",
						"How great would it be if we could search for this other product.",
						true
				));
		//when
		List<Product> products = sampleProductRepository.findByName("product");
		//then
		assertThat(products.size(), is(2));
		log.debug("Hello World");
		return products;
	}
}
