package com.iwona.operationsonnumbers.numbers.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.google.gson.Gson;
import com.iwona.operationsonnumbers.config.AppConfig;
import com.iwona.operationsonnumbers.numbers.request.TwoNumbersRequest;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes = AppConfig.class)
public class NumbersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testAddition() throws Exception {
		this.mockMvc.perform(post("/addition").contentType(MediaType.APPLICATION_JSON).content(requestWithIntegers()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("11")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testAdditionDecimal() throws Exception {
		this.mockMvc.perform(post("/addition").contentType(MediaType.APPLICATION_JSON).content(requestWithDecimal()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("3.1")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testAdditionZero() throws Exception {
		this.mockMvc.perform(post("/addition").contentType(MediaType.APPLICATION_JSON).content(requestWithZero()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("-11.0")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testAdditionEmpty() throws Exception {
		this.mockMvc.perform(post("/addition").contentType(MediaType.APPLICATION_JSON).content(requestWithEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages").value("Number1: incorrect numeric value"));
	}

	@Test
	public void testAdditionBothEmpty() throws Exception {
		this.mockMvc.perform(post("/addition").contentType(MediaType.APPLICATION_JSON).content(requestWithBothEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages[0]").value("Number1: incorrect numeric value"))
				.andExpect(jsonPath("$.messages[1]").value("Number2: incorrect numeric value"));
	}

	@Test
	public void testSubtractionInteger() throws Exception {
		this.mockMvc
				.perform(post("/subtraction").contentType(MediaType.APPLICATION_JSON).content(requestWithIntegers()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("3")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testSubtractionDecimal() throws Exception {
		this.mockMvc.perform(post("/subtraction").contentType(MediaType.APPLICATION_JSON).content(requestWithDecimal()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("-11.1")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testSubtractionZero() throws Exception {
		this.mockMvc.perform(post("/subtraction").contentType(MediaType.APPLICATION_JSON).content(requestWithZero()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("-11.0")).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testSubtractionEmpty() throws Exception {
		this.mockMvc.perform(post("/subtraction").contentType(MediaType.APPLICATION_JSON).content(requestWithEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages").value("Number1: incorrect numeric value"));
	}

	@Test
	public void testSubtractionBothEmpty() throws Exception {
		this.mockMvc
				.perform(post("/subtraction").contentType(MediaType.APPLICATION_JSON).content(requestWithBothEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages[0]").value("Number1: incorrect numeric value"))
				.andExpect(jsonPath("$.messages[1]").value("Number2: incorrect numeric value"));
	}

	@Test
	public void testMultiplicationInteger() throws Exception {
		this.mockMvc
				.perform(post("/multiplication").contentType(MediaType.APPLICATION_JSON).content(requestWithIntegers()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("28")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testMultiplicationDecimal() throws Exception {
		this.mockMvc
				.perform(post("/multiplication").contentType(MediaType.APPLICATION_JSON).content(requestWithDecimal()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("-28.4")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testMultiplicationZero() throws Exception {
		this.mockMvc.perform(post("/multiplication").contentType(MediaType.APPLICATION_JSON).content(requestWithZero()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("0.0")).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testMultiplicationEmpty() throws Exception {
		this.mockMvc
				.perform(post("/multiplication").contentType(MediaType.APPLICATION_JSON).content(requestWithEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages", hasSize(1)))
				.andExpect(jsonPath("$.messages").value("Number1: incorrect numeric value"));
	}

	@Test
	public void testMultiplicationBothEmpty() throws Exception {
		this.mockMvc
				.perform(
						post("/multiplication").contentType(MediaType.APPLICATION_JSON).content(requestWithBothEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages", hasSize(2)))
				.andExpect(jsonPath("$.messages[0]").value("Number1: incorrect numeric value"))
				.andExpect(jsonPath("$.messages[1]").value("Number2: incorrect numeric value"));
	}

	@Test
	public void testDivisionInteger() throws Exception {
		this.mockMvc.perform(post("/division").contentType(MediaType.APPLICATION_JSON).content(requestWithIntegers()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("1.75")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testDivisionDecimal() throws Exception {
		this.mockMvc.perform(post("/division").contentType(MediaType.APPLICATION_JSON).content(requestWithDecimal()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").value("-0.56")).andExpect(jsonPath("$.messages").isEmpty());
	}

	@Test
	public void testDivisionZero() throws Exception {
		this.mockMvc.perform(post("/division").contentType(MediaType.APPLICATION_JSON).content(requestWithZero()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages", hasSize(1)))
				.andExpect(jsonPath("$.messages[0]").value("Number2: value 0 not allowed"));
	}

	@Test
	public void testDivisionEmpty() throws Exception {
		this.mockMvc.perform(post("/division").contentType(MediaType.APPLICATION_JSON).content(requestWithEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages", hasSize(2)))
				.andExpect(jsonPath("$.messages[0]").value("Number1: incorrect numeric value"))
				.andExpect(jsonPath("$.messages[1]").value("Number2: value 0 not allowed"));
	}

	@Test
	public void testDivisionBothEmpty() throws Exception {
		this.mockMvc.perform(post("/division").contentType(MediaType.APPLICATION_JSON).content(requestWithBothEmpty()))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.numberText").isEmpty()).andExpect(jsonPath("$.messages").isArray())
				.andExpect(jsonPath("$.messages", hasSize(2)))
				.andExpect(jsonPath("$.messages[0]").value("Number1: incorrect numeric value"))
				.andExpect(jsonPath("$.messages[1]").value("Number2: incorrect numeric value"));
	}

	private String requestWithIntegers() {
		TwoNumbersRequest request = new TwoNumbersRequest();
		request.setNumberText1("7");
		request.setNumberText2("4");
		return new Gson().toJson(request);
	}

	private String requestWithDecimal() {
		TwoNumbersRequest request = new TwoNumbersRequest();
		request.setNumberText1("-4");
		request.setNumberText2("7.1");
		return new Gson().toJson(request);
	}

	private String requestWithZero() {
		TwoNumbersRequest request = new TwoNumbersRequest();
		request.setNumberText1("-11");
		request.setNumberText2("0.0");
		return new Gson().toJson(request);
	}

	private String requestWithEmpty() {
		TwoNumbersRequest request = new TwoNumbersRequest();
		request.setNumberText1("");
		request.setNumberText2("0");
		return new Gson().toJson(request);
	}

	private String requestWithBothEmpty() {
		TwoNumbersRequest request = new TwoNumbersRequest();
		request.setNumberText1(" ");
		request.setNumberText2(null);
		return new Gson().toJson(request);
	}

}