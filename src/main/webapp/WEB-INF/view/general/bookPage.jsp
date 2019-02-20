<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>book_info</title>
    <link href="<c:url value='/resources/css/bookStyle.css' />" rel="stylesheet" type="text/css">
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
            <a class="active" href="#">Home</a>
            <a href="${pageContext.request.contextPath}/library/signin">Login</a>
            <a href="${pageContext.request.contextPath}/library/logout">Logout</a>
        </div>
    </div>
</header>

<body>
<h2>Book info</h2>
<div class="book_info">
    <div class="inline-block">
        <div class="image">
            <img src="<c:url value='/resources/image/book.jpg' /> " alt="book image">
        </div>
    </div>

    <div class="inline-block">
        <div class="table">
            <table>
                <tr>
                    <td>Title</td>
                    <td>${bookList.name}</td>
                </tr>
                <tr>
                    <td>Autor</td>
                        <c:forEach items="${bookList.authors}" var="list">
                                <pre>${list.name}</pre>
                        </c:forEach>
                </tr>
                <tr>
                    <td>Publisher</td>
                    <td>${bookList.publisher.name}</td>
                </tr>
                <tr>
                    <td>Published year</td>
                    <td>${bookList.publishYear}</td>
                </tr>
                <tr>
                    <td>Is available</td>
                    <td>jsp Is available</td>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
<footer>
    Copyright by
</footer>

</html>

