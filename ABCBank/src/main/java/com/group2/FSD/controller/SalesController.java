package com.group2.FSD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.group2.FSD.Service.SalseService;
import com.group2.FSD.domain.Sales;
import com.group2.FSD.domain.StudentDetails;
import com.group2.FSD.microservice.FeignClientCOVID;
import com.group2.FSD.microservice.FeignClientMicro;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class SalesController {
    
	@Autowired
	SalseService salseService;
	
	@Autowired
	FeignClientMicro feignClient;
	
	@Autowired
	FeignClientCOVID feignClientCovid;
	
	@GetMapping("getSalesEntryById/{id}")
	public ResponseEntity<Sales> getSalesEntryById(@PathVariable Integer id) {
		return ResponseEntity.ok(salseService.findById(id));
	}
	
	@GetMapping("microserviceTest/{id}")
	@HystrixCommand(fallbackMethod = "getFallBack",
	threadPoolKey = "studentpool",
	threadPoolProperties = {
			@HystrixProperty(name="coreSize", value="20"),
			@HystrixProperty(name="maxQueueSize", value="10")
	})
	public ResponseEntity<StudentDetails> getStudentDetailsById(@PathVariable Integer id) {
		return feignClient.getStudentDetailsById(id);
	}
	
	@PostMapping("/saveSalesEntry")
	public ResponseEntity<Sales> saveSalesEntry(@RequestBody Sales sales){
		System.out.println(sales);
		return ResponseEntity.ok(salseService.saveSalesEntry(sales));
	}
	
	@SuppressWarnings("rawtypes")
	@DeleteMapping("/deleteSalesEntry/{id}")
	public ResponseEntity deleteById(@PathVariable Integer id){
		  salseService.deleteSalesEntry(id);
		return  ResponseEntity.ok().build();
	}
	
	@PutMapping("/updateSalesEntry/{id}")
	public ResponseEntity<Sales> updateById(@RequestBody Sales sales ,@PathVariable Integer id){
		return ResponseEntity.ok(salseService.updateById(id, sales));
	}
	
	@GetMapping("/getAllSalesEntry")
	public List<Sales> getAll(){
		return salseService.findAll();
	}
	
	@GetMapping("/getCovid")
	public ResponseEntity<Optional> getAllCovid(){
		return feignClientCovid.getCOVIDData();
	}
	
	@GetMapping("getByOfficerId/{officerid}")
	public List<Sales> getByOfficerId(@PathVariable Integer officerid){
		return salseService.findByOfficerid(officerid);
	}
	
	@PostMapping("/testPostArray")
	public String test1(@RequestParam("test") List<Integer> test) {
		System.out.println(test);
		return "good";
	}
	public ResponseEntity<StudentDetails> getFallBack(@PathVariable Integer id){
		StudentDetails student= new StudentDetails(221, "Avneesh", "Shrivsatav", "Test", "Test2", "Jaunpur", "988933145", "af@hgd.ion");
		ResponseEntity<StudentDetails> responseEntity= ResponseEntity.ok(student);
		return responseEntity;
	}
}
