package com.sample.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.business.service.IAlbumService;
import com.sample.db.entity.AlbumEntity;
import com.sample.dto.AlbumDTO;
import com.sample.mapper.AlbumMapper;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class AlbumController {

	Logger log = LoggerFactory.getLogger(AlbumController.class);

	@Autowired
	IAlbumService albumService;
	
	
	
	@RequestMapping(value = "/albums", method = RequestMethod.GET)
	@ResponseBody
	public List<AlbumDTO> getListAllAlbums() throws Exception {
		List<AlbumEntity> albums = albumService.findAll();
		log.debug(albums.size()+"");
		List<AlbumDTO> albumDTOs = new ArrayList<>();
		AlbumMapper mapper = new AlbumMapper();
		for (Iterator<AlbumEntity> iterator = albums.iterator(); iterator.hasNext();) {
			AlbumEntity albumEntity = (AlbumEntity) iterator.next();
			albumDTOs.add(mapper.mapEntityToDTO(albumEntity));
		}
		return albumDTOs;
	}
	
}
