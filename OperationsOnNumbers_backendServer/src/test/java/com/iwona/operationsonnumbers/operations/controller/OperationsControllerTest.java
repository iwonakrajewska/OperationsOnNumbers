package com.iwona.operationsonnumbers.operations.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.iwona.operationsonnumbers.config.AppConfig;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = AppConfig.class)
public class OperationsControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void nothing() {
	}

	@Test
	public void testGet() throws Exception {
		this.mockMvc.perform(get("/test/ok")).andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Get, Test body string"));
	}

	@Test
	public void invalidUrl() throws Exception {
		this.mockMvc.perform(get("/nonExisitngUrl")).andExpect(status().isNotFound());
	}

}