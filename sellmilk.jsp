<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sellmilk</title>
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
<c:if test="${usersell==null}">

<h5>Add Milk</h5>
</c:if>
<c:if test="${usersell != null}">
<h5>Edit Milk</h5>
</c:if>

<c:if test="${usersell==null}">
<form action="insertmilk" method="post">
</c:if>
<c:if test="${usersell!=null}">
<form action="updatemilk" method="post">
</c:if>

<label>LNO</label><br>
<input class="input"  type="text" value="<c:out  value='${usersell.milklno}'  />"  name="milklno" ><br>
<label>Qty in lts</label><br>
<input class="input"  type="text" value="<c:out  value='${usersell.milkqty}'  />"  name="milkqty" ><br>
<label>Milk type[buffolo/cow]</label><br>
<input  class="input" type="text"  value="<c:out value='${usersell.milkype}' />"  name="milktype" ><br>
<label> Date
</label><br>
<input  class="input" type="date" value="<c:out value='${usersell.milkdate}' />"   name="milkdate" ><br>
<label>fat%</label><br>
<input class="input" type="text" value="<c:out value='${usersell.milkfat}' />"  name="milkfat"  ><br>
<label>Amount</label><br>
<input class="input" type="text"  value="<c:out value ='${usersell.milkamount}'/>"  name="milkamount" ><br>
<c:if test="${userid!=null}">
<input class="input" type="hidden" value="<c:out value='${userid}'/>" name="userid"><br>
</c:if>
<c:if test="${usersell!=null}">
<input class="input" type="hidden" value="<c:out value='${usersell.userid}'/>" name="userid"/><br>
</c:if>

<input type="submit"   class="submit"    value="Save" >

</form>
</div>

</body>

</html>