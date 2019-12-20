package com.flowics.proxy.domain.twitter;

import java.util.ArrayList;
import java.util.List;

public class Polls {

	private List<Options> options = new ArrayList<Options>();
	
	private String end_datetime;
	
	private String duration_minutes;

	public List<Options> getOptions() {
		return options;
	}

	public void setOptions(List<Options> options) {
		this.options = options;
	}

	public String getEnd_datetime() {
		return end_datetime;
	}

	public void setEnd_datetime(String end_datetime) {
		this.end_datetime = end_datetime;
	}

	public String getDuration_minutes() {
		return duration_minutes;
	}

	public void setDuration_minutes(String duration_minutes) {
		this.duration_minutes = duration_minutes;
	}
	
	
}
