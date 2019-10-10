<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 08-Oct-19
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="data" method="post">
    <form:input path="message"/>
    <form:errors path="message"/>
    <form:hidden path="advertisemenetId" value="${advertisementId}"/>
    <form:hidden path="userId" value="${userId}"/>
    <input type="submit" value="Zapisz"/>
</form:form>
</body>
</html>
