<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>advanced</title>
    <link href="<c:url value='/resources/css/advancedSearchStyle.css' />" rel="stylesheet" type="text/css">
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
            <a class="active" href="#">Home</a>
            <a href="#">Login</a>
            <a href="#">Logout</a>
        </div>
    </div>
</header>

<body>
<div class="booklist-page">
    <div class="form">
        <form method="POST" action="${pageContext.request.contextPath}/library/book_list">
            <div class="inform">
                <div class="one_line">
                    <label for="book">Book title</label>
                    <input type="text" name="book" id="book" ><br>
                </div>
                <div class="one_line">
                    <label for="author">Author</label>
                    <input type="text" name="author" id="author" ><br>
                </div>
                <div class="one_line">
                    <label for="publisher">Publisher</label>
                    <input type="text" name="publisher" id="publisher" ><br>
                </div>
                <!-- <div class="date_container"> -->
                <div class="one_line">
                    <label for="from">Publish year from</label>
                    <input type="number" min="1900" max="2099" step="1" name="from" id="from" ><br>
                </div>
                <div class="one_line"> <label for="to">Publish year to</label>
                    <input type="number" min="1900" max="2099" step="1" name="to" id="to" ><br>
                    <!-- </div> -->
                </div>
                <label for="available">Available</label>
                <input type="checkbox" checked="" name="available" value="true" id="available">
            </div>
            <button>search</button>

        </form>
    </div>
</div>

</body>
<footer>
    Copyright by
</footer>

</html>
