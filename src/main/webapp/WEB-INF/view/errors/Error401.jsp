<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>401</title>
    <link href="<c:url value='https://fonts.googleapis.com/css?family=Nunito:400,700' />" rel="stylesheet">

    <link href="<c:url value='/resources/css/errorStyle.css' />" rel="stylesheet" type="text/css">
</head>
<header>
    <nav>
        <a href="#">Sign in</a>
        <a href="#">Sign out</a>
    </nav>
</header>

<body>
<div id="notfound">
    <div class="notfound">
        <div class="notfound-http"></div>
        <h1>401</h1>
        <h2>Oops! Unauthorized!</h2>
        <p>Sorry but you are not authorized!</p>
        <a href="#">Back to homepage</a>
    </div>
</div>
</body>
<footer>
    Copyright by
</footer>

</html>
