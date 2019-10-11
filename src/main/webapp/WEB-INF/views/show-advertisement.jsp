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
<jsp:include page="header.jsp"/>
<br>
<main>
    <ul class="list-inline">
        <li class="list-inline-item"><h2>${advertisement.title}</h2></li>

        <li class="list-inline-item float-right">
            <c:choose>
                <c:when test="${advertisement.user.id == sessionScope.User.getId()}">
                    <form method="get" action="/home/advertisement/edit">
                        <input type="hidden" value="${advertisement.id}" name="id">
                        <button type="submit" class="btn btn-secondary">Edytuj</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="btn-group">
                        <div class="btn-group" role="group" aria-label="Basic example">
                            <c:if test="${not empty sessionScope.User and advertisement.user.id != sessionScope.User.getId()}">
                                <form method="get" action="/message/send">
                                    <input type="hidden" value="${advertisement.user.id}" name="recipientId">
                                    <button type="submit" class="btn btn-secondary">Wyslij widaomość</button>
                                </form>
                            </c:if>
                            <form method="get" action="/home/comment/add">
                                <input type="hidden" value="${advertisement.id}" name="id"/>
                                <button type="submit" class="btn btn-secondary">Dodaj komentarz</button>
                            </form>
                        </div>

                    </div>
                </c:otherwise>
            </c:choose>
        </li>
    </ul>
    <ul class="list-inline-item float-right">Data ważności:${advertisement.expired}</ul>
    <ul class="list-inline">
        <li class="list-inline-item"><img src="data:image/png;base64,${advertisement.base64Image}" width="400"
                                          height="300"></li>
        <li class="list-inline-item">${advertisement.description}</li>
    </ul>

    <c:choose>
        <c:when test="${not empty comments}">
            <table class="table table-bordered table-dark table-striped">
                <thead>
                <tr class="text-center">
                    <th scope="col">Komentarze</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="comment" items="${comments}">
                    <tr>
                        <th scope="row">
                            <ul>
                                <ul class="list-inline">
                                    <li class="list-inline-item">
                                        <c:choose>
                                            <c:when test="${not empty comment.user}">
                                                Autor: ${comment.user.firstName} ${comment.user.lastName}
                                            </c:when>
                                            <c:otherwise>
                                                Autor: Anonim
                                            </c:otherwise>
                                        </c:choose>
                                    </li>
                                    <li class="list-inline-item float-right">
                                        <c:if test="${comment.user.id == sessionScope.User.getId() and  not empty sessionScope.User}">
                                            <form action="/home/comment/edit" method="get">
                                                <input type="hidden" value="${comment.id}" name="id">
                                                <button type="submit" class="btn btn-secondary">Edytuj</button>
                                            </form>
                                        </c:if>
                                    </li>
                                </ul>
                                <ul>Komentarz:</ul>
                                <ul>${comment.message}<br></ul>
                            </ul>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:when>
        <c:otherwise>
            <table class="table table-bordered table-dark table-striped">
                <thead>
                <tr class="text-center">
                    <th scope="col">Komentarze</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">Brak komentarzy</th>
                </tr>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"/>