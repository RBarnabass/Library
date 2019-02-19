<%@ page import="com.softserve.library.app.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private User user;
%>
<jsp:include page="/WEB-INF/appearance/tiles/default/user_menu.jsp"></jsp:include>
<h2>Welcome <%= user.getFullName() %></h2>

