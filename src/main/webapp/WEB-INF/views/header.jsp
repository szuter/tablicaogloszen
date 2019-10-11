<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!doctype html>
<html lang="pl" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.5">
    <title>Tablica Ogłoszen</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="/home">Tablica Ogłoszeń</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <c:choose>
                    <c:when test="${empty sessionScope.User}">
                        <li class="nav-item">
                            <a class="nav-link" href="/registration">Zarejestruj</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/login">Zaloguj</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    ${sessionScope.User.email}
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
<%--                                <a class="dropdown-item" href="#">Edytuj dane uzytkownika</a>--%>
                                <a class="dropdown-item" href="/home/advertisement/add">Dodaj Ogłoszenie</a>
<%--                                <a class="dropdown-item" href="#">Moje Ogłoszenia</a>--%>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/inbox">Skrzynka odbiorcza</a>
                                <a class="dropdown-item" href="/outbox">Skrzynka nadawcza</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="/logout">Wyloguj</a>
                            </div>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
<%--            <form class="form-inline my-2 my-lg-0">--%>
<%--                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">--%>
<%--                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>--%>
<%--            </form>--%>
        </div>
    </nav>
</header>