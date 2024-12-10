<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="public/image/diarylogo.png">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="public/css/webpage.css">
    <title>Diary</title>

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


<!-- nav bar -->

        <header class="header" >
          <nav class="navbar">
            <h2 class="logo"><a href="#">Diary</a></h2>
            <input type="checkbox" id="menu-toggle" />
            <label for="menu-toggle" id="hamburger-btn">
              <svg xmlns="http://www.w3.org/2000/svg" height="24" viewBox="0 0 24 24" width="24">
                <path d="M3 12h18M3 6h18M3 18h18" stroke="currentColor" stroke-width="2" stroke-linecap="round"/>
              </svg>
            </label>
            <ul class="links">
              <li><a href="#">Home</a></li>
              <li><a href="#">Futurs</a></li>
              <li><a href="#">Services</a></li>
              <li><a href="#">Portfolio</a></li>
              <li><a href="#">Contact Us</a></li>
            </ul>
            <div class="buttons">
              <a href="public/html/registration.jsp" class="signin">Register</a>
              <a href="login.jsp" class="signup">Login</a>
            </div>
          </nav>
        </header>
        <section class="hero-section" id="hero-section">
          <div class="hero">
            <h2>Web Application</h2>
            <p>
                The Diary Application lets users securely write, save, and manage their personal entries with ease. It features an intuitive interface for effortless navigation and organized content. Accessible across devices, it provides a safe and convenient platform for journaling anytime, anywhere.
            </p>
            <div class="buttons">
              <a href="#" class="sign in">Join Now</a>
              <a href="#" class="learn">Learn More</a>
            </div>
          </div>
          <div class="img">
            <img src="public/image/diarybgiamge.png" />
          </div>
        </section>
<!-- end of the navbar and the hero section -->


<!-- divs for work -->
<section class="cards-wrapper" id="cards-wrapper">
  <div class="card-grid-space">
    <div class="num">01</div>
    <a class="card" id="card1" href="https://codewithfaraz.com/content/16/amazing-pure-css-squid-game-loaders-using-html-and-css" >
      <div>
        <h1>Secure and Personalized Diary Entries</h1>
        <p>Store your entries securely and access them privately, anytime.</p>
        <div class="date">22 July 2022</div>
        <div class="tags">
          
        </div>
      </div>
    </a>
  </div>
  <div class="card-grid-space">
    <div class="num">02</div>
    <a class="card" id="card2" href="https://codewithfaraz.com/content/2/glowing-pulse-search-bar-using-html-and-pure-css" >
      <div>
        <h1>Effortless Navigation and Organized Content</h1>
        <p>Easily browse, manage, and organize your diary with a simple interface.</p>
        <div class="date">13 July 2022</div>
        <div class="tags">
          
        </div>
      </div>
    </a>
  </div>
  <div class="card-grid-space">
    <div class="num">03</div>
    <a class="card" id="card3" href="https://codewithfaraz.com/content/1/create-a-digital-clock-using-html-css-and-javascript" >
      <div>
        <h1>Cross-Platform Access and Connectivity</h1>
        <p>Access your diary on any device, anytime, with seamless connectivity.</p>
        <div class="date">12 July 2022</div>
        <div class="tags">
          
        </div>
      </div>
    </a>
  </div>
</section>



<!-- slkkkkkkkkkkkkkkkkkkkkkk -->






<!-- footer -->

    <div class="footer">
      <div class="heading">
        <h2>Fucus<sup>™</sup></h2>
      </div>
      <div class="content">
        <div class="services">
          <h4>Other Projects</h4>
          <p><a href="https://chandrasekhar-reddy-vallapureddy.netlify.app/" target="_blank">Portfolio</a></p>
          <p><a href="#">food calory coundting system</a></p>
          <p><a href="#">Student Info System</a></p>
          <p><a href="#">inventrymanagement system jdbc</a></p>
        </div>
        <div class="social-media">
          <h4>Social</h4>
          <p>
            <a href="https://www.linkedin.com/in/chandrasekhar-reddy-vallapureddy?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app" target="_blank"
              ><i class="fab fa-linkedin"></i> Linkedin</a
            >
          </p>

          <p>
            <a href="https://github.com/VChandrasekharReddy"
              ><i class="fab fa-github"></i> Github</a
            >
          </p>
          <p>
            <a href="https://chandrasekhar-reddy-vallapureddy.netlify.app/"
              ><i class="fab fa-facebook"></i> Website</a
            >
          </p>
          <p>
            <a href="https://www.instagram.com/the_truth108_/profilecard/?igsh=ZGEyem1xOHRoeWJl"
              ><i class="fab fa-instagram"></i> Instagram</a
            >
          </p>
        </div>
        <div class="links">
          <h4>Quick links</h4>
          <p><a href="#hero-section">Home</a></p>
          <p><a href="#cards-wrapper">Features</a></p>
          <p><a href="#">Blogs</a></p>
          <p><a href="#">Contact</a></p>
        </div>
        <div class="details">
          <h4 class="address">Address</h4>
          <p>
            Lorem ipsum dolor sit amet consectetur <br />
            adipisicing elit. Cupiditate, qui!
          </p>
          <h4 class="mobile">Mobile</h4>
          <p><a href="#">+91-88973*****</a></p>
          <h4 class="mail">Email</h4>
          <p><a href="#">v.chandra.sekhar.reddy108@gmail.com</a></p>
        </div>
      </div>
      <footer>
        <hr />
        © 2024 Chandrasekhar.
      </footer>
    </div>

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


</body>
</html>




