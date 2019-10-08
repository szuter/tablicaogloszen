<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 02-Oct-19
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>

<c:forEach items="${advertisementList}" var="advertisement">
    <li>
        Opis:${advertisement.description}<br>
        Obraz:<br>
        <img src="data:image/png;base64,${advertisement.base64Image}" height="80" width="60">
    </li>
    <form action="/home/advertisement/show" method="get">
        <input type="hidden" name="id" value="${advertisement.id}"/>
        <input type="submit" value="Szczególy"/>
    </form>
</c:forEach>

<jsp:include page="footer.jsp"/>
</body>
</html>
