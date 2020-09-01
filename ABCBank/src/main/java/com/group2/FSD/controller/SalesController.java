package com.group2.FSD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group2.FSD.Service.SalseService;
import com.group2.FSD.domain.Sales;

@RestController
@CrossOrigin
public class SalesController {
    
	@Autowired
	SalseService salseService;
	
	@GetMapping("getSalesEntryById/{id}")
	public ResponseEntity<Sales> getSalesEntryById(@PathVariable Integer id) {
		return ResponseEntity.ok(salseService.findById(id));
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
	
	@GetMapping("getByOfficerId/{officerid}")
	public List<Sales> getByOfficerId(@PathVariable Integer officerid){
		return salseService.findByOfficerid(officerid);
	}
	
}
