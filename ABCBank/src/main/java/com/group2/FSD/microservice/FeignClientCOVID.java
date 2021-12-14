package com.group2.FSD.microservice;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.FSD.domain.StudentDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@FeignClient(name="covid19india", url = "https://data.covid19india.org/v4/min/data.min.json")
public interface FeignClientCOVID {

	@GetMapping("")
	public ResponseEntity<Optional> getCOVIDData();
	
}
