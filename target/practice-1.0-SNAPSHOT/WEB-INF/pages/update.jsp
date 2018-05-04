<%--
  Created by IntelliJ IDEA.
  User: Radus
  Date: 02.05.2018
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form action="/update" method="post">
    <input type="" name="id" placeholder="id" value="${user.id}">
    <input type="" name="newname" placeholder="newname" value="${user.name}">
    <input type="" name="newsurname" placeholder="newsurname" value="${user.surname}">
    <select name="ids" id="">
        <option>privatBank</option>
        <option>otpBank</option>
        <option>oshadBank</option>
    </select>
    <input type="submit" name="" placeholder="">


</form>















</body>
</html>
