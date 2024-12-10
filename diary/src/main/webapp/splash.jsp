<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Heart Shape Preloader | CodingNepal</title>
      <style>
      .container{
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
  .container .preloader{
    animation: rotate 2.3s cubic-bezier(0.75, 0, 0.5, 1) infinite;
  }
  @keyframes rotate {
    50%{
      transform: rotate(360deg);
    }
    100%{
      transform: rotate(720deg);
    }
  }
  .preloader span{
    position: absolute;
    display: block;
    height: 64px;
    width: 64px;
    background: #3fc1f2;
    border: 1px solid #3fc1f2;
    border-radius: 100%;
  }
  .preloader span:nth-child(1){
    transform: translate(-28px, -28px);
    animation: shape_1 2.3s cubic-bezier(0.75, 0, 0.5, 1) infinite;
  }
  @keyframes shape_1 {
    60%{
      transform: scale(0.4);
    }
  }
  .preloader span:nth-child(2){
    transform: translate(28px, -28px);
    animation: shape_2 2.3s cubic-bezier(0.75, 0, 0.5, 1) infinite;
  }
  @keyframes shape_2 {
    40%{
      transform: scale(0.4);
    }
  }
  .preloader span:nth-child(3){
    position: relative;
    border-radius: 0px;
    transform: scale(0.98) rotate(-45deg);
    animation: shape_3 2.3s cubic-bezier(0.75, 0, 0.5, 1) infinite;
  }
  @keyframes shape_3 {
    50%{
      border-radius: 100%;
      transform: scale(0.5) rotate(-45deg);
    }
    100%{
      transform: scale(0.98) rotate(-45deg);
    }
  }
  .shadow{
    position: relative;
    top: 30px;
    left: 50%;
    transform: translateX(-50%);
    display: block;
    height: 16px;
    width: 64px;
    border-radius: 50%;
    background-color: #d9d9d9;
    border: 1px solid #d9d9d9;
    animation: shadow 2.3s cubic-bezier(0.75, 0, 0.5, 1) infinite;
  }
  @keyframes shadow {
    50%{
      transform: translateX(-50%) scale(0.5);
      border-color: #f2f2f2;
    }
  }
      
      </style>
   </head>
   
   <body>
   
   
   
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
    if (session != null && session.getAttribute("userdata") != null) {
        // User is already logged in, redirect to home
        response.sendRedirect(request.getContextPath() + "/public/html/home.jsp");
        return;
    }
%>
   
   
      <div class="container">
         <div class="preloader">
            <span></span>
            <span></span>
            <span></span>
         </div>
         <div class="shadow"></div>
      </div>
   </body>
   <script>
    setTimeout(() => {
        window.location.href = "webpage.jsp"; // Replace with your login page URL
      }, 3000); // 2000 milliseconds = 2 seconds
   </script>
       <script>
	
 // Prevent the user from navigating back to the previous page
    window.onload = function () {
        // Push the current page to the history stack
        history.pushState(null, null, location.href);
        
        // Listen for when the user tries to go back, and push the current page again
        window.onpopstate = function () {
            history.pushState(null, null, location.href);
        };
    };
    
    </script>
</html>