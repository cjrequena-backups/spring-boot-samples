package com.sample.service;


import com.sample.db.pojos.AlbumEntity;

import java.util.List;

public interface IAlbumService {

    long countAll() throws Exception;

    void create(AlbumEntity entity) throws Exception;

    void update(AlbumEntity entity) throws Exception;

    void delete(AlbumEntity entity) throws Exception;

    void deleteByPk(Integer pk) throws Exception;

    AlbumEntity findByPk(Integer pk) throws Exception;

    List<AlbumEntity> findAll() throws Exception;


}
