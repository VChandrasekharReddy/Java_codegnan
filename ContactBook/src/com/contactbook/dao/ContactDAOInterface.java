package com.contactbook.dao;

import java.sql.SQLException;
import java.util.List;

import com.contactbook.model.Contact;

public interface ContactDAOInterface {
	int addContact(Contact contact) throws SQLException;
	public List<Contact> viewContacts() throws SQLException;
	public void editContact(Contact oldcontact,Contact newcontact) throws SQLException;
	public void deleteContact(String name) throws SQLException;
	void searchContactByName(String name) throws SQLException;
	void searchContactByNumber(String number) throws SQLException;
}
