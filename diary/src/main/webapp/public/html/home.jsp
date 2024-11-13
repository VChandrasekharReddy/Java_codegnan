<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.diary.model.User" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kode+Mono:wght@400..700&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary Input Area</title>
    <link rel="stylesheet" href="../css/home.css">
</head>
<body>
    <header>
        <p class="webname">Diary</p> <!--for logo-->
        <%
		    User user = (User) session.getAttribute("userdata");
		    String username = (user != null) ? user.getUsername() : "Guest";
		%>

        <div class="userdiv">  <!--for the userdetails-->
            <p class="username" id="username"><%= username %></p>
            <a href="" class="uslink" id="uslink"></a>
        </div>
    </header>


    <div class="maindiv">
        <div class="left">
            <div class="datebtns"></div>
            <div class="monthsbtns">
                
            </div>
        </div>
    <div class="right">

        <form class="diaryfrom" action="" method="post">
            <textarea id="diary-entry" placeholder="Write your diary entry here..." ></textarea>
        </form>
    </div>
    </div>
</body>
</html>
