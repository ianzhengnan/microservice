package com.ian.springjpadatatransaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ian.springjpadatatransaction.dao.PersonRepository;
import com.ian.springjpadatatransaction.domain.Person;
import com.ian.springjpadatatransaction.service.PersonService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class SpringJpaDataTransactionApplicationTests {

	@Autowired
	PersonService personService;

	@Autowired
	PersonRepository pr;

	MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	String expectedJson;

	@Before
	public void setUp() throws JsonProcessingException{
		Person p1 = new Person("郑楠",35,"上海");
		Person p2 = new Person("郑毅泽",5,"北京");
		pr.save(p1);
		pr.save(p2);
		expectedJson = Obj2String(pr.findAll());
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	protected String Obj2String(Object obj) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}

	@Test
	public void contextLoads() throws Exception{

		String uri = "/persons";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus();
		String content = result.getResponse().getContentAsString();

		Assert.assertEquals("错误，正确的返回值为200", 200, status);
		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson, content);
	}

}
