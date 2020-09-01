package com.group2.FSD.Junit;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.group2.FSD.FsdBankApplication;
import com.group2.FSD.Service.SalseService;
import com.group2.FSD.controller.SalesController;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = FsdBankApplication.class)
@Transactional
@AutoConfigureMockMvc
public class JUTest {
	
	@InjectMocks
    SalesController controller;

	@Autowired
	private MockMvc mvc;
	
    @MockBean
    SalseService customerservice;
	
	@Test
	public void getAllSalesEntry() throws Exception {
		(mvc.perform(MockMvcRequestBuilders.get("/getAllSalesEntry")
				.contentType("application/json")))
		.andDo(print()).
		andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	@Test
	public void getSalesEntryById() throws Exception {
	
		mvc.perform(MockMvcRequestBuilders.get("/getSalesEntryById/145/").contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
	     }
	@Test
	public void getSalesEntryById1() throws Exception {
	
		mvc.perform(MockMvcRequestBuilders.get("/getSalesEntryById/{id}/", 145).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
	     }
	@Test
	public void getAllSalesEntry1() throws Exception {
		MvcResult result =(mvc.perform(MockMvcRequestBuilders.get("/getAllSalesEntry")
				.contentType("application/json"))).
		andExpect(MockMvcResultMatchers.status().isOk())
		.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("==========>"+content);
	}
	String test1="{\r\n" + 
			"\"customername\":\"Avneesh\",\r\n" + 
			"\"salestype\":\"Insurence\",\r\n" + 
			"\"creditCard\":{\r\n" + 
			"	\"creditCardNum\":51257723576,\r\n" + 
			"     \"validity\":\"2020-07-08\"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"\"createdDate\":\"2020-07-08\",\r\n" + 
			"\"createdBy\":\"Admin\"\r\n" + 
			"}";
	@Test
	public void saveSalesEntryForCredit() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/saveSalesEntry/").content(test1).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	String test2="{\r\n" + 
			"\"customername\":\"Avneesh\",\r\n" + 
			"\"salestype\":\"Insurence\",\r\n" + 
			"\"creditCard\":{\r\n" + 
			"	\"creditCardNum\":51257723576,\r\n" + 
			"     \"validity\":\"2020-07-08\"\r\n" + 
			"},\r\n" + 
			"\r\n" + 
			"\"createdDate\":\"2020-07-08\",\r\n" + 
			"\"createdBy\":\"Admin\"\r\n" + 
			"}";
	
	@Test
	public void saveSalesEntryForInsurence() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/saveSalesEntry/").content(test2).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void deleteById() throws Exception{
		mvc.perform(MockMvcRequestBuilders.delete("/deleteSalesEntry/{id}/", 145).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void updateByIdCreditCared() throws Exception{
		mvc.perform(MockMvcRequestBuilders.put("/updateSalesEntry/{id}/", 145).content(test1).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	public void updateByIdCreditCared1() throws Exception{
		mvc.perform(MockMvcRequestBuilders.put("/updateSalesEntry/{id}/", 145).content(test2).contentType("application/json"))
		.andDo(print())
	    .andExpect(MockMvcResultMatchers.status().isOk());
	}
}
