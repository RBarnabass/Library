<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
          integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+" crossorigin="anonymous">

    <link href="<c:url value=' /static/css/style.css' />" rel="stylesheet">

</head>

<body>

<section id="menu">
    <tiles:insertAttribute name="menu"/>
</section>

<header id="header">
    <tiles:insertAttribute name="header"/>
</header>

<section id="site-content">
    <tiles:insertAttribute name="body"/>
</section>

<footer class="container-fluid footer text-center">
    <tiles:insertAttribute name="footer"/>
</footer>

</body>


</html>