package com.springMVC.spittr;

import java.util.Date;

public class Spittle {
	private final long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	public Spittle(String message, Date time) {
		this(message,time,null,null);
	}
	@SuppressWarnings("null")
	public Spittle(String message, Date time, Double latitude, Double longitude) {
		super();
		this.id = (Long) null;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getTime() {
		return time;
	}
}
