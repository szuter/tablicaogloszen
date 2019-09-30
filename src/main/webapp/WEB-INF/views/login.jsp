<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 28.09.2019
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<form:form method="post" modelAttribute="data">
    <p>
        Email:<form:input path="email" type="email"/>
    </p>
    <p>
    Hasło:<form:input path="password" type="password"/>
    </p>
    <p>
        <input type="submit" value="Zaloguj"/>
        <input type="reset" value="Wyczyść"/>
    </p>
</form:form>
</body>
</html>
