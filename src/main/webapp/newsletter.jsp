<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>
    Lorem Ipsum
</h1>
<p1>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
    aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
    Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur
    sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
</p1>
<c:if test="${!onNewsletterList}">
    <form action="/newsletter" method="post">
        <p></br>Chcesz otrzymywać wiadomości newsletterem? Wypełnij formularz:</p>
        <Label> email:
            <input type="email" name="email"/>
        </Label>
        <label>Imię i nazwisko:
            <input type="text" name="name"/>
        </label>
        <input type="submit" value="Zapisz na newsletter">
    </form>
</c:if>

</body>
</html>
