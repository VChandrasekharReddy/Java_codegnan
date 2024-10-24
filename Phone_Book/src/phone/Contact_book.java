package phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Contact_book extends Text_Format {
	Connection con = null;
	Map<String,String> contactlist = new HashMap<>();
	Map<String,String> dblist = new HashMap<>();
	Scanner sc=new Scanner(System.in);
	Random r = new Random();
	int l = colorCodes.length;
	//Constructor 
	Contact_book() throws SQLException{
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
		updatedblist();
	}
	
	//method to add the data to the database;
	public void addContacts() throws SQLException {
		int effect =0;
		contactlist.clear();
		while(true) {
			System.out.print(purple+bold+"Enter the name or enter '0' for stop adding : ->"+reset );
			String name = sc.nextLine();
			if(name.equals("0")) {
				break;
			}
			else {
				if(dblist.containsKey(name)) {
					System.out.println(red+bold+"name already exist .....\n"+reset);
				}else {
					System.out.print(cyan+bold+"Enter the Mobile number: ->"+reset);
					String number = Long.valueOf(sc.nextLine())+"";
					if(checkNumber(number)) {
						contactlist.put(name, number);
					}else {
						System.out.println(red+bold+"Invalid Number ....\n"+reset);
					}
				}
				
			}
		}		
		String insertquery="insert into book values(?,?)";
		PreparedStatement ps = con.prepareStatement(insertquery);
		for(String name : contactlist.keySet()) {
			ps.setString(1, name);
			ps.setString(2, contactlist.get(name));
			effect+=ps.executeUpdate();
		}
		System.out.println(green+bold+" Number of Contacts added : "+reset+""+resetBold+""+effect+""+reset);
		ps.close();
		updatedblist();
		
		
	}
	
	
	
	//for display the contacts
	public void viweContacts() throws SQLException {
		String name ="Name",number = "Number";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from book;");
		dblist.clear();
		while(rs.next()) {
			dblist.put(rs.getString("name"), rs.getString("number"));
			System.out.printf(" %s : %-20s %s : %s\n",purpleBackground+brightWhite+name+reset,purple+rs.getString("name")+reset,blueBackground+brightWhite+number+reset,blue+rs.getString("number")+reset);
		}
		if(st!=null) {
			st.close();
		}
		if(rs!=null) {
			rs.close();
		}
		System.out.println();
	}
	
	
	//for searching the contacts
	public void searchContact() throws SQLException {
		String name ="Name",number = "Number";
		System.out.print(brightBlue+bold+"Enter the name to search : ->"+reset);
		String sn =sc.nextLine();
		Statement st  = con.createStatement();
		ResultSet rs = st.executeQuery("select * from book where name ='"+sn+"';");
		if(rs.next()) {
			System.out.printf("%s : %s %30s : %s\n\n",purpleBackground+white+name+reset,purple+rs.getString("name")+reset,blueBackground+white+number+reset,blue+rs.getString("number")+reset);
			rs.close();
		}else {
			System.out.println("no Contact with that name...");
			if(st!=null) st.close();
		}
	}
	
	
	//for edit the contact 
	public void editContact() throws SQLException {
		
		System.out.print(brightBlue+bold+"Enter the name  to edit the contact:-"+reset);
		String oname=sc.nextLine();
		if(dblist.containsKey(oname)) {
			boolean b = true;
			while(b) {
				System.out.print(colorCodes[r.nextInt(l)]+"1. to update Name\n"+reset+""+colorCodes[r.nextInt(l)]+"2. To change Number\n"+reset+""+colorCodes[r.nextInt(l)]+""+"3. To exit \n"+reset+""+colorCodes[r.nextInt(l)]+" :->");
				int n =sc.nextInt();
				sc.nextLine();
				switch(n) {
				case 1:
					System.out.print(colorCodes[r.nextInt(l)]+bold+"Enter the new name : ->"+reset);
					String nname = sc.nextLine();
					if(!dblist.containsKey(nname)) {
						Statement st = con.createStatement();
						boolean updatestatus = st.executeUpdate("update book set name = '"+nname+"' where name = '"+oname+"';")>0;
						if(updatestatus) {
							System.out.println(green+bold+"Contact Updated Sucessfully...."+reset);
							updatedblist();
							b=false;
							st.close();
						}
					}else System.out.println(red+bold+"The name is already Exit Choose the alternate name..."+reset);
					break;
				case 2 :
					System.out.print(colorCodes[r.nextInt(l)]+bold+"Enter the New Number :->"+reset);
					String nnumber = sc.nextLine();
					if(checkNumber(nnumber)) {
						if(!dblist.containsKey(nnumber)) {
							Statement st = con.createStatement();
							boolean updatestatus = st.executeUpdate("update book set number = '"+nnumber+"' where name = '"+oname+"';")>0;
							if(updatestatus) {
								System.out.println(green+bold+"Contact Updated Sucessfully...."+reset);
								updatedblist();
								b=false;
								st.close();
							}
						}else System.out.println(red+bold+"The given number is already exist in the book...."+bold);
					}else System.out.println(red+bold+"Invalid Number Entered Please Check Number once..."+bold);
					break;
				case 3 :
					break;
				default : System.out.println(brightCyan+bold+"Choose between 1 and 3 only...."+reset);
				}
			}
		}
	}
	
	
	//delate method for contacts
	public void deleteContact() throws SQLException {
		//Map<String , String > deletelist = new HashMap<>();
		Statement st = con.createStatement();
		System.out.print(brightBlue+bold+"Enter the name  to delete the contact:-"+reset);
		String dn = sc.nextLine();
		if(dblist.containsKey(dn)) {
			boolean status = st.executeUpdate("delete from book where name ='"+dn+"';")>0;
			if(status) {
				System.out.println(brightGreen+bold+"Contact Deleted sucessfully....."+reset);
			}
			else {
				System.out.println(brightRed+bold+"no contacts matched to delete"+reset);
			}
			if(st!=null) {
				st.close();
			}
			updatedblist();
		}
		
	}
	
	//for updating the dblist
	public void updatedblist() throws SQLException {
		Statement st = con.createStatement();
		dblist.clear();
		ResultSet rs = st.executeQuery("select * from book;");
		while(rs.next()) {
			dblist.put(rs.getString("name"), rs.getString("number"));
		}
		if(st!=null) {
			st.close();
		}
		if(rs!=null) {
			rs.close();
		}
	}
	
	
	//to chech teh number is valied or not 
		public boolean checkNumber(String number) {
			boolean b = true;
			if(number.length()==10 || number.length()==12) {
				b=true;
			}else b=false;
			return b;
			
		}
	
		
		public void closeConnections() throws SQLException {
			if(con!=null) con.close();
		}
	
	public static void main(String[] args) throws SQLException {
		Contact_book cb = new Contact_book();
		String reset = "\u001B[0m";    // Reset to default color
		String[] colorCodes = cb.colorCodes;
		int l = colorCodes.length;
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		boolean b = true;
		while(b) {
			System.out.println(colorCodes[r.nextInt(l)]+"Enter Your Choose\n"+reset+
					""+colorCodes[r.nextInt(l)]+"1. Add List of contacts\n"+reset+
					""+colorCodes[r.nextInt(l)]+"2. View all the contacts\n"+reset+
					""+colorCodes[r.nextInt(l)]+"3. Search the contact by name \n"+reset+
					""+colorCodes[r.nextInt(l)]+"4. Edit the contact \n"+reset+
					""+colorCodes[r.nextInt(l)]+"5. Delete contact \n"+reset+
					""+colorCodes[r.nextInt(l)]+"6. To Exit"+reset);
			int n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 1:
				cb.addContacts();
				break;
			case 2:
				cb.viweContacts();
				break;
			case 3:
				cb.searchContact();
				break;
			case 4:
				cb.editContact();
				break;
			case 5:
				cb.deleteContact();
				break;
			case 6:
				b=false;
				break;
			default:
				System.out.println("Choose between the numbers from 1 to 6 only ");
			
			}
		}
		cb.closeConnections();
		sc.close();
	}
}
