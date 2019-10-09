<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 09-Oct-19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="data">
    <label for="title">Tytuł</label>
    <form:input path="title" id="title"/>
    <form:errors path="title"/>
    <label for="message">Wiadomość</label>
    <form:input path="message" type="textarea" id="message"/>
    <form:errors path="message"/>
    <form:hidden path="recipient" value="${recipientId}"/>
    <input type="submit" value="Wyślij">
</form:form>
</body>
</html>
