<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
            <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addnewseller</title>
</head>



<style>
.newuser{
margin-bottom:1%;
background-color:lightgreen;


border:1px solid;
border-radius:10%;
}
.h5first{
background-color:green;
width:100%;



padding:8px;
}
.formdiv{
margin-left:25%;
margin-right:25%;
border:2px solid;
border-style:inset;
padding-left:13%;
padding-right:13%;
padding-top:3%;
padding-bottom:5%;

}

.input{
width:100%;
padding:2%;
border:1px solid;



}

label{
font-size:190%;
}
h5{
font-size:110%;
}
.submit{
padding-left : 7%;
padding-right:7%;
padding-top:2%;
padding-bottom:2%;
background-color:green;
border-radius:9%;
}
</style>
<body>

<div  class="formdiv">
<c:if test="${user==null}">

<h5>Add  New User</h5>
</c:if>
<c:if test="${user!=null}">
<h5>Edit</h5>
</c:if>

<c:if test="${user==null}">
<form action="insertuser" method="post">
</c:if>
<c:if test="${user!=null}">
<form action="updateuser" method="post">
</c:if>
<label>UserId</label><br>
<input class="input"  type="text" value="<c:out  value='${user.userid}'  />"  name="userid" ><br>
<label>UserName</label><br>
<input  class="input" type="text"   value="<c:out value='${user.username}' />"  name="username" ><br>
<label> Date
</label><br>
<input  class="input" type="date" value="<c:out value='${user.joindate}' />"   name="joindate" ><br>
<label>PhoneNumber</label><br>
<input class="input" type="text" value="<c:out value='${user.phoneno}' />"  name="usernumber"  ><br>
<label>location[dis,mondal]</label><br>
<input class="input" type="text"  value="<c:out value ='${user.userrlocation}'/>"  name="userlocation" ><br>

<label>State</label><br>
<input class="input" type="text"  value="<c:out value ='${user.userstate}'/>"  name="userState" ><br>
<br>
<input type="submit"   class="submit"    value="Save" >

</form>
</div>

</body>

</html>