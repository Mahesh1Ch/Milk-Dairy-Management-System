<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Milk Seller List</title>
<style> 
body{
background-color:rgb(111,99,95);
}
.atag1{
border-radius:9%;
background-color:green;
padding:3px 3px  3px 3px;


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
float:left;
}
.div2{
float:right;
}
.div0{


width:100%;
background-color:red;

}
.div0in1{
float:right;
}


</style>
</head>
<body>


<div class="div0"><div class="div0in1">

</div></div>
<div class="admindiv">


<c:if test="${admininfo!= null}">
<h3>Admin Id:
<c:out value="${admininfo.adminid}"/>
</h3>
<h3>Admin Name:
<c:out value="${admininfo.name}"/>
</h3>
</c:if>
</div>
 <h2 >Milk Seller List</h2><br>





<div class ="div1">

</div>
<div class="div2">

</div>
<a  class="atag1" href="<%=request.getContextPath()%>/newuser">Add  New User</a> <br><br>

<table class="table">
<thread>
<tr>
<th>UserId</th>
<th>Name</th>
<th>Date</th>
<th>Phone</th>
<th>location[dis,mondal]</th>
<th>State</th>
<th>               </th>
</tr>
</thread>
<tbody>

<c:forEach  items="${userbeanTcont}"  var="userbeanTcont">
<tr>
<td><c:out   value="${userbeanTcont.userid}"/></td>
<td><c:out   value="${userbeanTcont.username}"/></td>
<td><c:out   value="${userbeanTcont.joindate}"/></td>
<td><c:out   value="${userbeanTcont.phoneno}"/></td>
<td><c:out   value="${userbeanTcont.userrlocation}"/></td>
<td><c:out   value="${userbeanTcont.userstate}"/></td>
<td>
<a  href = "milkdetails?usermilkdts=<c:out value = '${userbeanTcont.userid}'/>">Milkdetails</a>
<td>
<a   href="edituser?id=<c:out  value = '${userbeanTcont.userid}'   />" >Edit </a>

<a   href="deleteuser?id=<c:out  value = '${userbeanTcont.userid}'   />" >Delete</a>

 </td>
</tr>
</c:forEach>
</tbody>
</table>

</body>




</html>