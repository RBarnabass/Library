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
    <nav>
        <a href="#">Sign in</a>
        <a href="#">Sign out</a>
    </nav>
    <h1>Library</h1>
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

