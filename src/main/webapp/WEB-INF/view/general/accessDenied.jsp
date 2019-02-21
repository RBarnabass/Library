<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</html>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>access denied</title>
    <link href="<c:url value='https://fonts.googleapis.com/css?family=Nunito:400,700' />" rel="stylesheet">

    <link href="<c:url value='/resources/css/errorStyle.css' />" rel="stylesheet" type="text/css">
</head>
<header>
    <div class="header">
        <a href="#default" class="logo">
            <img src="<c:url value='/resources/image/logo.jpg' />" alt="logo">
        </a>
        <div class="title">
            <h1>Library</h1>
        </div>
        <div class="header-right">
            <a class="active" href="${pageContext.request.contextPath}/library/info">Home</a>
            <a></a>
            <a class="active" href="${pageContext.request.contextPath}/library/bookSearch">Search</a>
            <a></a>
            <a class="active" href="${pageContext.request.contextPath}/library/book_list">Books</a>
            <a></a>
            <a class="active" href="${pageContext.request.contextPath}/library/book_add">Add book</a>
            <a></a>
            <a href="${pageContext.request.contextPath}/library/signin">Login</a>
            <a href="${pageContext.request.contextPath}/library/logout">Logout</a>
        </div>
    </div>
</header>

<body>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-http"></div>
        <h1>No Access</h1>
        <h2>Oops! Access Denied!</h2>
        <a href="#">Back to homepage</a>
    </div>
</div>
</body>
<footer>
    Copyright by
</footer>

</html>
