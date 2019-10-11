<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 09-Oct-19
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main class="text-center">
    <form:form method="post" modelAttribute="data">
        <label for="title">Tytuł</label>
        <form:input path="title" id="title"/>
        <form:errors path="title"/>
        <br>
        <label for="message">Wiadomość</label>
        <br>
        <form:textarea path="message" id="message"/>
        <form:errors path="message"/>
        <form:hidden path="recipient" value="${recipientId}"/>
        <br>
        <button type="submit" class="btn btn-secondary btn-lg">Wyślij</button>
    </form:form>
</main>
<jsp:include page="footer.jsp"/>