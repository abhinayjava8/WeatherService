package com.example.weather.demo.DTO;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private Hourly[] hourly;

	/**
	 * @return the hourly
	 */
	public Hourly[] getHourly() {
		return hourly;
	}

	/**
	 * @param hourly
	 *            the hourly to set
	 */
	public void setHourly(Hourly[] hourly) {
		this.hourly = hourly;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [hourly=" + Arrays.toString(hourly) + "]";
	}

}
