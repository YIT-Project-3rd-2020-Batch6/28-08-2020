<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>forgot password form</title>
<link rel="stylesheet" type="text/css" href="./css/frgtstyle.css">
<body>
<a href="Login.jsp" >
      <button style="border:none;
	                outline:none;
	                 height:40px;
	                 background:#fb2525;
	                 color:#fff;
	                 font-size:18px;
					 width:100px;
	                 border-radius:3px;
					 cursor:pointer;
	                ;">Back</button>
        </a>
      <div class="forgotpassword">
      
	  <h1>Forgot password</h1>
	  <form action="ForgotServlet" method="get">
	        <p>Userid</P>
			<input type="text" name="userid" id="name" placeholder="Enter Username">
			 <p>Secrect Question</P>
			<select id="secretqsn" name="secretqsn">
			<option>Your birth place?</option>
			<option>your mothers Name?</option>
			<option>Your fathers Name?</option>
			<option>Your childhood best freind Name</option>
			<option>which sports you like to play?</option>
			</select>
			 <p> Answer</P>
			<input type="text" name="secretans" id="name" placeholder=" Secrect Question Answer">
			
			<input type ="submit" name="" value="Submit">
			
			
	  </form>
	  
      </div>

</body>
</head>
</html>