<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="public/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="LoginAction" method="POST">
            <div class="input-group">
                <label for="username">Userid</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">Login</button>
            <p>Don't have an account? <a href="public/html/registration.html">Sign up</a></p>
            
            
            <% String error = request.getParameter("error");
                if ("invalid_credentials".equals(error)) {
            %>
                <p style="color: red;">Invalid username or password. Please try again.</p>
            <%
                }
            %>
            
        </form>
    </div>
</body>
</html>
