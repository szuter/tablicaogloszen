<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 09-Oct-19
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main>
    <c:forEach var="message" items="${inbox}">

        <hr>
        <h2>Od: ${message.sender.firstName} ${message.sender.lastName} Tytuł: ${message.title}</h2><br>
        ${message.message}
        <hr>
    </c:forEach>
</main>
<jsp:include page="footer.jsp"/>