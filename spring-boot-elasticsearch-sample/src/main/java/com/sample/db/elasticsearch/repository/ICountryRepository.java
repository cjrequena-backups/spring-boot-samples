package com.sample.db.elasticsearch.repository;

import com.sample.db.entity.Country;

import java.util.List;

/**
 * Created by crequena on 10/05/2016.
 */
public interface ICountryRepository {

    void loadDataToElasticSearch() throws Exception;

    List<Country> findCountry(String country, List<Filter> exclusiveFilters, List<Filter> inclusiveFilters, int size) throws Exception;

}
