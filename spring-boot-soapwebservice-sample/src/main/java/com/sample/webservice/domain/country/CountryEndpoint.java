package com.sample.webservice.domain.country;

import com.sample.webservice.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.sample.webservice.domain.country.CountryRQ;
import com.sample.webservice.domain.country.CountryRS;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://country.domain.webservice.sample.com";

	private CountryRepository countryRepository;

	@Autowired
	public CountryEndpoint(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "CountryRQ")
	@ResponsePayload
	public CountryRS getCountry(@RequestPayload CountryRQ request) {
		CountryRS response = new CountryRS();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}
