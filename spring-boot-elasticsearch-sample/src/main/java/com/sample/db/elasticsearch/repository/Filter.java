package com.sample.db.elasticsearch.repository;

import lombok.Data;
import lombok.NonNull;

@Data
public class Filter {
	@NonNull
	private String field;
	@NonNull
	private String value;
}
