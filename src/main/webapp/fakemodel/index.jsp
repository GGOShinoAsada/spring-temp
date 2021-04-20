<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 20.04.2021
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<h3><a href="/new">new model</a> </h3>
<table>
    <thead>
        <th>#</th>
        <th>Name</th>
        <th>Description</th>
        <th>Details</th>
        <th>Update</th>
        <th>Delete</th>
    </thead>
    <c:choose>
        <c: test="${fn:length(item) gt 0}" >
           <c:when test="${models gt 0}">
            <c:forEach var="item" items="${item}">
               <c:url value="/fakemodel/${item.id}" var="taskdetails"></c:url>
               <c:url value="/fakemodel/${itemid}" var="updatetask"></c:url>
               <c:url value="/fakemodel/${item.id}?delete" var="deletetask"></c:url>
                    <tr>
                        <td><c:out value="item.id"></c:out></td>
                        <td><c:out value="item.name"></c:out></td>
                        <td><c:out value="item.description"/></td>
                        <td><a href="${taskdetails}">details</a> </td>
                        <td><a href="${updatetask}">update</a> </td>
                        <td><a href="${deletetask}">delete</a> </td>
                    </tr>
               </c:forEach>
            
        </c:when>
        <c:otherwise>
            
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>
