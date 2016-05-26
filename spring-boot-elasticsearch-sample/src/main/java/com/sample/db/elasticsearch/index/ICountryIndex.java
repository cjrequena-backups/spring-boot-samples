package com.sample.db.elasticsearch.index;

/**
 * Created by crequena on 10/05/2016.
 */
public interface ICountryIndex {

    void createIndex() throws Exception;

    void deleteIndex() throws Exception;

    void mapIndex() throws Exception;


}
