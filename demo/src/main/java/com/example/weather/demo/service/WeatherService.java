package com.example.weather.demo.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.example.weather.demo.DTO.Hourly;
import com.example.weather.demo.DTO.Response;
import com.example.weather.demo.DTO.Weather;
import com.example.weather.demo.common.Time;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class WeatherService {

	@Value("${api.key}")
	private String apiKey;

	@Value("${api.url}")
	private String apiUrl;

	@Autowired
	RestTemplate restTemplate;

	public String getTodayMinTemp(String zipcode) {
		String response = "";
		LocalDate tomorrow = LocalDate.now().plusDays(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String tomorrow_date = tomorrow.format(formatter);
		String append_url = "&date=" + tomorrow_date + "&q=" + zipcode
				+ "&key=" + apiKey;
		try {
			response = restTemplate.getForObject(apiUrl + append_url,
					String.class);
			if (response != null || !StringUtils.isEmpty(response)) {
				return parserResponse(response);
			} else {
				return "NO DATA..";
			}
		} 
		catch (Exception ex) {
			System.out.println("Exception :: "+ex);
			return "Weather service is temporarily down....";
		}
	}

	private String parserResponse(String resp) throws JsonParseException,
			JsonMappingException, IOException {
		TreeMap<String, String> trMap = new TreeMap<String, String>();
		ObjectMapper mapper = new ObjectMapper();
		Response respdto = mapper.readValue(resp, Response.class);
		if(respdto.getData().getWeather()==null){
			return "No Data found for the given zip code";
		}
		else {
		for (Weather weaObj : respdto.getData().getWeather()) {
			for (Hourly hrObj : weaObj.getHourly()) {
				if (trMap.get(hrObj.getTempF()) == null) {
					trMap.put(hrObj.getTempF(), hrObj.getTime());
				} else {
					trMap.put(hrObj.getTempF(), trMap.get(hrObj.getTempF())
							+ "," + hrObj.getTime());
				}
			}
		}
		return convertToRedableTime(trMap.keySet().toArray()[0].toString()
				+ "-" + trMap.get(trMap.keySet().toArray()[0].toString()));
		}

	}

	private String convertToRedableTime(String apiResp) {
		StringBuilder response = new StringBuilder();
		response.append("Tomorrow temperature is low at ");
		String[] timeArray = apiResp.split("-")[1].split(",");
		for (String st : timeArray) {
			response.append(Time.getByTime(st) + ", ");
		}
		return response.toString().substring(0,
				response.toString().length() - 2)
				+ " and temperature is " + apiResp.split("-")[0] + " F";
	}

}
