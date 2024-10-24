package com.contactbook.services;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.contactbook.dao.ContactDAOImpl;
import com.contactbook.dao.ContactDAOInterface;
import com.contactbook.model.Contact;

public class ContactServiceImpl implements ContactServiceInterface,ColourCodeInterface{

	
	ContactDAOInterface contactdao= new ContactDAOImpl();
	@Override
	public void addContact(List<Contact> contactlist) throws SQLException {
		// TODO Auto-generated method stub
		int count=0;
		for(Contact contact:contactlist) {
			try {
				if(validatePhoneNumber(contact.getNumber())) {
					count+=contactdao.addContact(contact);
				}
			}catch(NumberFormatException e) {
				e.printStackTrace();
				System.out.println("for :-> "+contact.getName());
			}
			
		}
		System.out.println(brightPurple+bold+"Number of Contacts added are : ->"+reset+""+bold+""+count+""+reset);
		
	}

	@Override
	public void viewContacts() throws SQLException {
		Random r = new Random();
		int l = colorCodes.length;
		// TODO Auto-generated method stub
		List<Contact> contactlist = contactdao.viewContacts();
		Collections.sort(contactlist);
		String name ="Name";
		String number = "Number";
		for(Contact contact : contactlist) {
			System.out.printf("%s :-> %-35s %s :-> %s\n",brightGreen+bold+name+reset,colorCodes[r.nextInt(l)]+bold+contact.getName()+reset,brightOrange+bold+number+reset,colorCodes[r.nextInt(l)]+underline+contact.getNumber()+reset);
		}
	}
	@Override
	public void searchContactByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		contactdao.searchContactByName(name);
		
	}

	@Override
	public void searchContactByNumber(String number) throws SQLException {
		// TODO Auto-generated method stub
		contactdao.searchContactByNumber(number);
		
	}


	public boolean validatePhoneNumber(String number) throws NumberFormatException {
		String mobilenumber = Long.valueOf(number)+"";
		boolean status = true;
		if(mobilenumber.length()==10) {
			status=true;
		}else if(mobilenumber.length()==12 && mobilenumber.substring(0,3).equals("91")) status=true;
		else {
			status=false;
			throw new NumberFormatException("invalid number format");
		}
		return status;
	}

	@Override
	public void deleteContact(String name) throws SQLException {
		// TODO Auto-generated method stub
		contactdao.deleteContact(name);
		
	}

	@Override
	public void editContact(Contact oldcontact, Contact newcontact) throws SQLException {
		// TODO Auto-generated method stub
		try {
			if(validatePhoneNumber(oldcontact.getNumber()) && validatePhoneNumber(newcontact.getNumber())) {
				contactdao.editContact(oldcontact, newcontact);
			}
		}catch(NumberFormatException e) {
			System.out.println(e);
		}
		
	}



}
