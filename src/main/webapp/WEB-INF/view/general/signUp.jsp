<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>registration</title>
    <link href="<c:url value='../../../resources/css/signUpPageStyle.css' />" rel="stylesheet" type="text/css">
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
                <label for="fullName">Full name</label>
                <input type="text" placeholder="name" id="fullName"/>
            </div>
            <div class="one_line">
                <label for="birthDate">Birth date</label>
                <input type="date" placeholder="birth date" id="birthDate"/>
            </div>
            <div class="one_line">
                <label for="login">Login</label>
                <input type="text" placeholder="username" id="login"/>
            </div>
            <div class="one_line">
                <label for="passwordBox">Password</label>
                <input id="passwordBox" type="password" placeholder="password"/>
            </div>
            <input id="data-hashedPassword" name="data-hashedPassword" type="hidden" value="">
            <button id="signupButton">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
    </div>
</div>
<script type="text/javascript" src="../../../resources/js/sjcl.js"></script>
<script type="text/javascript" src="../../../resources/js/hashPassword.js"></script>
</body>

<footer>
    Copyright by
</footer>

</html>

