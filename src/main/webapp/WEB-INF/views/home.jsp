<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 02-Oct-19
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="header.jsp"/>
<main>

    <table class="table table-bordered table-dark table-striped">
        <thead>
        <tr class="text-center">
            <th scope="col">Obraz</th>
            <th scope="col">Tytuł</th>
            <th scope="col">Akcja</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${advertisementList}" var="advertisement">
            <tr>
                <th scope="row" class="text-center"><img src="data:image/png;base64,${advertisement.base64Image}" height="60" width="80">
                </th>
                <td class="text-center">${advertisement.title}</td>
                <td>
                    <form action="/home/advertisement/show" method="get">
                        <input type="hidden" name="id" value="${advertisement.id}"/>
                        <button type="submit" class="btn btn-secondary btn-lg btn-block">Szczegóły</button>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>


</main>
<jsp:include page="footer.jsp"/>

