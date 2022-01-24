<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:choose>
    <c:when test="${param.author==null}">
        <p>Nie wybrano autora</p>
    </c:when>
    <c:when test="${empty param.author}">
        <p>Nie wybrano autora</p>
    </c:when>
    <c:otherwise>
        <p>Wybrany autor ${param.author}</p>
    </c:otherwise>
</c:choose>


</body>
</html>
