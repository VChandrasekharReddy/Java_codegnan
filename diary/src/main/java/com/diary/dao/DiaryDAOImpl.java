package com.diary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diary.model.Data;
import com.diary.model.User;

public class DiaryDAOImpl implements DiaryDAOInterface {

    private static final String URL = "jdbc:mysql://localhost:3306/diary";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String LOGIN_QUERY = "SELECT count(*) AS count FROM user WHERE userid = ? AND password = ?;";
    private static final String User_Date = "SELECT * FROM user WHERE userid = ? AND password = ?;";
    private static final String Get_Data = "SELECT * FROM  data WHERE userid = ? order by date;";

    @Override
    public boolean loginaction(String username, String password) {
        boolean isValidUser = false;
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Using try-with-resources for automatic resource management
        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = con.prepareStatement(LOGIN_QUERY)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	if(rs.getInt("count")==1) {
            		isValidUser = true;
            		break;
            	}
            }
            if(rs!=null) rs.close();
            if(con!= null) con.close();
            if(ps!=null) ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        

        return isValidUser;
    }

	@Override
	public User getuserdata(String userid, String password) {
		// TODO Auto-generated method stub
		User user = null;
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // Using try-with-resources for automatic resource management
	        try (Connection con = DriverManager.getConnection(URL, USER, PASS);
	             PreparedStatement ps = con.prepareStatement(User_Date)) {
	            ps.setString(1, userid);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	user = new User(rs.getString("userid"),rs.getString("name"),rs.getString("mobilenumber")
	            			,rs.getString("email"),rs.getString("password"),rs.getString("question")
	            			,rs.getString("answer"),rs.getTimestamp("dateofjoin").toLocalDateTime());
	            }
	            if(rs!=null) rs.close();
	            if(con!= null) con.close();
	            if(ps!=null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
	        return user; 

	}

	@Override
	public List<Data> getdata(String userid) {
		List<Data> datalist = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try (Connection con = DriverManager.getConnection(URL, USER, PASS);
	             PreparedStatement ps = con.prepareStatement(Get_Data)) {
	            ps.setString(1, userid);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()) {
	            	datalist.add(new Data(rs.getString("userid"),rs.getTimestamp("date").toLocalDateTime(),rs.getString("mater")));
	            	
	            }
	            if(rs!=null) rs.close();
	            if(con!= null) con.close();
	            if(ps!=null) ps.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		return datalist;
	}
}
