<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>registationlogin</title>
<style>

body{
background-color:rgb(107,97,205);
background-image:url('https://freefrontend.com/assets/img/css-background-patterns/simple-pattern-with-css3.png');
}


form{

margin: 5% 35% 10% 35%;
border-radius:15%;
padding:5% 8% 10% 5%;
background-color:rgb(215,213,230);



}
.inputtxt{
border:0;
border-radius:5%;
padding-right:30%;
padding-top:5%;
}


.buttontxt{
padding-right:40%;
padding-left:45%;
padding-top:3%;
border-radius:3%;
button-align:center;
background-color:

}
.buttontxt:hover{
color:rgb(99,104,299);
background-color:black;
}

div{
text-align:center;

}

</style>
</head>

<body>
<h3 style="text-align:center">Welcome to Recruiter login page</h3>
<form action="loginuser" method="post">
<h2 align="center">Login</h2>
<input type="text" id="username" name="number" Class="inputtxt" placeholder="UserId or Number"><br><br>
<input type="password" id="password" name="password" Class ="inputtxt" placeholder="Password"><br><br>
<div><input type="submit" id="submit" Class="buttontxt" name ="submit" value="Submit">

</form>
</body>

</html>

    