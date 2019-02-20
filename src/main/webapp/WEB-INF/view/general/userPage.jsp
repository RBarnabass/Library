<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>user_info</title>
    <link href="<c:url value='/resources/css/userStyle.css' />" rel="stylesheet" type="text/css">
</head>
<header>
    <nav>
        <a href="#">Sign in</a>
        <a href="#">Sign out</a>
    </nav>
    <h1>Library</h1>
</header>

<body>
<h2>Profile</h2>
<div class="user_info">
    <div class="inline-block">
        <div class="image">
            <img src="avatar.jpg" alt="avatar img">
        </div>
    </div>

    <div class="inline-block">
        <div class="table">
            <table>
                <tr>
                    <td>Name:</td>
                    <td>jsp name</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>jsp age</td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td>jsp login</td>
                </tr>
            </table>
            <p class="title">Still reading:</p>
            <p >list book</p>
        </div>
    </div>
</div>

</body>
<footer>
    Copyright by
</footer>

</html>
