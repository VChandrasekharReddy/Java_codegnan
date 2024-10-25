

import java.util.Scanner;

public class AddressBookApp {
	Connection con = null;
	Statement st =null;
	ResultSet rs= null;
	String name,number;
	Scanner sc = new Scanner(System.in);
	
	
	
	
	//method for adding the contect in the databse;
	public void addContact() {
		System.out.print("Enter the name  of the persion :->");
		name = sc.nextLine();
		if(checkName(name) && name.length()>0) {
			System.out.print("Enter the Mobile numnber for "+ name+" :->");
			number = sc.nextLine();
			if(checkNumber(number) && number.length()>0) {
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
					st = con.createStatement();
					boolean bb = st.executeUpdate("insert into book values('"+name+"','"+number+"');") > 0;
					if(bb) {
					    System.out.println("added contact .......");
					} else {
					    System.out.println("error......");
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					if(con != null) {
						try {
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(st!=null) {
						try {
							st.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					if(rs!=null) {
						try {
							rs.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	
	
	// method for view all list of contacts inthe databse;
	public void viewContacts() {
		try {
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			st = con.createStatement();
			rs = st.executeQuery("select * from book;");
			while(rs.next()) {
				System.out.printf("Name:-> %-15s\tContact Number:-> %s\n", rs.getString("name"), rs.getString("mobile_number"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(st != null) {
				try {
					st.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs !=null) {
				try {
					rs.close();
				}catch(SQLException e ) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	// fro case 3 : ---> search the contact by the name
	public void serchContact() {
		System.out.print("Enter Name to search:");
		name = sc.nextLine();
		boolean s=true;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			st = con.createStatement();
			rs= st.executeQuery("select * from book;");
			while(rs.next()) {
				if(name.equals(rs.getString("name"))) {
					s=false;
					System.out.printf("Name:-> %-15s\tContact Number:-> %s\n", rs.getString("name"), rs.getString("mobile_number"));
					break;
				}
			}
			if(s) {
				System.out.println("there is no contact saved with this name : "+name);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(st!=null) {
				try {
					st.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException e ) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	// case 4 =============> to edit the contact:
	public void editContact() {
		System.out.print("Enter Name to edit the contact : -> ");
		name = sc.nextLine();
		if(checkName1(name)&&name.length()>0) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
				st= con.createStatement();
				System.out.println("choose \n1. for change the name only\n2. for change the number only \n3 for change both name and number ");
				System.out.print("Eneter");
				int ch = sc.nextInt();
				sc.nextLine();
				switch(ch) {
				case 1:
					System.out.print("Enter the new contact Name: ->");
					String newname = sc.nextLine();
					if(checkName(newname)) {
						boolean bb = st.executeUpdate("UPDATE book SET name = '"+newname+"' WHERE name = '"+name+"'") > 0;
						if(bb) {
						    System.out.println("Contact updated successfully.......");
						} else {
						    System.out.println("Error updating contact......");
						}	
					}

					break;
				case 2:
					System.out.print("Enter the new contact Number: ->");
					String newnumber = sc.nextLine();
					if(checkNumber(newnumber)) {
						boolean bb1 = st.executeUpdate("UPDATE book SET mobile_number = '"+newnumber+"' WHERE name = '"+name+"'") > 0;
						if(bb1) {
						    System.out.println("Contact updated successfully.......");
						} else {
						    System.out.println("Error updating contact......");
						}
					}
					break;
				case 3:
					System.out.print("Enter the new contact Name: ->");
					String newname1 = sc.nextLine();
					System.out.print("Enter the new contact Number: ->");
					String newnumber1 = sc.nextLine();
					if(checkName(newname1) && checkNumber(newnumber1)) {
						boolean bb11 = st.executeUpdate("UPDATE book SET mobile_number = '"+newnumber1+"', name = '"+newname1+"' WHERE name = '"+name+"'") > 0;
						if(bb11) {
						    System.out.println("Contact updated successfully.......");
						} else {
						    System.out.println("Error updating contact......");
						}	
					}
					break;
				default:
					System.out.println("enter b/w 1 and 3 only");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	//case 5 remove conteact method that removes the contact from the database
	public void removeContact() {
		System.out.print("Enter the  contact Name you want to remove: ->");
		name = sc.nextLine();
		if(checkName1(name)) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
				st = con.createStatement();
				boolean bbb = st.executeUpdate("delete from book where name = '"+name+"';")>0;
				if(bbb) {
				    System.out.println("Contact removed successfully.......");
				} else {
				    System.out.println("Error removing contact......");
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(con != null) {
					try {
						con.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}
				if(st!=null) {
					try {
						st.close();
					}catch(SQLException e){
						e.printStackTrace();
					}
				}
				if(rs!=null) {
					try {
						rs.close();
					}catch(SQLException e ) {
						e.printStackTrace();
					}
				}
			}
			
		}
		else System.out.println("dontact doesen't exist ...");
	}
	
	
	
	//to checck wether the name is already exist inthe database or not
	public boolean checkName(String name) {
		boolean b= true;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			st = con.createStatement();
			rs = st.executeQuery("select * from book;");
			while(rs.next()) {
				if(name.equals(rs.getString("name"))) {
					System.out.println("the contanct is already exist \n name :"+rs.getString("name")+"\n contact Number : ->"+rs.getString("mobile_number"));
					b=false;
					if(con != null) {
						con.close();
					}
					if(st!=null) {
						st.close();
					}
					if(rs!=null) {
						rs.close();
					}
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	
	
	// for case 4 checkingthe name is existing in database ========================>
	public boolean checkName1(String name) {
		boolean b= false;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
			st = con.createStatement();
			rs = st.executeQuery("select * from book;");
			while(rs.next()) {
				if(name.equals(rs.getString("name"))) {
					b=true;
					if(con != null) {
						con.close();
					}
					if(st!=null) {
						st.close();
					}
					if(rs!=null) {
						rs.close();
					}
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return b;
		
	}
	
	
//	this method is used to check weteher the number is valied and the number is alrady exist in hte database or not
	public boolean checkNumber(String number) {
		boolean b= true;
		for(int i=0;i<number.length();i++) {
			if(!Character.isDigit(number.charAt(i))) {
				b=false;
				break;
			}
		}
		if(b) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook","root","root");
				st = con.createStatement();
				rs = st.executeQuery("select * from book;");
				while(rs.next()) {
					if(number.equals(rs.getString("mobile_number"))) {
						System.out.println("the contanct is already exist \n name :"+rs.getString("name")+"\n contact Number : ->"+rs.getString("mobile_number"));
						b=false;
						if(con != null) {
							con.close();
						}
						if(st!=null) {
							st.close();
						}
						if(rs!=null) {
							rs.close();
						}
						break;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return b;
	}
	

	public static void main(String[] args) {
		AddressBookApp book = new AddressBookApp();
		Scanner scanner = new Scanner(System.in);
		boolean b= true;
		int n =0;
		System.out.println("Enter your choise : -----");
		while(b) {
			System.out.print("\n1. Add Contact\n2. View Contacts\n3. Search Contact\n4. Edit Contact\n5. Remove Contact\n6. Exit\n Enter : ->");
			n = scanner.nextInt();
			scanner.nextLine();
			switch(n) {
			case 1:
				book.addContact();
				break;
			case 2:
				book.viewContacts();
				break;
			case 3:
				book.serchContact();
				break;
			case 4:
				book.editContact();
				break;
			case 5:
				book.removeContact();
				break;
			case 6:
				b=false;
				break;
				default:
					System.out.println(" choose only b/w 1 and 6 only :->");
			}
		}
		scanner.close();
	}
}