package com.contactbook.model;

public class Contact implements Comparable<Contact> {
	private String name ;
	private String number;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Contact(String name, String number) {
		super();
		this.name = name;
		this.number = number;
	}
	@Override
	public int compareTo(Contact o) {
		// TODO Auto-generated method stub
		return (this.name).compareTo(o.name);
	}

	
}
