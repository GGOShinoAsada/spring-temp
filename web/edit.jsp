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
<heead>
    <title>edit item</title>
</heead>
<form action="/edit">
    <input type="text" name="id" placeholder="${task.id}"><br/>
    <input type="text" name="name" placeholder="${task.name}"><br/>
    <input type="text" name="description" placeholder="${task.description}"><br/>
    <input type="text" name="date" placeholder="${task.date}"><br/>
    <input type="submit" value="отправить"><br/>
    <input type="reset" value="сброс"><br/>
</form>
</html>