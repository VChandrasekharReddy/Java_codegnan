<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.time.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collection" %>
<%@ page import="com.diary.model.User" %>
<%@ page import="com.diary.model.Data" %>
<%@ page import="com.diary.service.DiaryServiceImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="icon" type="image/png" href="../image/diarylogo.png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Kode+Mono:wght@400..700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="../css/newhome.css">
</head>
<body>
	<header>
        <p class="webname">Diary</p> <!--for logo-->
        <%
    	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	response.setHeader("Pragma", "no-cache");
    	response.setDateHeader("Expires", 0);
        DiaryServiceImpl service = new DiaryServiceImpl();
        List<Integer> yearlist =new ArrayList<>();
        List<LocalDateTime> localdatetime = new ArrayList<>();
        List<String> monthlist = new ArrayList<>();
        User user = (User) session.getAttribute("userdata");
        String username = (user != null) ? user.getUsername() : "Guest";
        if(!(username.equals("Guest"))){
        List<Data> datalist = new ArrayList<>(service.getdata(user.getUserid()));
        Map<LocalDate , String > matarmap = new HashMap<>();
        for(Data data:datalist){
        	localdatetime.add(data.getDate());
        	if(!yearlist.contains(data.getDate().getYear())) yearlist.add(data.getDate().getYear());
        	matarmap.put(data.getDate().toLocalDate(), data.getMater().replace("\n", "<br>"));
        }
        
 
		%>
        <div class="userdiv">  <!--for the userdetails-->
            <p class="username" id="username"><%= username %></p>
            <a href="profile.jsp" class="uslink" id="uslink"></a>
        </div>
    </header>


    <div class="maindiv">
    
        <div class="left">
        <div class="yeardsdiv">
            <%
            for(Integer year:yearlist){
            	out.print("<button class='yearbtn' id='b"+year+"' onclick='displayyeardiv("+year+")'>"+year+"</button>");
            }
            %>
            </div>
            <%
            for(Integer year: yearlist){
            	out.print("<div class='monthsdiv' id='a"+year+"'>");
            	monthlist.clear();
            	for(LocalDateTime ldt:localdatetime){
            		if(ldt.getYear()==year && !monthlist.contains(ldt.getMonth().toString())){
            			monthlist.add(ldt.getMonth().toString());            			
            		}
            	}
            	for(String month:monthlist){
            		out.print("<div class='monthdiv'><p class='mn'>"+month+"</p>");
            		for(LocalDateTime ldt:localdatetime){
            			if(ldt.getYear()==year && ldt.getMonth().toString()==month){
            				out.print("<button class='dbtn' onclick='displaydiary(\""+matarmap.get(ldt.toLocalDate())+"\")' ><p>"+(ldt.getDayOfWeek().toString()).substring(0,3)+"</p><p>"+ldt.getDayOfMonth()+"</p></button>");            			}
            		}
            		out.print("</div>");
            	}
            	
            	out.print("</div>");
            }
            out.print("</div>");
            
            %>      

        <div class="right">
            <form class="diaryfrom" id="diaryfrom" action="../../SaveDiaryServlet" method="post">
            <div class="mb">
					<%
					    String message = (String) session.getAttribute("message");
					    if (message != null) {
					        out.print("<p id='messageid' class='messagetext'>" + message + "</p>");
					        session.removeAttribute("message"); // Clear the message
					    } else {
					        out.print("<p id='messageid' class='messagetext'></p>");
					    }
					    
        }else{
        	response.sendRedirect("../../login.jsp");
        	return;
        }
					%>
					<input class="submitdiarybtn" type="submit" value="save Diary">                </div>
                <textarea id="diary-entry" name="diarydata" placeholder="Write your diary entry here..." required ></textarea>
                
            </form>
            <div class="diarydiv" id="diarydiv">
                <div class="mb">
                    <p class="messagetext"></p>
                    <button class="contentbtn" onclick="displaytextarea()">Write Today Diary</button>
                </div>
                <div class="diarycontentdiv" id="diarycontentdiv">
                    <p class="dc" id="dc"></p>
                    
                </div>
                
            </div>
        </div>
    </div>
    
    
    
   
   <script>
   
   


		   let yearlist = <%=yearlist%>;

		   function displayyeardiv(y) {
		       yearlist.forEach((year) => {
		           const element = document.getElementById('a' + year);
		           if (element) {
		               if (y == year) {
		                   element.style.display = 'flex';
		                   document.getElementById('b' + year).style.scale=1.1;// Show the div for the selected year
		               } else {
		                   element.style.display = 'none';
		                   document.getElementById('b' + year).style.scale=1;// Hide the other year divs
		               }
		           }
		       });
		   }
		   
		   
		   
		   
		 //to display the content in the rigth side of diarydiv > dc and make diaryfrom display none onclick from 70
		 function displaydiary(data) {
			 document.getElementById('diaryfrom').style.display = 'none';
			  document.getElementById('diarydiv').style.display = 'block';
			  document.getElementById('dc').innerHTML=data;
		      }
		 
		 function displaytextarea(){
			 document.getElementById('diaryfrom').style.display = 'block';
			  document.getElementById('diarydiv').style.display = 'none';
		 }
		 	   
		   //default display nones 
		       // Hide all year divs by default
		    yearlist.forEach((year) => {
		        const element = document.getElementById('a' + year);
		        if (element) {
		            element.style.display = 'none'; // Hide the divs for all years initially
		        }
		    });
		    document.getElementById('diarydiv').style.display = 'none';
		    document.getElementById('a' + yearlist[yearlist.length-1]).style.display='flex';
		    document.getElementById('b' + yearlist[yearlist.length-1]).style.scale=1.1;
			//clear the message
			        setTimeout(() => {
			        document.getElementById('messageid').innerText = '';
            
            }, 3000);
			
			
			
			        history.pushState(null, null, location.href);
			        window.onpopstate = function () {
			            history.pushState(null, null, location.href);
			        };
			        window.onload = function () {
			            history.pushState(null, null, location.href);
			            window.onpopstate = function () {
			                history.pushState(null, null, location.href);
			            };
			            location.replace(request.getContextPath() + "/public/html/home.jsp");  // Replaces the current page in history with home.jsp

			        };
			        window.onchange = function () {
			            history.pushState(null, null, location.href);
			            window.onpopstate = function () {
			                history.pushState(null, null, location.href);
			            };
			            location.replace(request.getContextPath() + "/public/html/home.jsp");  // Replaces the current page in history with home.jsp

			        };
   </script>    
    




    
</body>
</html>






















