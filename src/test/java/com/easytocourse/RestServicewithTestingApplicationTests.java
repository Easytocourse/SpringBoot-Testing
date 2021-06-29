package com.easytocourse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.easytocourse.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RestServicewithTestingApplicationTests {

	@Autowired
	MockMvc mvc;
	
	@Autowired
	ObjectMapper mapper;
	
	@Test
	@Disabled
	public void testsaveemp() throws Exception
	{
		Employee expected=new Employee(10,"bharath","java");
		RequestBuilder request=MockMvcRequestBuilders.post("/Employee/addEmployee").contentType(MediaType.APPLICATION_JSON).content("{\n  \"name\":\"bharath\",\n  \"tech\":\"java\"\n}");
		MvcResult mvcresult=mvc.perform(request).andExpect(status().isOk()).andReturn();
		assertEquals(mapper.writeValueAsString(expected), mvcresult.getResponse().getContentAsString());
	}
	
	@Test
	public void testgetempbyid() throws Exception
	{
		
		RequestBuilder request=MockMvcRequestBuilders.get("/Employee/getEmployee/32432").contentType(MediaType.APPLICATION_JSON).content("{\n  \"name\":\"bharath\",\n  \"tech\":\"java\"\n}");
		MvcResult mvcresult=mvc.perform(request).andExpect(status().isBadRequest()).andReturn();
		
	}
	
}
