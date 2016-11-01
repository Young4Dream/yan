package com.spring.mvc.pojo;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Primary
@Order(value=1)
public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;//纬度
	private Double longitude;//经度
	public Spittle(String message, Date time) {
		this(null,message,time,null,null);
	}
	public Spittle(Long id,String message, Date time, Double latitude, Double longitude) {
		super();
		this.id =id;
		this.message = message;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Spittle() {
		super();
		this.id =(long) 1;
		this.message = "";
		this.time = new Date();
		this.latitude = (double) 1;
		this.longitude = (double) 1;
	}
	public Double getLatitude() {
		return latitude;
	}
	@Override
	public String toString() {
		return "Spittle [id=" + id + ", message=" + message + ", time=" + time + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
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
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this,obj,new String[]{"id","time"});
	}
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this,new String[]{"id","time"});
	}
}
