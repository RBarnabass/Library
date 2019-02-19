<div>
    <c:forEach items="${bookList}" var="list">

        <pre>${list.bookId}   ${list.bookName}    ${list.publishYear}    ${list.publisherName}    ${list.primaryAuthor}   ${list.coAuthor}</pre>

        <a href="${list.bookId}/library/book_list/is_available/">is available</a>

        <h5>${available}</h5>

    </c:forEach>
</div>