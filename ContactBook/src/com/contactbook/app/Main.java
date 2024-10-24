package com.contactbook.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.contactbook.model.Contact;
import com.contactbook.services.ColourCodeInterface;
import com.contactbook.services.ContactServiceImpl;
import com.contactbook.services.ContactServiceInterface;


public class Main implements ColourCodeInterface{
	public static void main(String[] args) throws SQLException {
		Main m = new Main();
		List<Contact> contactlist = new ArrayList<>();
		ContactServiceInterface contactservice = new ContactServiceImpl();
		Scanner sc = new Scanner(System.in);
		String reset = "\u001B[0m";    // Reset to default color
		String[] colourCodes = m.colorCodes;
		int l = colourCodes.length;
		Random r = new Random();		
		boolean b = true;
		while(b) {
			System.out.println(colourCodes[r.nextInt(l)]+bold+"Enter Your Choose\n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"1. Add List of contacts\n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"2. View all the contacts\n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"3. Search the contact by name \n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"4. Search the contact by Number \n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"5. Edit the contact \n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"6. Delete contact \n"+reset+""
					+colourCodes[r.nextInt(l)]+bold+"7. To Exit"+reset);
			int n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				contactlist.clear();
				while(true) {
					System.out.print(brightGreen+bold+"Enter the name or enter '0' for stop adding : ->"+reset);
					String name = sc.nextLine();
					if(name.equals("0")) {
						break;
					}else {
						System.out.print(brightOrange+bold+"Enter the Mobile Number:->"+reset);
						String number = sc.nextLine();
						contactlist.add(new Contact(name,number));
					}
				}
				
				contactservice.addContact(contactlist);
				break;
			case 2:
				contactservice.viewContacts();
				break;
			case 3:
				System.out.print(brightGreen+bold+"Enter the name to search: ->"+reset);
				String searchname = sc.nextLine();
				contactservice.searchContactByName(searchname);
				break;
			case 4:				
				System.out.print(brightOrange+bold+"Enter the contactnumber to search: ->"+reset);
				String searchnumber = sc.nextLine();
				contactservice.searchContactByNumber(searchnumber);
				break;
			case 5:
				System.out.print(brightGreen+bold+"give the name of the contact :"+reset);
				String oldname = sc.nextLine();
				System.out.print(brightOrange+bold+"give the number of the contact :"+reset);
				String oldnumber = sc.nextLine();
				Contact oldcontact = new Contact(oldname,oldnumber);
				System.out.print(brightGreen+bold+"give the new name of the contact :"+reset);
				String newname = sc.nextLine();
				System.out.print(brightOrange+bold+"give the new number of the contact :"+reset);
				String newnumber = sc.nextLine();
				Contact newcontact = new Contact(newname,newnumber);	
				contactservice.editContact(oldcontact,newcontact);
				break;
			case 6:
				System.out.print(brightGreen+bold+"Enter the name to delet: ->"+reset);
				String deletename = sc.nextLine();
				contactservice.deleteContact(deletename);
				break;
			case 7:
				b=false;
				break;
			default:
				System.out.println(red+bold+"Choose between the numbers from 1 to 6 only "+reset);
			
			}
		}
		sc.close();
	}

}
