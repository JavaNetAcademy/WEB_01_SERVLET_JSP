<%-- 
    Document   : index
    Created on : 2017.11.13., 19:40:47
    Author     : krisztian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Heroes of Empire </title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <link rel="stylesheet" href="https://v4-alpha.getbootstrap.com/examples/sticky-footer/sticky-footer.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>        
    </head>
<!-- Menu -->
        <ul class="nav nav-pills">
            <li class="nav-item">
                <a class="nav-link <c:if test = "${fn:contains(pageContext.request.requestURL, 'hero')}">active</c:if>" href="hero">Hero</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <c:if test = "${fn:contains(pageContext.request.requestURL, 'location')}">active</c:if>" href="location">Location</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <c:if test = "${fn:contains(pageContext.request.requestURL, 'admin')}">active</c:if>" href="admin">Administration</a>
            </li>
            <li class="nav-item">
                <a class="nav-link <c:if test = "${fn:contains(pageContext.request.requestURL, 'work')}">active</c:if>" href="work.jsp">WorkPlace</a>
            </li>
        </ul>

        