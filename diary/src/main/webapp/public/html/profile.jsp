<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.diary.model.Data" %>
    <%@ page import="com.diary.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary</title>
    <link rel="stylesheet" href="../css/profile.css">
</head>
<body>
	<%
	 	User user = (User) session.getAttribute("userdata");
	%>
    <div class="userdiv">
        <img src="../image/userimg.png" alt="">
        <div class="userdata">
            <div class="datadiv">
                <p class="key">User Id</p>
                <p class="value"><%=user.getUserid() %></p>
                <button></button>
            </div>
            <div class="datadiv">
                <p class="key">User Name</p>
                <p class="value"><%=user.getUsername() %></p>
                <button></button>
            </div>
            <div class="datadiv">
                <p class="key">Mobile Number</p>
                <p class="value"><%=user.getMobilenumber() %></p>
                <button></button>
            </div>
            <div class="datadiv">
                <p class="key">Email</p>
                <p class="value"><%=user.getEmail() %></p>
                <button></button>
            </div>
            <div class="datadiv">
                <p class="key">DateOfBirth</p>
                <p class="value"><%=user.getDataofbirth() %></p>
                <button></button>
            </div>
            <div class="datadiv">
                <p class="key">Created At</p>
                <p class="value"><%=user.getDateofjoin() %></p>
                
            </div>
            <div class="datadiv">
                <p class="key">Active days </p>
                <p class="value"><%=user.getActivedays() %></p>
            </div>
            <div class="datadiv">
                <p class="key">Your Password</p>
                <p class="value"><%=user.getPassword() %></p>
                <button></button>
            </div>
        </div>
    </div>





    <!-- this divs are for edit the data for the button on click -->

    


</body>
</html>