package com.spring.mvc.pojo;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

//import org.springframework.stereotype.Component;
//@Component
public class Spittle {
	private Long id;
	private String message;
	private Date time;
	private Double latitude;//纬度
	private Double longitude;//经度
	/**
	 * 无参构造
	 */
	public Spittle() {
		super();
	}
	/**
	 * 部分有参构造
	 * @param message
	 * @param time
	 */
	public Spittle(String message, Date time) {
		this(null,message,time,null,null);
	}
	/**
	 * 全参构造
	 * @param id
	 * @param message
	 * @param time
	 * @param latitude
	 * @param longitude
	 */
	
	public Spittle(Long id, String message, Date time, Double latitude,
			Double longitude) {
		super();
		this.id = id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Spittle [id=" + id + ", message=" + message + ", time=" + time
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}
	
	/**
	 * 重写equals和hashCode方法
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj,new String[]{"id","time"});
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this,new String[]{"id","time"});
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
}
