<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 19.04.2021
  Time: 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/create">Create new</a>
<table>
    <thead>
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>date</th>
        <td></td>
    </thead>
    <tbody>
        <c:forEach items="items" var="item">
            <td><c:out value="item.id"/></td>
            <td><c:out value="item.name"/><</td>
            <td><c:out value="item.description"/></td>
            <td><c:out value="item.date"/></td>
            <td><a href="/edit?id=${item.id}"/>edit item</td>
            <td><a href="/details?id=${item.id}">Details </a></td>
            <td><c:out value="/delete?id=${item.id}"/></td>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
