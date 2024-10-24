package com.contactbook.services;

import java.sql.SQLException;
import java.util.List;

import com.contactbook.model.Contact;

public interface ContactServiceInterface {
	void addContact(List<Contact> contactlist) throws SQLException;
	public void viewContacts() throws SQLException;
	public void editContact(Contact oldcontact,Contact newcontact) throws SQLException;
	public void deleteContact(String name) throws SQLException;
	void searchContactByName(String name) throws SQLException;
	void searchContactByNumber(String number) throws SQLException;
	public boolean validatePhoneNumber(String number) throws NumberFormatException;
	
	
}
