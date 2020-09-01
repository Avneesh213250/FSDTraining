package com.group2.FSD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group2.FSD.Customexception.RecordNotFoundException;
import com.group2.FSD.Service.OfficerService;
import com.group2.FSD.domain.Officer;

@RestController
public class OfficerController {
	
		@Autowired
		private OfficerService service;
		
		 @GetMapping("/officer/getAllOfficers")
		    public ResponseEntity<List<Officer>> getAllOfficer() {
		        List<Officer> list = service.getAllOfficer();
		 
		        return new ResponseEntity<List<Officer>>(list, new HttpHeaders(), HttpStatus.OK);
		    }
		 
		    @GetMapping("/officer/{id}")
		    public ResponseEntity<Officer> getOfficerById(@PathVariable("id") Integer id) 
		                                                    throws RecordNotFoundException {
		        Officer entity = service.getOfficerById(id);
		 
		        return new ResponseEntity<Officer>(entity, new HttpHeaders(), HttpStatus.OK);
		    }
		
		    @PostMapping("/officer/addOfficer")
		    public ResponseEntity<Officer> create(@RequestBody Officer officer)
		                                                    throws RecordNotFoundException {
		        Officer updated = service.create(officer);
		        return new ResponseEntity<Officer>(updated, new HttpHeaders(), HttpStatus.OK);
		    }
		    @PostMapping("/officer/UpdateOfficer")
		    public ResponseEntity<Officer> createOrUpdateOfficer(@RequestBody Officer officer)
		                                                    throws RecordNotFoundException {
		        Officer updated = service.createOrUpdateOfficer(officer);
		        return new ResponseEntity<Officer>(updated, new HttpHeaders(), HttpStatus.OK);
		    }
		    @DeleteMapping("/officer/{id}")
		    public HttpStatus deleteOfficerById(@PathVariable("id") Integer id) 
		                                                    throws RecordNotFoundException {
		        service.deleteOfficerById(id);
		        return HttpStatus.ACCEPTED;
		    }
		    
		    
		    @PutMapping("/officer/changeStatus/{id}")
		    public HttpStatus changeOfficerStatus(@PathVariable("id") Integer id)
                    throws RecordNotFoundException {
		    	  Officer entity = service.getOfficerById(id);
		    	  String currentStatus = entity.getStatus();
		    	  
				    service.updateStatusById(id, currentStatus);
					return HttpStatus.OK;
			}

	

}
