<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 09-Oct-19
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="message" items="${outbox}">
    Odbiorca:${message.recipient.firstName} ${message.recipient.lastName}<br>
    Tytuł:${message.title}<br>
    Wiadomość:${message.message}<br>
    <br>
</c:forEach>

</body>
</html>
