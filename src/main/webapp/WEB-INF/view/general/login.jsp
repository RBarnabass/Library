<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
    <link href="<c:url value='../../../resources/css/loginPageStyle.css' />" rel="stylesheet" type="text/css">
</head>

<header>
    <nav>
        <a href="#">Previous</a>
        <a href="#">Next</a>
        <a href="#">Sign in</a>
        <a href="#">Sign out</a>
    </nav>
    <h1>Library</h1>
</header>

<body>
<div class="login-page">
    <div class="form">
        <form class="register-form">
            <input type="text" placeholder="username"/>
            <input type="password" placeholder="password"/>
            <button>login</button>
            <p class="message">Not registered? <a href="#">Create an account</a></p>
        </form>
    </div>
</div>
</body>

<footer>
    Copyright by
</footer>

</html>


















