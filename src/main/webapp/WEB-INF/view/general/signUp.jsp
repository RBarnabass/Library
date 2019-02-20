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
        <form class="register-form" onsubmit="alert(validate()); return validate()" method="POST" action="${pageContext.request.contextPath}/library/signup">
            <div class="one_line">
                <label for="nameField">Full name</label>
                <input id="nameField" type="text" placeholder="name" name="fullName"/>
            </div>
            <div class="one_line">
                <label for="birthDateField">Birth date</label>
                <input id="birthDateField" type="date" placeholder="birth date" name="birthDate"/>
            </div>
            <div class="one_line">
                <label for="loginField">Login</label>
                <input id="loginField" type="text" placeholder="username" name="login"/>
            </div>
            <div class="one_line">
                <label for="passwordField">Password</label>
                <input id="passwordField" type="password" placeholder="password"/>
            </div>
            <input id="data-hashedPassword" name="data-hashedPassword" type="hidden" value="">
            <button id="signupButton">create</button>
            <p class="message">Already registered? <a href="#">Sign In</a></p>
        </form>
    </div>
</div>
<script type="text/javascript" src="../../../resources/js/sjcl.js"></script>
<script type="text/javascript" src="../../../resources/js/signup.js"></script>
<script type="text/javascript" src="../../../resources/js/validations.js"></script>
</body>

<footer>
    Copyright by
</footer>

</html>

