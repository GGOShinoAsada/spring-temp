<%--
  Created by IntelliJ IDEA.
  User: roman
  Date: 19.04.2021
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>task details</h3>
<p>id <c:out value="task.id"/></p><br/>
<p>name <c:out value="task.name"/></p>
<p>description <c:out value="task.description"/></p>
<p>date <c:out value="task.date"/></p>
</body>
</html>
