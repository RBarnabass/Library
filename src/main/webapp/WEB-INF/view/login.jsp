<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>

<body>

    <h1>Hello</h1>

    <div class="form">

        <form method="post" action="login">

            <input type="text" required placeholder="login" name="login"><br>
            <input type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="Enter"> ${message}

        </form>

    </div>

</body>

</html>
