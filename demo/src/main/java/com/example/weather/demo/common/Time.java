package com.example.weather.demo.common;

import java.util.HashMap;
import java.util.Map;

public enum Time {

	TIME0("0", "12 AM"), TIME1("100", "1 AM"), TIME2("200", "2 AM"), TIME3(
			"300", "3 AM"), TIME4("400", "4 AM"), TIME5("500", "5 AM"), TIME6(
			"600", "6 AM"), TIME7("700", "7 AM"), TIME8("800", "8 AM"), TIME9(
			"900", "9 AM"), TIME10("1000", "10 AM"), TIME11("1100", "11 AM"), TIME12(
			"1200", "12 AM"), TIME13("1300", "1 PM"), TIME14("1400", "2 PM"), TIME15(
			"1500", "3 PM"), TIME16("1600", "4 PM"), TIME17("1700", "5 PM"), TIME18(
			"1800", "6 PM"), TIME19("1900", "7 PM"), TIME20("2000", "8 PM"), TIME21(
			"2100", "9 PM"), TIME22("2200", "10 PM"), TIME23("2300", "11 PM");

	private final String time;
	private final String readable_Time;
	private static final Map<String, String> MAP = new HashMap<String, String>();
	static {
		for (Time s : Time.values()) {
			MAP.put(s.time, s.readable_Time);
		}
	}

	private Time(String time, String readable_Time) {
		this.time = time;
		this.readable_Time = readable_Time;
	}

	public String getTime() {
		return time;
	}

	public String getReadable_Time() {
		return readable_Time;
	}

	public static String getByTime(String time) {
		return MAP.get(time);
	}

}
