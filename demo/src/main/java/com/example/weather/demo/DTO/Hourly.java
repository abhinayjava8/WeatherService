package com.example.weather.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Hourly {

	private String time;
	private String tempF;
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the tempF
	 */
	public String getTempF() {
		return tempF;
	}
	/**
	 * @param tempF the tempF to set
	 */
	public void setTempF(String tempF) {
		this.tempF = tempF;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Hourly [time=" + time + ", tempF=" + tempF + "]";
	}
	
	
	
	
	
	
}
