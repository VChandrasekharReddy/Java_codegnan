package com.diary.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Data {
	private String userid;
	 private LocalDateTime date;
	private String mater;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public String getMater() {
		return mater;
	}
	public void setMater(String mater) {
		this.mater = mater;
	}
	public Data(String userid, LocalDateTime localDate, String mater) {
		super();
		this.userid = userid;
		this.date = localDate;
		this.mater = mater;
	}
	
}
