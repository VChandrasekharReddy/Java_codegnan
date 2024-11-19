package com.diary.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.diary.model.Data;
import com.diary.model.User;

public class DiaryDAOImpl implements DiaryDAOInterface {
    private static final String URL = "jdbc:mysql://localhost:3306/diary";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String LOGIN_QUERY = "SELECT count(*) AS count FROM user WHERE userid = ? AND password = ?;";
    private static final String User_Data = "SELECT * FROM user WHERE userid = ? AND password = ?;";
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
	             PreparedStatement ps = con.prepareStatement(User_Data)) {
	            ps.setString(1, userid);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            int activedays = 0;
	            PreparedStatement pss = con.prepareStatement("select count(*) as count from data where userid =?;");
	            pss.setString(1, userid);
	            ResultSet rss = pss.executeQuery();
	            if(rss.next()) {
	            	activedays = rss.getInt("count");
	            }
	            if(rss!=null)rss.close();
	            if(pss!= null) pss.close();
	            while(rs.next()) {
	            	user = new User(rs.getString("userid"),rs.getString("name"),rs.getString("mobilenumber")
	            			,rs.getString("email"),rs.getString("password"),rs.getString("question")
	            			,rs.getString("answer"),rs.getTimestamp("dateofjoin").toLocalDateTime(),rs.getTimestamp("dofb").toLocalDateTime().toLocalDate(),activedays);
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

	@Override
	public boolean adddiary(String userid, LocalDate date, String mater) {
		// TODO Auto-generated method stub
		boolean status = false;
		boolean exists = false;
		String content = mater;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection(URL, USER, PASS)){
			PreparedStatement ps = con.prepareStatement("SELECT mater FROM data WHERE userid = ? AND DATE(date) = ?");
            ps.setString(1, userid);
            ps.setDate(2, Date.valueOf(date));
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
            	 content = rs.getString("mater") + "\n" + content;
                 exists = true;
            }

            if (ps != null) ps.close();
            if (rs != null) rs.close();
            if (exists) {
                ps = con.prepareStatement("UPDATE data SET mater = ? WHERE userid = ? AND DATE(date) = ?");
                ps.setString(1, content);
                ps.setString(2, userid);
                ps.setDate(3, Date.valueOf(date));
                boolean tem = ps.executeUpdate()>0;
                if(tem) status = true;
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } else {
                ps = con.prepareStatement("INSERT INTO data (userid, mater) VALUES (?, ?)");
                ps.setString(1, userid);
                ps.setString(2, content);
                boolean rows = ps.executeUpdate()>0;
                if(rows) status=true;
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            }
            
            
            
            
            
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}








































