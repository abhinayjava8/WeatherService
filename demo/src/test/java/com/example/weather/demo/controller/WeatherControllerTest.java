package com.example.weather.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.weather.demo.controller.WeatherController;
import com.example.weather.demo.service.WeatherService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WeatherController.class)
public class WeatherControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherService weatherService;

	String expectedOutput = "Tomorrow temperature is low at 4 AM and temperature is 40 F";

	@Test
	public void getMinTempByHour() throws Exception {
		Mockito.when(weatherService.getTodayMinTemp(Mockito.anyString()))
				.thenReturn(expectedOutput);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/demo/weather/85050").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(expectedOutput, result.getResponse().getContentAsString());
	}

	@Test
	public void getMinTempByHourResponseCode() throws Exception {
		Mockito.when(weatherService.getTodayMinTemp(Mockito.anyString()))
				.thenReturn(expectedOutput);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/demo/weather/85050").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	public void getMinTempByHourEmptyResponseTest() throws Exception {
		Mockito.when(weatherService.getTodayMinTemp(Mockito.anyString()))
				.thenReturn(null);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/demo/weather/85050").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("", result.getResponse().getContentAsString());
	}

}
