package com.sample;

import com.sample.entity.Product;
import com.sample.repository.SampleProductRepository;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { ElasticsearchApplication.class })
@Log4j2
public class SampleProductRepositoryTest {

    @Resource
    private SampleProductRepository sampleProductRepository;

    @Before
    public void emptyData() {
        sampleProductRepository.deleteAll();
    }

    @Test
    public void shouldReturnListOfProductsByName() {
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
    }

    @Test
    public void shouldReturnListOfBookByNameWithPageable() {
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
                        "test product 2",
                        "How great would it be if we could search for this other product.",
                        true
                ));
        //when
        List<Product> products = sampleProductRepository.findByName("product", new PageRequest(0, 1));
        //then
        assertThat(products.size(), is(1));
    }

    @Test
    public void shouldReturnListOfProductsForGivenNameAndId() {
        //given
        sampleProductRepository.save(new Product(
                "1",
                "test product 1",
                "How great would it be if we could search for this product.",
                true
        ));
        sampleProductRepository
                .save(new Product(
                        "2",
                        "test product 2",
                        "How great would it be if we could search for this other product.",
                        true
                ));
        List<Product> products = sampleProductRepository.findByNameAndId("product", "1");

        //then
        assertThat(products.size(), is(1));
    }
}
