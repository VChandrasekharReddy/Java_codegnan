<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/Entry.css">
</head>
<body>
<%!
Connection con = null;
Statement st = null;
ResultSet rs = null;
String url = "jdbc:mysql://localhost:3306/samdb";
 String user = "root";
 String pass = "root";	
%>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url , user , pass);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user;");
			
			while(rs.next()) {
				out.println("<h1>"+rs.getString("name")+"</h1></br>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}%>

</body>
</html>