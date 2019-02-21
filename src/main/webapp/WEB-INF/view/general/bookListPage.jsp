<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>bookList</title>
    <link href="<c:url value='/resources/css/bookListStyle.css' />" rel="stylesheet" type="text/css">
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
            <a href="${pageContext.request.contextPath}/library/signin">Login</a>
            <a href="${pageContext.request.contextPath}/library/logout">Logout</a>
        </div>
    </div>
</header>

<body onload='init(${fn:escapeXml(sessionScope.books)})'>
    <table>
        <caption>Statement Summary</caption>
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Publisher</th>
            <th scope="col">Publish year</th>
        </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
</div>
    <script type="text/javascript" src="../../../resources/js/bookList.js"></script>
</body>
<footer>
    Copyright by
</footer>

</html>
