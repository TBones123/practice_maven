<%--
  Created by IntelliJ IDEA.
  User: Radus
  Date: 01.05.2018
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form action="/save" method="post">
    <input type="text" name="username" placeholder="username">
    <input type="text" name="surname" placeholder="surname">
    <select name="id" id="">
        <option>privatBank</option>
        <option>otpBank</option>
        <option>oshadBank</option>
    </select>
    <input type="submit" name="" placeholder="">
</form>
<%--${allUsers}--%>
<ul>
    <c:forEach items="${allUsers}" var="user">
        <li>
                ${user.name} ${user.surname} ${user.department}
            <a href="/delete/${user.id}">
                <button>delete</button>
            </a>
                    <a href="/update/${user.id}">
                <button>update</button>
            </a>
        </li>
    </c:forEach>
</ul>


</body>
</html>
