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
<<<<<<< HEAD
    <div class="header">
        <a href="#default" class="logo">
            <img src="<c:url value='/resources/image/logo.jpg' />" alt="logo">
        </a>
        <div class="title">
            <h1>Library</h1>
        </div>
        <div class="header-right">
            <a class="active" href="#">Home</a>
            <a href="#">Login</a>
            <a href="#">Logout</a>
        </div>
    </div>
=======
    <nav>
        <a href="#">Sign in</a>
        <a href="${pageContext.request.contextPath}/library/logout">Sign out</a>
    </nav>
    <h1>Library</h1>
>>>>>>> 1b2969c4f2f453ea968e54bf23b930206cb382ed
</header>

<body>
<h2>Profile</h2>
<div class="user_info">
    <div class="inline-block">
        <div class="image">
            <img src="<c:url value='/resources/image/avatar.jpg' />" alt="avatar img">
        </div>
    </div>

    <div class="inline-block">
        <div class="table">
            <table>
                <tr>
                    <td>Name:</td>
                    <td>${user.fullName}</td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td>${user.birthDate}</td>
                </tr>
                <tr>
                    <td>Login:</td>
                    <td>${user.login}</td>
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
