package com.group2.FSD.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.FSD.Customexception.RecordNotFoundException;
import com.group2.FSD.domain.Officer;
import com.group2.FSD.repository.OfficerRepository;


@Transactional
@Service
public class OfficerService {
@Autowired
private OfficerRepository officerRepository;

public List<Officer> getAllOfficer(){
	List<Officer> officerList = officerRepository.findAll();
	if(officerList.isEmpty()) {
		return new ArrayList<Officer>();
	}
	return officerList;
}

public Officer getOfficerById(Integer id) throws RecordNotFoundException{
	Optional<Officer> officer = officerRepository.findById(id);
	if(officer.isPresent()) {
		return officer.get();
	}else {
		throw new RecordNotFoundException("No Officer Exist with this Id");
	}
}
public void updateStatusById(Integer id, String currentStatus) throws RecordNotFoundException {
	
	Optional<Officer> officer = officerRepository.findById(id);
	if(officer.isPresent()) {
		Officer updateStatus = officer.get();
		if("Active".equalsIgnoreCase(currentStatus)) {
			updateStatus.setStatus("InActive");
		}else {
			updateStatus.setStatus("Active");
		}
	}else {
		throw new RecordNotFoundException("No Officer Exist with this Id");
	}
	
}
 public Officer createOrUpdateOfficer(Officer entity) throws RecordNotFoundException 
    {
        Optional<Officer> officer = officerRepository.findById(entity.getOfficerId());
         
        if(officer.isPresent()) 
        {
        	Officer updateEntity = officer.get();
            updateEntity.setBranch_Id(entity.getBranch_Id());
            updateEntity.setOfficerName(entity.getOfficerName());
            updateEntity.setOfficerEmail(entity.getOfficerEmail());
            updateEntity.setOfficerAdress(entity.getOfficerAdress());
            updateEntity.setPhoneNum(entity.getPhoneNum());
            updateEntity.setStatus("Active");
 
            updateEntity = officerRepository.save(updateEntity);
             
            return updateEntity;
        } else {
        	
            entity = officerRepository.save(entity);
             
            return entity;
        }
    } 
 public Officer create(Officer entity) throws RecordNotFoundException 
 {
     Officer officer = officerRepository.save(entity);
      
          
         return officer;
     }
 public void deleteOfficerById(Integer id) throws RecordNotFoundException {
		
		Optional<Officer> employee = officerRepository.findById(id);
		if(employee.isPresent()) {
			officerRepository.deleteById(id);
		}else {
			throw new RecordNotFoundException("No Record to Delete");
		}
		
	}
}
