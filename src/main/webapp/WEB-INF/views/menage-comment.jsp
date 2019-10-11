<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 08-Oct-19
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main class="text-center">
    <form:form modelAttribute="data" method="post">
        <label for="message">Komentarz</label><br>
        <form:textarea path="message" id="message"/>
        <form:errors path="message"/>
        <form:hidden path="advertisemenetId" value="${advertisementId}"/>
        <c:if test="${not empty sessionScope.User}">
            <form:hidden path="userId" value="${userId}"/>
        </c:if>
        <br>
        <button type="submit" class="btn btn-secondary">Zapisz</button>
    </form:form>
</main>
<jsp:include page="footer.jsp"/>