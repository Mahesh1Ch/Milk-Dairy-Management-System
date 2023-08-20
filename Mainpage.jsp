<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<style>
.imagemain{
width:100%;
height:35%;
}
.div1{
float:left;
padding-left:10px;
padding-top:80px;
background-image:url('https://t3.ftcdn.net/jpg/01/76/47/38/360_F_176473848_7EeHiZGVbwPD6Y5wMO7fxRkKFcPZ0ysy.jpg');
text-align:center;
width:40%;
height:300px;
}
.div2{
float:rigth;
padding-left:45%;
font-size:17px;
}

marquee{
font-size:30px;
color:green;
}
h5{
font-size:40px;
text-align:center;
color:rgb(81,99,81);
background-color:rgb(92,18,92);
}
input{
background-color:rgb(18,92,18);
padding-left:30px;
padding-rigth:30px;
padding-top:5px;
padding-bottom:5px;
border-radius:15px;
font-size:18px;
}

input:hover{
background-color:rgb(81,99,78);

</style>
</head>

<body>
<h5>MilkWorld</h5>
<img  class = "imagemain" src="E:\html\dairymanagement\images\milk-dairy-software.jpg"   alt="Milk Main Page"/>
<marquee  width="70%" direction="left" hight="200px">No.1 Milk Selling And Buying Company</marquee>
<br>
<br>

<div class="div1">

<form action="loginadmin" method="post">
<input type="submit" value="Admin Login"/><br>
</form>

</div>
<div class="div2">
<p>
MilkWorld is an Indian state government cooperative under the ownership of Gujarat Cooperative Milk Marketing Federation, Ministry of Cooperation, Government of Gujarat based at Anand in Gujarat.
Formed in 1946, it is a cooperative brand managed by the Gujarat Cooperative Milk Marketing Federation Ltd. 
(GCMMF), which today is jointly controlled by 36 lakh (3.6 million) milk producers in Gujarat, and the apex body of 13 district milk unions, spread across 13,000 villages of Gujarat.
MilkWorld spurred India's White Revolution, which made the country the world's largest producer of milk and milk products.

</p>

</div>


</body>
</html>
    