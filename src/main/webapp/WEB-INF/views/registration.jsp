<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 28.09.2019
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>
<main class="text-center">
    <form:form method="post" modelAttribute="data">
        <h1 class="h3 mb-3 font-weight-normal">Zarejestruj się</h1>
        <p>
            Email:<form:input path="email" type="email"/>
            <form:errors path="email"/>
        </p>
        <p>
            Hasło:<form:input path="password" type="password"/>
            <form:errors path="password"/>
        </p>
        <p>
            Powtórz hasło:<form:input path="rePassword" type="password"/>
            <form:errors path="rePassword"/>
        </p>
        <p>
            Imię:<form:input path="firstName"/>
            <form:errors path="firstName"/>
        </p>
        <p>
            Nazwisko:<form:input path="lastName"/>
            <form:errors path="lastName"/>
        </p>
        <p>
            <input type="submit" value="Zarejestruj"/>
            <input type="reset" value="Wyczyść"/>
        </p>
    </form:form>
</main>
<jsp:include page="footer.jsp"/>
