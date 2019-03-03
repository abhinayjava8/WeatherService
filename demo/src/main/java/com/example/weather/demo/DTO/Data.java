package com.example.weather.demo.DTO;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

	private Weather[] weather;

	/**
	 * @return the weather
	 */
	public Weather[] getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data [weather=" + Arrays.toString(weather) + "]";
	}

	
}
