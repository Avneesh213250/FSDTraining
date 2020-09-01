package com.group2.FSD.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.FSD.domain.Sales;
import com.group2.FSD.domain.SalesType;
import com.group2.FSD.repository.CreditCardJPARepo;
import com.group2.FSD.repository.InsurenceJPARepo;
import com.group2.FSD.repository.SalesRepository;
import com.group2.FSD.repository.SalesTypeJPA;

@Transactional
@Service
public class SalseService {

	@Autowired
	SalesRepository salesRepository;
	
	@Autowired
	SalesTypeJPA salesTypeJPA;

	@Autowired
	CreditCardJPARepo creditCardJPARepo;
	
	@Autowired
	InsurenceJPARepo insurenceJPARepo;
	
	public Sales saveSalesEntry(Sales sales) {
		SalesType type= salesTypeJPA.findByType(sales.getsalestype());
		sales.setSalesId(type.getId());
		if(sales.getCreditCard()!=null) {
			creditCardJPARepo.save(sales.getCreditCard());
		}else if (sales.getInsurence()!=null) {
			insurenceJPARepo.save(sales.getInsurence());
		}
		Sales s = salesRepository.save(sales);
		return s;
	}

	public String deleteSalesEntry(Integer id) {
		salesRepository.deleteById(id);
		return "Done";
	}

	public Sales updateById(Integer id, Sales sales) {
       
		Optional<Sales> saOptional = salesRepository.findById(id);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&");
		Sales salesT = null;
		if (saOptional.isPresent()) {
			System.out.println(saOptional);
			sales.setId(id);
			System.out.println(sales);
			if(sales.getInsurence()!=null) {
				insurenceJPARepo.save(sales.getInsurence());
			}else {
				creditCardJPARepo.save(sales.getCreditCard());
			}
			
			salesT = salesRepository.save(sales);
			System.out.println(salesT);
		}
		return salesT;
	}

	public Sales findById(Integer id) {
		Optional<Sales> salOptional = salesRepository.findById(id);
		Sales sales=null;
		if(salOptional.isPresent()) {
			sales=salOptional.get();
		if((sales.getSalesId())==1) {
			sales.setsalestype("Insurence");
		}else if((sales.getSalesId())==2) {
			sales.setsalestype("CreditCard");
		}
		}
		return sales;
	}

	public List<Sales> findAll() {
		List<Sales> list = salesRepository.findAll();
		for (Sales sales : list) {
			if((sales.getSalesId())==1) {
				sales.setsalestype("Insurence");
			}else if((sales.getSalesId())==2) {
				sales.setsalestype("CreditCard");
			}
		}
		return list;
	}
	public List<Sales> findByOfficerid(Integer officerid){
		List<Sales> list = salesRepository.findByOfficerid(officerid);
		if(list.isEmpty()) {
			list=null;
		}else {
			for (Sales sales : list) {
				if((sales.getSalesId())==1) {
					sales.setsalestype("Insurence");
				}else if((sales.getSalesId())==2) {
					sales.setsalestype("CreditCard");
				}
			}
		}
		
		System.out.println(list);
		return list;
	}
}
