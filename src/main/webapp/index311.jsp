<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2><c:out value="${welcome}"/></h2>


<form action='servlet312' method='post'>
    <select name='language'>
        <option value="">Select language</option>
        <c:forEach items="${languages}" var="language">
            <option value="${language}">${language}</option>
        </c:forEach>
    </select>
    <input type='submit'>
</form>

</body>
</html>
