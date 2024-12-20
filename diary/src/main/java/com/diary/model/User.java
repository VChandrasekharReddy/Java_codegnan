package com.diary.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private String userid;
	private String username;
	private String mobilenumber;
	private String email;
	private String password;
	private String question;
	private String answer;
	private LocalDateTime dateofjoin;
	private LocalDate dataofbirth;
	private int activedays;
	
	
	
	public User(String userid, String username, String mobilenumber, String email, String password, String question,
			String answer, LocalDateTime dateofjoin, LocalDate dataofbirth, int activedays) {
		super();
		this.userid = userid;
		this.username = username;
		this.mobilenumber = mobilenumber;
		this.email = email;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.dateofjoin = dateofjoin;
		this.dataofbirth = dataofbirth;
		this.activedays = activedays;
	}
	
	
	public LocalDate getDataofbirth() {
		return dataofbirth;
	}
	public void setDataofbirth(LocalDate dataofbirth) {
		this.dataofbirth = dataofbirth;
	}
	public int getActivedays() {
		return activedays;
	}
	public void setActivedays(int activedays) {
		this.activedays = activedays;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public LocalDateTime getDateofjoin() {
		return dateofjoin;
	}
	public void setDateofjoin(LocalDateTime dateofjoin) {
		this.dateofjoin = dateofjoin;
	}
	
}
