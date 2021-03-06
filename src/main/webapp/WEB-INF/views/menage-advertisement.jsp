<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 02-Oct-19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"/>
<main class="text-center">
    <form:form method="post" modelAttribute="data" enctype="multipart/form-data">
        <p>
            <label for="title">Tytuł</label>
            <form:input path="title" id="title"/>
            <form:errors path="title"/>
        </p>
        <p>
            <label for="image" g>Obraz</label>
            <form:hidden path="base64Image"/>
            <form:input type="file" path="image" id="image"/>
            <form:errors path="image"/>
        </p>
        <p>
            <label for="description">Opis</label><br>
            <form:textarea type="textarea" path="description" id="description"/>
            <form:errors path="description"/>
        </p>
        <p>
            <label for="expired">Data ważności ogłoszenia</label>
            <form:input path="expired" type="datetime-local" value="${actualTime}" id="expired"/>
            <form:errors path="expired"/>
        </p>
        <p>
            <input type="submit" value="Dodaj ogłoszenie"/>
            <input type="reset" value="Wyczyść"/>
        </p>
    </form:form>
</main>
<jsp:include page="footer.jsp"/>