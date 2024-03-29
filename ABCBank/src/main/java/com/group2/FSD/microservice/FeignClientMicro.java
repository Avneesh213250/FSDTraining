package com.group2.FSD.microservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.group2.FSD.domain.StudentDetails;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@FeignClient("studentdata")
public interface FeignClientMicro {

	@GetMapping("getStudentDetailsById/{id}")
	public ResponseEntity<StudentDetails> getStudentDetailsById(@PathVariable Integer id);
	
	
}
