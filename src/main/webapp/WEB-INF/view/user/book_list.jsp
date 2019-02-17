<%--
  Created by IntelliJ IDEA.
  User: Barnabass
  Date: 14.02.2019
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
<jsp:include page="../general/_menu.jsp"></jsp:include>
<h1>Book list</h1>

    <div>
        <c:forEach items="${bookList}" var="list">

            <pre>${list.bookId}   ${list.bookName}    ${list.publishYear}    ${list.publisherName}    ${list.primaryAuthor}   ${list.coAuthor}</pre>

            <a href="/library/book_list/is_available/${list.bookId}">is available</a>

            <h5>${available}</h5>

        </c:forEach>
    </div>

</body>
</html>
