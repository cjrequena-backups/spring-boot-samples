package com.sample.repository;

import com.sample.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface SampleProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findByName(String name, Pageable pageable);

    List<Product> findByNameAndId(String name, String id);
}
