package com.oaes.login_service;

import com.oaes.login_service.Entity.Admin;
import com.oaes.login_service.Service.AdminService;
import com.oaes.login_service.Service.AuthorService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest()
@AutoConfigureMockMvc
public class LoginServiceApplicationTests {

	@Autowired
	AdminService adminService;
	@Autowired
	AuthorService authorService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
//	@Autowired
//	Jackson2ObjectMapperBuilder builder;


	@Test
	void contextLoads() {
	}

	// First Predicate to be tested
	// Predicate is

	// line 33 in login controller
	/*
	Clause a: username.length() < 4
	Clause b: username.length() > 20
	Clause c: password.length() < 4
	Clause d: password.length() > 20
   	*/

	// Test Case 1: a is major and  b,c,d are minor
	//Predicate is true, when a is true.
	@Test
	public void registerAdminTest1() throws Exception {
		Admin admin = new Admin(5, "abc", "abcdefgh");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("false"));
	}

	// Test Case 2: a is major and b,c,d are minor
	// predicate is false , when a is false

	@Test
	public void registerAdminTest2() throws Exception {
		Admin admin = new Admin(5, "Rama", "RamaChand");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("true"));
	}

	// Test Case 3: b is major and a,c,d are minor
	// predicate is true , when b is true

	@Test
	public void registerAdminTest3() throws Exception {
		Admin admin = new Admin(6, "RamaChandraKripaluBhajman", "RamaChand1");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("false"));
	}

	// Test Case 4: b is major and a,c,d are minor
	// predicate is false , when b is false

	@Test
	public void registerAdminTest4() throws Exception {
		Admin admin = new Admin(6, "Monu", "MonuChand");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("true"));
	}

	// Test Case 5: c is major and a,b,d are minor
	// predicate is true , when c is true

	@Test
	public void registerAdminTest5() throws Exception {
		Admin admin = new Admin(6, "RamShyam", "hello");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("false"));
	}

	// Test Case 6: c is major and a,b,d are minor
	// predicate is false , when c is false
	@Test
	public void registerAdminTest6() throws Exception {
		Admin admin = new Admin(6, "RamShyam1", "HelloNamaste");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("true"));
	}

	// Test Case 7: d is major and a,b,c are minor
	// predicate is true , when d is true
	@Test
	public void registerAdminTest7() throws Exception {
		Admin admin = new Admin(6, "ShyamRam", "RamaChandraKripaluBhajman");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("false"));
	}

	// Test Case 8: d is major and a,b,c are minor
	// predicate is false , when d is false
	@Test
	public void registerAdminTest8() throws Exception {
		Admin admin = new Admin(6, "ShyamRam", "RamShyam");
		mockMvc.perform(MockMvcRequestBuilders.post("/user/admin/register").contentType("application/json")
				.content(objectMapper.writeValueAsString(admin))).andExpect(content().string("true"));
	}
}