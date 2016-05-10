package com.sample.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AlbumDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int albumId;

	private String title;

	
	

}