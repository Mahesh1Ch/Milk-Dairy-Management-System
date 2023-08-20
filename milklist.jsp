<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Milk List</title>
<style> 
body{
background-color:rgb(111,99,95);
background-image:url("https://3.imimg.com/data3/FS/TG/MY-10026274/dairy-management-system-500x500.jpg");
background-repeat: no-repeat;
background-position: center;
background-size:  cover;
height:100%;
width:100%;


}
h5{
width:100%;
border:2px solid black;
padding:8px;
background-color:green;
color:black;
font-style:bolt;
}
h2{
text-align:center;
}

.table{
border:1px solid black;
border-collapse:collapse;
margin-left:auto;
margin-right:auto;
background-color:rgb(111,99,95);
}

th,td{
text-align:center;
width:10%;
border:1px solid black;
border-collapse:collapse;
}
.newuser{
margin-left:210px;
margin-bottom:1%;
background-color:lightgreen;


border:1px solid;
border-radius:10%;
}

.div1{
width:40%;
text-align:left;

float:left;
}

.div2{
width:40%;
text-align:right;

float:right;
}
.adiv1,.signout{


font-size:1.3em;
padding:15px 15px 15px 15px;

border-radius:9%;
background-color:red;
}

</style>
</head>
<body>
<div class="div1">
<a   class="adiv1" href="addnewmilk?userid=<c:out  value='${milkdeoTocont[0].userid}'/>" >Add New milk</a>
</div>
<div class="div2">
<a  href="<%=request.getContextPath()%>/signout" class="signout" > Sign Out</a>
</div><br>
<c:if test="${seller!=null}">
<h3>User Id:<c:out   value  ="${seller.sId}"/> </h3>
<h3>Name   :<c:out    value ="${seller.sName}"/>  </h3>
</c:if>

 <h2 >Milk list</h2><br>








<table class="table">
<thread>
<tr>
<th>MilkId</th>
<th>Date</th>
<th>Milk type</th>
<th>Qty</th>
<th>Fat%</th>
<th>Amount</th>
<th>

</tr>
</thread>
<tbody>


<c:forEach items="${milkdeoTocont}" var="usermilk" >
<tr>
<td><c:out  value="${usermilk.milklno}"/></td>
<td><c:out   value="${usermilk.milkdate}"/></td>
<td><c:out   value="${usermilk.milkype}"/></td>
<td><c:out   value="${usermilk.milkqty}"/></td>
<td><c:out   value="${usermilk.milkfat}"/></td>
<td><c:out   value="${usermilk.milkamount}"/></td>
<td>
<a   href="editmilk?id=<c:out   value = '${usermilk.milklno}'   />&userid=<c:out  value='${usermilk.userid}'/>" > Edit</a>
<a   href="deletemilk?id=<c:out value = '${usermilk.milklno}'   />&userid=<c:out  value='${usermilk.userid}'/>" >Delete</a>

 </td>
</tr>
</c:forEach>
</tbody>
</table>
</body>




</html>