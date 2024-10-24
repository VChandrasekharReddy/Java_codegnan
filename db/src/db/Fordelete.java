package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Fordelete {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/samdb","root","root");
		String query ="delete from user where id =?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, 2);
		System.out.println("rows effected : "+ps.executeUpdate());
		ps.close();
	}
}
