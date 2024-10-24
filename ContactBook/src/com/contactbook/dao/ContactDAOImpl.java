package com.contactbook.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.contactbook.model.Contact;
import com.contactbook.util.DBUtil;

public class ContactDAOImpl implements ContactDAOInterface{

	@Override
	public int addContact(Contact contact) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		int status = st.executeUpdate("Insert into book values('"+contact.getName()+"','"+contact.getNumber()+"');");
		if(con!=null) {
			con.close();
		}
		if(st!=null) st.close();
		return status;
	}

	@Override
	public List<Contact> viewContacts() throws SQLException {
		List<Contact> contactlist = new ArrayList<>();
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from book;");
		while(rs.next()) {
			String name = rs.getString("name");
			String number = rs.getString("number");
			contactlist.add(new Contact(name,number));
		}
		System.out.println();
		if(con!=null) con.close();
		if(st!=null) st.close();
		if(rs!=null) rs.close();
		return contactlist;
	}

	@Override
	public void searchContactByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from book where name = '"+name+"';");

		if(rs==null) {
			System.out.println("Name not match....");
		}else {
			while(rs.next()) {
				System.out.printf("Name : %-20s Number : %s\n",rs.getString("name"),rs.getString("number"));
			}
		}
		if(con!=null) con.close();
		if(st!=null) st.close();
	}
	@Override
	public void searchContactByNumber(String number) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from book where number = '"+number+"';");

		if(rs==null) {
			System.out.println("Number not match....");
		}else {
			while(rs.next()) {
				System.out.printf("Name : %-20s Number : %s\n",rs.getString("name"),rs.getString("number"));
			}
		}
		if(con!=null) con.close();
		if(st!=null) st.close();
		
	}


	@Override
	public void deleteContact(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		int status = st.executeUpdate("delete from book where name = '"+name+"';");
		if(status==1) {
			System.out.println("Deleted....");
		}else System.out.println("cant find the name in the database...");
		if(con!=null) con.close();
		if(st!=null) st.close();
	}

	@Override
	public void editContact(Contact oldcontact, Contact newcontact) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = DBUtil.getConnection();
		Statement st = con.createStatement();
		boolean status = st.executeUpdate("update book set name ='"+newcontact.getName()+"', number = '"+newcontact.getNumber()+"'  where name = '"+oldcontact.getName()+"' and "
				+ "number = '"+oldcontact.getNumber()+"';")>0;
		if(status) System.out.println(" updated sucessfully....");
		else System.out.println("details not matching...");
		if(con!=null) con.close();
		if(st!=null) st.close();
		
	}



}
