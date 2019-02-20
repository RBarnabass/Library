<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>add_book</title>
    <link href="<c:url value='../../../resources/css/addBookPageStyle.css' />" rel="stylesheet" type="text/css">
</head>
<header>
    <nav>
        <a href="#">Sign in</a>
        <a href="#">Sign out</a>
    </nav>
    <h1>Library</h1>
</header>

<body>
<div class="login-page">
    <div class="form">
        <form class="register-form" method="POST" action="${pageContext.request.contextPath}/library/signup">
            <div class="one_line">
                <label for="title">Title</label>
                <input type="text" placeholder="title" name="fullName" id="title"/>
            </div>
            <div class="one_line">
                <label for="main_author">Main author</label>
                <input type="text" placeholder="main author" name="main_author" id="main_author" required/>
            </div>
            <div class="one_line">
                <label for="other_author">Other author</label>
                <input type="text" placeholder="other author" name="other_author" id="other_author"/>
            </div>
            <div class="one_line">
                <label for="publisher">Publisher</label>
                <input type="text" placeholder="publisher" name="publisher" id="publisher" required/>
            </div>
            <div class="one_line">
                <label for="year">Published year</label>
                <input type="number" placeholder="year" name="year" id="year" required/>
            </div>
            <div class="one_line">
                <label for="count">Count of copy</label>
                <input type="number" placeholder="count" name="count" id="count"/>
            </div>
            <button id="add">Add book</button>

        </form>
    </div>
</div>
</body>
<footer>
    Copyright by
</footer>

</html>