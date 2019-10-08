<%--
  Created by IntelliJ IDEA.
  User: szuter
  Date: 02-Oct-19
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="nav navbar-light bg-dark nav-fill">

    <div>
        <a class="navbar-brand" href="#">
            <img src="/docs/4.1/assets/brand/bootstrap-solid.svg" width="30" height="30"
                 class="d-inline-block align-top"
                 alt="">
            Bootstrap
        </a>

        <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
        <a class="nav-item nav-link" href="/home/add">Features</a>
        <a class="nav-item nav-link" href="#">Pricing</a>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
               data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false">
                Dropdown link
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
            </div>
        </li>
    </div>
    <form class="form-inline">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
</nav>