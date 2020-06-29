<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
<title>Wemo_Login</title>
<style>
/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

/* Set a style for all buttons */
button {
  display:inline-block;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 48%;
}

button.join {
  display:inline-block;
  background-color:	#1E90FF;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 48%;
  float:right;
}

button:hover {
  opacity: 0.8;
}

/* Center the image and position the close button */
.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
  position: relative;
}
img.avatar {
  width: 40%;
}
.container {
  padding: 16px;
}
/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
  border: 1px solid #888;
  width: 60%; /* Could be more or less, depending on screen size */
}
</style>
</head>
<body>
<div class="modal-content">
  
  <form  action="loginProcess" method="post">
    <div class="imgcontainer">
          <img src="resources/image/wemo.jpg" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label for="uname"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="USER_EMAIL" required>
	
      <label for="psw"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="USER_PASS" required>
        
      <button type="submit">Login</button>
      <button type="button" class="join"
      		onClick="location.href='join'">Join Us</button>
      
    </div>
  </form>
</div>

</body>
</html>