package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Dbconnect {
	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/school";
	     String user = "root";
	     String pass = "root";
		
		try {
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM student;");
			while(rs.next()) {
				Date  sqldate = rs.getDate("DOB");
				LocalDate  d = sqldate.toLocalDate();
				DateTimeFormatter fo = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String dat = d.format(fo);
				System.out.println(dat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
