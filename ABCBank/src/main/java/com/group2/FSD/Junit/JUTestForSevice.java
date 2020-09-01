package com.group2.FSD.Junit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.group2.FSD.FsdBankApplication;
import com.group2.FSD.Service.SalseService;
import com.group2.FSD.domain.Sales;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsdBankApplication.class)
@Transactional
@AutoConfigureMockMvc
public class JUTestForSevice {

	
    @MockBean
    SalseService customerservice;
    
    Sales sales=new Sales();
    @Test
    public void saveSalesEntry() {
    	Mockito.when(customerservice.saveSalesEntry(Mockito.any(Sales.class))).thenReturn(null);
    	
    	assertNull(customerservice.saveSalesEntry(sales));
	}

    @Test
	public void updateById() {

		Mockito.when(customerservice.updateById(Mockito.anyInt(), Mockito.any(Sales.class))).thenReturn(null);
		
		assertNull(customerservice.updateById(1212, sales));
	}
    @Test
	public void findById() {
		Mockito.when(customerservice.findById(Mockito.anyInt())).thenReturn(sales);
		
		assertNull(customerservice.findById(1212).getCustomername());
	}
	 List<Sales> list=null;
	 @Before
	public void set() {
		 list=new ArrayList<>();
		  list.add(sales);
	}
	 @Test
	public void findAll() {
		Mockito.when(customerservice.findAll()).thenReturn(null);
		
		assertNull(customerservice.findAll());
	}
	 @Test
	public void findByOfficerid(){
		Mockito.when(customerservice.findByOfficerid(Mockito.anyInt())).thenReturn(null);
		assertNull(customerservice.findByOfficerid(2323));
	}
}
