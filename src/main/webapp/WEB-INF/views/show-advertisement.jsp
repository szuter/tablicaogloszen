<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 06-Oct-19
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Opis:${advertisement.description}
</div>
<div>
    Obraz:<br>
    <img src="data:image/png;base64,${advertisement.base64Image}" width="400" height="300">
</div>
<div>
    <form method="get" action="/home/comment/add">
        <input type="hidden" value="${advertisement.id}" name="id"/>
        <input type="submit" value="Dodaj komentarz"/>
    </form>
</div>
<div>
    <c:choose>
        <c:when test="${not empty comments}">
            <c:forEach var="comment" items="${comments}">
                <c:choose>
                    <c:when test="${not empty comment.user}">
                        <p>Autor: ${comment.user.firstName} ${comment.user.lastName}<br></p>
                    </c:when>
                    <c:otherwise>
                        <p>Autor: Anonim</p>
                    </c:otherwise>
                </c:choose>
                <p> Opis: ${comment.message}<br></p>
            </c:forEach>
            <br>
        </c:when>
        <c:otherwise>
            <p>Brak komentarzyu</p>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
