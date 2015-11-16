package com.sample.db.entity;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * @author crequena
 *
 */
@Data
public class SampleMyBatisEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;

}
